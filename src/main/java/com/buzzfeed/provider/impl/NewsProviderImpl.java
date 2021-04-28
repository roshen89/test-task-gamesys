package com.buzzfeed.provider.impl;

import com.buzzfeed.data.RssData;
import com.buzzfeed.provider.NewsProvider;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NewsProviderImpl implements NewsProvider {

  @Value("${news.source}")
  private String source;

  @Override
  public List<RssData> getLastNews() {
    try (var reader = new XmlReader(new URL(source))) {
      SyndFeed feed = new SyndFeedInput().build(reader);
      return feed.getEntries()
          .stream()
          .map(this::buildRssData)
          .collect(Collectors.toList());
    } catch (IOException | FeedException e) {
      log.error("Error happened when getting last updates: ", e);
      throw new RuntimeException(e);
    }
  }

  private RssData buildRssData(SyndEntry entry) {
    return RssData.builder()
        .title(entry.getTitle())
        .description(entry.getDescription().getValue())
        .uri(entry.getUri())
        .publishedDate((entry.getPublishedDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
        .insertedDate(LocalDateTime.now())
        .build();
  }
}

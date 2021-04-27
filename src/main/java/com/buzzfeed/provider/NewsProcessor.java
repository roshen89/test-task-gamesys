package com.buzzfeed.provider;

import com.buzzfeed.mapper.NewsMapper;
import com.buzzfeed.service.NewsService;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class NewsProcessor {

  private static final NewsMapper MAPPER = NewsMapper.INSTANCE;
  private final NewsProvider provider;
  private final NewsService service;

  public void processNews() {
    var lastNews = provider.getLastNews()
        .stream()
        .map(MAPPER::toNews)
        .collect(Collectors.toList());
    log.info("Fetched {} news.", lastNews.size());
    service.saveNews(lastNews);
  }
}

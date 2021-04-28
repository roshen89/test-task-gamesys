package com.buzzfeed.provider.impl;

import com.buzzfeed.mapper.NewsMapper;
import com.buzzfeed.provider.NewsProcessor;
import com.buzzfeed.provider.NewsProvider;
import com.buzzfeed.service.NewsService;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class NewsProcessorImpl implements NewsProcessor {

  private static final NewsMapper MAPPER = NewsMapper.INSTANCE;
  private final NewsProvider provider;
  private final NewsService service;

  @Override
  public void processNews() {
    var lastNews = provider.getLastNews()
        .stream()
        .map(MAPPER::toNews)
        .collect(Collectors.toList());
    log.info("Fetched {} news.", lastNews.size());
    service.saveNews(lastNews);
  }
}

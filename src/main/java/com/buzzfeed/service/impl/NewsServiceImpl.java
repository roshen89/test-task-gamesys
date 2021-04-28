package com.buzzfeed.service.impl;

import com.buzzfeed.data.NewsDTO;
import com.buzzfeed.entity.News;
import com.buzzfeed.mapper.NewsMapper;
import com.buzzfeed.repository.NewsRepository;
import com.buzzfeed.service.NewsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsServiceImpl implements NewsService {

  @Value("${news.limit}")
  private Integer limit;

  private static final NewsMapper newsMapper = NewsMapper.INSTANCE;
  private final NewsRepository repository;

  @Override
  public List<NewsDTO> getLastNews() {
    return newsMapper.toNewsDTOs(repository.findLastNews(limit));
  }

  @Override
  public void saveNews(List<News> news) {
    repository.saveAll(news);
  }
}

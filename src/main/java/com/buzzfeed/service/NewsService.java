package com.buzzfeed.service;

import com.buzzfeed.data.NewsDTO;
import com.buzzfeed.entity.News;
import com.buzzfeed.mapper.NewsMapper;
import com.buzzfeed.repository.NewsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsService {

  @Value("${news.limit}")
  private Integer limit;

  private static final NewsMapper newsMapper = NewsMapper.INSTANCE;
  private final NewsRepository repository;

  public List<NewsDTO> getLastNews() {
    return newsMapper.toNewsDTOs(repository.findLastNews(limit));
  }

  public void saveNews(List<News> news) {
    repository.saveAll(news);
  }
}

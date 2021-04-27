package com.buzzfeed.repository;

import com.buzzfeed.entity.News;
import java.util.List;

public interface NewsRepository {

  List<News> findLastNews(Integer limit);

  void saveAll(final List<News> newsEntityList);
}

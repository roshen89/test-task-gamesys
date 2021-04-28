package com.buzzfeed.repository;

import com.buzzfeed.entity.News;
import java.util.List;

public interface NewsRepository {

  /**
   * Method finds last news from db
   * @param limit - for limitation
   */
  List<News> findLastNews(Integer limit);

  /**
   * Method saves all newsList to db
   * @param newsList - the newsList for saving
   */
  void saveAll(final List<News> newsList);
}

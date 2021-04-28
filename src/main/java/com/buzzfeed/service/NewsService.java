package com.buzzfeed.service;

import com.buzzfeed.data.NewsDTO;
import com.buzzfeed.entity.News;
import java.util.List;

/**
 * Service is responsible to save and get news.
 */
public interface NewsService {

  /**
   * Method is for getting latest news.
   *
   * @return List<NewsDTO>
   */
  List<NewsDTO> getLastNews();

  /**
   * Method is for saving list of news.
   *
   * @param news - list of news for saving to db.
   */
  void saveNews(List<News> news);
}

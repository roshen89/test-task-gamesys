package com.buzzfeed.provider;

import com.buzzfeed.data.NewsData;
import java.util.List;

/**
 * Responsible to provide latest news.
 */
public interface NewsProvider {

  /**
   * Method is for getting last news.
   *
   * @return List<NewsData>
   */
  List<NewsData> getLastNews();
}

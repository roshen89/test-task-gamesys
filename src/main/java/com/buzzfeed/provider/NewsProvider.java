package com.buzzfeed.provider;

import com.buzzfeed.data.RssData;
import java.util.List;

/**
 * Responsible to connect rss and provide latest news.
 */
public interface NewsProvider {

  /**
   * Method is for getting last news.
   *
   * @return List<RssData>
   */
  List<RssData> getLastNews();
}

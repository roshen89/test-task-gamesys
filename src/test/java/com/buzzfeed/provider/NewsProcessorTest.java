package com.buzzfeed.provider;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.buzzfeed.data.NewsData;
import com.buzzfeed.entity.News;
import com.buzzfeed.service.NewsService;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class NewsProcessorTest {

  private NewsProvider providerMock;
  private NewsService service;
  private NewsProcessor processor;

  @Before
  public void init() {
    providerMock = mock(NewsProvider.class);
    service = mock(NewsService.class);
    processor = new NewsProcessor(providerMock, service);
  }

  @Test
  public void testProcessNews() {
    //given
    final var newsDataList = List.of(getNewsData());
    final var newsList = List.of(getNews());

    when(providerMock.getLastNews()).thenReturn(newsDataList);

    //when
    processor.processNews();

    //then
    verify(service).saveNews(newsList);
    verify(providerMock).getLastNews();
  }

  private News getNews() {
    return News.builder()
        .title("Title of news")
        .description("Desc of news")
        .uri("uri")
        .publishedDate(LocalDateTime.of(2021, 4, 26, 16, 30))
        .insertedDate(LocalDateTime.of(2021, 4, 27, 17, 20))
        .build();
  }

  private NewsData getNewsData() {
    return NewsData.builder()
        .title("Title of news")
        .description("Desc of news")
        .uri("uri")
        .publishedDate(LocalDateTime.of(2021, 4, 26, 16, 30))
        .insertedDate(LocalDateTime.of(2021, 4, 27, 17, 20))
        .build();
  }
}

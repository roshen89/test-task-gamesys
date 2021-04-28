package com.buzzfeed.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.buzzfeed.data.NewsDTO;
import com.buzzfeed.entity.News;
import com.buzzfeed.repository.impl.NewsRepositoryImpl;
import com.buzzfeed.service.impl.NewsServiceImpl;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class NewsServiceImplTest {

  private NewsRepositoryImpl repositoryMock;
  private NewsServiceImpl service;

  @Before
  public void init() {
    repositoryMock = mock(NewsRepositoryImpl.class);
    service = new NewsServiceImpl(repositoryMock);
  }

  @Test
  public void testFindLastNews() {
    //given
    final var newsList = List.of(getNews());
    final var expected = List.of(getNewsDto());

    when(repositoryMock.findLastNews(any())).thenReturn(newsList);

    //when
    final var actual = service.getLastNews();

    //then
    assertNotNull(actual);
    assertEquals(expected, actual);
    verify(repositoryMock).findLastNews(any());
  }

  @Test
  public void testSaveNews() {
    //given
    final var newsList = List.of(getNews());

    //when
    service.saveNews(newsList);

    //then
    verify(repositoryMock).saveAll(newsList);
  }

  private News getNews() {
    return News.builder()
        .title("Title of news")
        .description("Description of news")
        .uri("uri of news")
        .publishedDate(LocalDateTime.of(2021, 4, 26, 22, 10))
        .insertedDate(LocalDateTime.of(2021, 4, 27, 22, 50))
        .build();
  }

  private NewsDTO getNewsDto() {
    return NewsDTO.builder()
        .title("Title of news")
        .description("Description of news")
        .uri("uri of news")
        .publishedDate("2021-04-26T22:10:00")
        .insertedDate("2021-04-27T22:50:00")
        .build();
  }
}

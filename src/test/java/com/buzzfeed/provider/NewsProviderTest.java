package com.buzzfeed.provider;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import org.junit.Test;

public class NewsProviderTest {

  private final NewsProvider newsProvider = new NewsProvider();

  @Test
  public void testGetLastUpdates_success() {
    //given
    setField(newsProvider, "source", "https://www.buzzfeed.com/world.xml");

    //when
    final var result = newsProvider.getLastNews();

    //then
    assertTrue(result.size() > 0);
    assertNotNull(result.get(3).getTitle());
    assertNotNull(result.get(3).getDescription());
    assertNotNull(result.get(3).getUri());
    assertNotNull(result.get(3).getPublishedDate());
    assertNotNull(result.get(3).getInsertedDate());
  }

  @Test
  public void testGetLastUpdates_throwsException() {
    //given
    setField(newsProvider, "source", "uri.xml");

    //when-then
    assertThrows(RuntimeException.class, newsProvider::getLastNews);
  }
}

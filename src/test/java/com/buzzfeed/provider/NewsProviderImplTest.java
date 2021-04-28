package com.buzzfeed.provider;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import com.buzzfeed.provider.impl.NewsProviderImpl;
import org.junit.Test;

public class NewsProviderImplTest {

  private final NewsProviderImpl newsProviderImpl = new NewsProviderImpl();

  @Test
  public void testGetLastNews_success() {
    //given
    setField(newsProviderImpl, "source", "https://www.buzzfeed.com/world.xml");

    //when
    final var result = newsProviderImpl.getLastNews();

    //then
    assertTrue(result.size() > 0);
    assertNotNull(result.get(3).getTitle());
    assertNotNull(result.get(3).getDescription());
    assertNotNull(result.get(3).getUri());
    assertNotNull(result.get(3).getPublishedDate());
    assertNotNull(result.get(3).getInsertedDate());
  }

  @Test
  public void testGetLastNews_throwsException() {
    //given
    setField(newsProviderImpl, "source", "uri.xml");

    //when-then
    assertThrows(RuntimeException.class, newsProviderImpl::getLastNews);
  }
}

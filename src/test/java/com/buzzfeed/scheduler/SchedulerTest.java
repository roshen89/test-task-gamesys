package com.buzzfeed.scheduler;

import static org.mockito.Mockito.verify;

import com.buzzfeed.provider.impl.NewsProcessorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SchedulerTest {

  @InjectMocks
  private Scheduler underTest;
  @Mock
  private NewsProcessorImpl processor;

  @Test
  public void testScheduler() {
    underTest.execute();

    verify(processor).processNews();
  }
}

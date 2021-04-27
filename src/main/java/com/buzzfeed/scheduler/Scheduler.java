package com.buzzfeed.scheduler;

import static java.time.LocalDateTime.now;

import com.buzzfeed.provider.NewsProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
@RequiredArgsConstructor
public class Scheduler {

  private final NewsProcessor newsProcessor;

  @Scheduled(
      fixedDelayString = "${news.schedule.delay.fixed}",
      initialDelayString = "${news.schedule.delay.initial}"
  )
  public void newsScheduler() {
    log.info("Started at: {}", now());
    newsProcessor.processNews();
    log.info("Getting news completed.");
  }

}
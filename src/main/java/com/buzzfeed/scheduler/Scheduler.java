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

  private final NewsProcessor processor;

  @Scheduled(
      fixedDelayString = "${news.schedule.delay.fixed}",
      initialDelayString = "${news.schedule.delay.initial}"
  )
  public void execute() {
    log.info("Started at: {}", now());
    processor.processNews();
  }

}

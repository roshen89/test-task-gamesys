package com.buzzfeed.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class News {

  private String title;
  private String description;
  private String uri;
  private LocalDateTime publishedDate;
  private LocalDateTime insertedDate;
}

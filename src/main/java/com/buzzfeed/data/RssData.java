package com.buzzfeed.data;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RssData {

  private String title;
  private String description;
  private String uri;
  private LocalDateTime publishedDate;
  private LocalDateTime insertedDate;
}

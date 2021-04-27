package com.buzzfeed.data;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO implements Serializable {

  private String title;
  private String description;
  private String uri;
  private String publishedDate;
  private String insertedDate;
}

package com.buzzfeed.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestResponse<T> {

  private T data;
}

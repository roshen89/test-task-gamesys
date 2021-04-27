package com.buzzfeed.api;

import com.buzzfeed.data.NewsDTO;
import com.buzzfeed.data.RestResponse;
import com.buzzfeed.service.NewsService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/news")
@RequiredArgsConstructor
public class NewsApi {

  private final NewsService newsService;

  @GetMapping
  @ApiOperation(value = "Get latest Buzzfeed news", nickname = "getLastNews")
  public RestResponse<List<NewsDTO>> getLastNews() {
    return new RestResponse<>(newsService.getLastNews());
  }
}

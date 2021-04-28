package com.buzzfeed.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.buzzfeed.data.NewsDTO;
import com.buzzfeed.data.RestResponse;
import com.buzzfeed.service.impl.NewsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
public class NewsApiTest {

  @Mock
  private NewsServiceImpl service;

  @InjectMocks
  private NewsApi api;

  private ObjectMapper mapper;
  private MockMvc mockMvc;

  @Before
  public void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(api).build();
    this.mapper = new ObjectMapper();
  }

  @Test
  public void testGetLastNews() throws Exception {
    final var list = List.of(new NewsDTO());
    final var expected = new RestResponse<>(list);

    when(service.getLastNews()).thenReturn(list);
    final var mvcResult = getLastNews();

    assertEquals(mapper.writeValueAsString(expected), mvcResult.getResponse().getContentAsString());
  }

  public MvcResult getLastNews() throws Exception {
    return mockMvc.perform(MockMvcRequestBuilders.get("/news"))
        .andExpect(status().isOk())
        .andReturn();
  }
}

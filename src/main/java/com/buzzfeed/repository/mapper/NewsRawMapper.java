package com.buzzfeed.repository.mapper;

import com.buzzfeed.entity.News;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class NewsRawMapper implements RowMapper<News> {

  @Override
  public News mapRow(final ResultSet rs, final int rowNum) throws SQLException {
    return News.builder()
        .title(rs.getString("title"))
        .description(rs.getString("description"))
        .uri(rs.getString("uri"))
        .publishedDate(rs.getTimestamp("published_date").toLocalDateTime())
        .insertedDate(rs.getTimestamp("inserted_date").toLocalDateTime())
        .build();
  }
}
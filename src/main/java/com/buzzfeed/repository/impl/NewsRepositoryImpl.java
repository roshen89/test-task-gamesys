package com.buzzfeed.repository.impl;

import com.buzzfeed.entity.News;
import com.buzzfeed.repository.NewsRepository;
import com.buzzfeed.repository.mapper.NewsRawMapper;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NewsRepositoryImpl implements NewsRepository {

  private final JdbcTemplate jdbcTemplate;
  private final NewsRawMapper newsRawMapper;

  @Override
  public List<News> findLastNews(Integer limit) {
    final var selectQuery = "SELECT * FROM buzzfeed_news ORDER BY published_date DESC LIMIT ?";
    return jdbcTemplate.query(selectQuery, newsRawMapper, limit);
  }

  @Override
  public void saveAll(List<News> news) {
    final var insertQuery = "INSERT IGNORE INTO buzzfeed_news(title, description, uri, published_date, inserted_date) VALUES (?, ?, ?, ?, ?)";
    jdbcTemplate.batchUpdate(insertQuery, new BatchPreparedStatementSetter() {

      @Override
      public void setValues(final PreparedStatement ps, final int i) throws SQLException {
        ps.setString(1, news.get(i).getTitle());
        ps.setString(2, news.get(i).getDescription());
        ps.setString(3, news.get(i).getUri());
        ps.setTimestamp(4, news.get(i).getPublishedDate() != null ? Timestamp.valueOf(news.get(i).getPublishedDate()) : null);
        ps.setTimestamp(5, news.get(i).getInsertedDate() != null ? Timestamp.valueOf(news.get(i).getInsertedDate()) : null);
      }

      @Override
      public int getBatchSize() {
        return news.size();
      }
    });
  }
}

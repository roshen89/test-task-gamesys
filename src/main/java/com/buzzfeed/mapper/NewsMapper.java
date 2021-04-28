package com.buzzfeed.mapper;

import com.buzzfeed.data.NewsDTO;
import com.buzzfeed.data.RssData;
import com.buzzfeed.entity.News;
import java.time.LocalDateTime;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    imports = LocalDateTime.class
)
public abstract class NewsMapper {

  public static final NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

  public abstract News toNews(RssData rssData);

  public abstract NewsDTO toNewsDTO(News entity);

  public abstract List<NewsDTO> toNewsDTOs(List<News> entityList);
}

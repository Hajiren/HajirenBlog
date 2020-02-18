package com.hajiren.mapper;

import com.hajiren.bean.Work;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorksMapper {

    Work getWorkById(Long id);

    List<Work> getWorksByType(String type);

    List<Work> getAllWorks();

    String getUrlById(Long id);
}

package com.hajiren.service;

import com.hajiren.bean.Work;
import com.hajiren.mapper.WorksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorksService {
    @Autowired
    private WorksMapper worksMapper;

    public Work getWorkById(Long id){
        return worksMapper.getWorkById(id);
    }

    public List<Work> getWorksByType(String type){
        return worksMapper.getWorksByType(type);
    }

    public List<Work> getAllWorks(){
        return worksMapper.getAllWorks();
    }

    public String getUrlById(Long id){
        return worksMapper.getUrlById(id);
    }
}

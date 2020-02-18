package com.hajiren.mapper;

import com.hajiren.bean.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper {
    int insertMessage(String name,String email,String message);
    int handleAutoIncrement();
}

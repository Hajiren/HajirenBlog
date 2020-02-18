package com.hajiren.service;

import com.hajiren.bean.Message;
import com.hajiren.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public int handleAutoIncrement(){
        return messageMapper.handleAutoIncrement();
    }

    public int insertMessage(String name,String email,String message){
        handleAutoIncrement();
        return messageMapper.insertMessage(name,email,message);
    }
}

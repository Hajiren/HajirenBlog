package com.hajiren.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hajiren.bean.Blog;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class JsonUtils {

    public static <T> List<T> readJsonFromPath(String path, Type type) throws IOException{
        try {
//            URL url = Thread.currentThread().getContextClassLoader().getResource(path);
//            File jsonFile = ResourceUtils.getFile(url);
//            String json = FileUtils.readFileToString(jsonFile,"UTF-8");
            ClassPathResource classPathResource = new ClassPathResource(path);
            byte[]  keywordsData = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
            String json = new String(keywordsData,"UTF-8");
            return (List<T>) JSON.parseObject(json, new TypeReference<List<Blog>>(){});
        }catch(Exception e){
            throw e;
        }
    }
}

package com.hajiren.configuration;

import com.hajiren.bean.Blog;
import com.hajiren.utils.BlogUtils;
import com.hajiren.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ThymeleafConfig {
    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;

    private Map<String,String[]> showBlogInfo;

    /**
     * 初始化方法，给Thymeleaf添加静态全局变量
     */
    @PostConstruct
    public void init() {

        try {
            showBlogInfo= BlogUtils.getShowBlogInfo();

            Map<String, Object> variables = new HashMap<>();
            variables.put("showBlogInfo", showBlogInfo);
            thymeleafViewResolver.setStaticVariables(variables);
        }catch(Exception e){
            System.out.println(e);
        }
    }

}

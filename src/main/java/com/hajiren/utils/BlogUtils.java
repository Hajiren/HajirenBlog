package com.hajiren.utils;

import com.hajiren.bean.Blog;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogUtils {
    private static int first_index=0;
    private static int second_index=1;

    private static List<Blog> blogs;

    static {
        try {
            blogs = JsonUtils.readJsonFromPath("static/assets/json/articles.json", Blog.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BlogUtils(){
    }

    public static Map<String,String[]> getShowBlogInfo(){
        Map<String,String[]> info=new HashMap<>();
        Blog blog_1=blogs.get(first_index);
        Blog blog_2=blogs.get(second_index);

        String[] ids={blog_1.getId(),blog_2.getId()};
        String[] titles={blog_1.getTitle(),blog_2.getTitle()};
        String[] covers={blog_1.getCover(),blog_2.getCover()};
        String[] summaries={blog_1.getSummary(),blog_2.getSummary()};
        String[] categories={blog_1.getCategories(),blog_2.getCategories()};

        info.put("ids",ids);
        info.put("titles",titles);
        info.put("covers",covers);
        info.put("summaries",summaries);
        info.put("categories",categories);

        return info;
    }

    public static List<String>[] generateCodeIdArticlesByBlogId(String id){
        Blog blog=blogs.get(Integer.valueOf(id));
        List<String>[] articles=blog.getArticles();
        int count=0;
        for(int i=0;i<articles.length;i++){
            switch (articles[i].get(0)){
                case "images":
                case "sentences":
                case "h1":
                case "h2":
                case "h3":
                case "h4":
                case "h5":
                case "h6":
                case "blockquote":
                case "br":
                    break;
                default:
                    articles[i].add(articles[i].get(0)+String.valueOf(count++));
            }
        }
        return articles;
    }

    public static Blog getBlogById(int id){
        return blogs.get(id);
    }

    public static List<Blog> getAllBlogs(){
        return blogs;
    }
}

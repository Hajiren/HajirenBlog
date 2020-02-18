package com.hajiren.controller;

import com.hajiren.bean.Blog;
import com.hajiren.bean.Work;
import com.hajiren.service.WorksService;
import com.hajiren.utils.BlogUtils;
import com.hajiren.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class BlogController {

    private List<Work> work;
//    private boolean firstTime=true;

    @Autowired
    private WorksService worksService;


    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable int id){
        Blog blog= BlogUtils.getBlogById(id);
//        List<String>[] articles;
//        if(firstTime) {
//            articles = BlogUtils.generateCodeIdArticlesByBlogId(blog.getId());
//            firstTime = false;
//        }else
//            articles=blog.getArticles();

        model.addAttribute("id",blog.getId());
        model.addAttribute("title",blog.getTitle());
        model.addAttribute("cover",blog.getCover());
        model.addAttribute("avatar",blog.getAvatar());
        model.addAttribute("author",blog.getAuthor());
        model.addAttribute("date",blog.getDate());
        model.addAttribute("categories",blog.getCategories());
        model.addAttribute("summary",blog.getSummary());
        model.addAttribute("article",blog.getArticles());
        return "detail";
    }

    @GetMapping("/blog")
    public String blog(Model model){
        model.addAttribute("blogs",BlogUtils.getAllBlogs());
        return "blog";
    }
}

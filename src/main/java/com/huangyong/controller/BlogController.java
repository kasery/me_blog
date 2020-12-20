package com.huangyong.controller;

import com.github.pagehelper.PageInfo;
import com.huangyong.pojo.Blog;
import com.huangyong.pojo.Comment;
import com.huangyong.pojo.Tag;
import com.huangyong.service.BackStageService;
import com.huangyong.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/txt")
public class BlogController {

    @Autowired
    BackStageService backStageService;

    //博客文章查询全部
    @RequestMapping("/findAll")
    public Result<PageInfo<Blog>> findAll(@RequestParam(defaultValue = "1", name = "page") int page, @RequestParam(defaultValue = "10", name = "limit") int pageSize, String blog_title) {
        System.out.println(blog_title);
        List<Blog> blogs = backStageService.blogfindAll(page, pageSize, "tb_blog", blog_title);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogs);

        pageInfo.setNavigatePages(5);

        Result<PageInfo<Blog>> result = Result.success(pageInfo);

        return result;
    }
    //博客文章根据标签查询
    @RequestMapping("/findAllByTag")
    public Result<PageInfo<Blog>> findAllByTag(@RequestParam(defaultValue = "1", name = "page") int page, @RequestParam(defaultValue = "10", name = "limit") int pageSize, String blog_tags) {
        System.out.println(blog_tags);
        List<Blog> blogs = backStageService.findAllByTag(page, pageSize, "tb_blog", blog_tags);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogs);

        pageInfo.setNavigatePages(5);

        Result<PageInfo<Blog>> result = Result.success(pageInfo);

        return result;
    }
    @RequestMapping("/clickFindAll")
    public Result<PageInfo<Blog>> clickFindAll(@RequestParam(defaultValue = "1", name = "page") int page, @RequestParam(defaultValue = "10", name = "limit") int pageSize, String blog_title) {
        System.out.println(blog_title);
        List<Blog> blogs = backStageService.clickFindAll(page, pageSize, "tb_blog", blog_title);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogs);

        pageInfo.setNavigatePages(5);

        Result<PageInfo<Blog>> result = Result.success(pageInfo);

        return result;
    }
    //根据博客id来获取评论
    @RequestMapping("/comfindById")
    public Result<PageInfo<Comment>> comfindById(@RequestParam(defaultValue = "1", name = "page") int page, @RequestParam(defaultValue = "10", name = "limit") int pageSize,int blog_id) {
        List<Comment> comments = backStageService.comfindByBlog_Id(page, pageSize,blog_id);
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(comments);
        pageInfo.setNavigatePages(5);
        Result<PageInfo<Comment>> result = Result.success(pageInfo);
        return result;
    }
    //博客添加评论
    @RequestMapping("/add_comment")
    public int add_comment(Comment comment, HttpSession session) {
        String text = (String) session.getAttribute("kaptcha");
        System.out.println("路径"+comment.getWebsite_url());
        if(text.equals(comment.getVerifyCode().toUpperCase())){
            int row = backStageService.add_comment(comment);
            return row;
        }else{
            return -1;
        }
    }
    //进入浏览量增加
    @RequestMapping("/update_blog_views")
    public int update_blog_views(Blog blog) {
        int row = backStageService.update_blog_views(blog);
        return row;
    }
}

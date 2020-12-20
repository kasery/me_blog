package com.huangyong.service;

import com.huangyong.pojo.*;

import java.util.List;
import java.util.Map;

public interface BackStageService {
    //定时删除
    int deleteView();
    //添加浏览量
    int addview(int num);
    //添加评论
    int add_comment(Comment comment);
    //博客根据标签查询
    public List<Blog> findAllByTag(int page, int pageSize, String table_name,String blog_tags);
    //查询全部已发布文章
    public List<Blog> blogfindAll(int page, int pageSize, String table_name,String blog_title);
    public List<Blog> clickFindAll(int page, int pageSize, String table_name,String blog_title);
    //仪盘表的数据
    public int findCount(String table_name);
    //博客分类统计图
    public List<Map<String,Object>> blogCategroyOfArticleCount();
    //博客一个月的访问量统计图
    public List<Map<String,Object>>  getViewNum();
    //查询全部
    public List<Blog> findAll(int page, int pageSize, String table_name,String blog_title);
    public List<Comment> comFindAll(int page, int pageSize, String table_name);
    public List<Category> catFindAll(int page, int pageSize, String table_name);
    public List<Tag> tagFindAll(int page, int pageSize, String table_name,String tag_name);
    public List<link> linkFindAll(int page, int pageSize, String table_name);
    //根据id查询
    public Blog findById(int blog_id);
    //获取分类
    public List<Category> classifyAll();
    //获取标签
    public List<Tag> lableAll();
    //添加博客文章
    public int add_blog(Blog blog);
    //博客文章删除功能
    int delete(int blog_id);
    //博客文章修改功能
    int edit_blog(Blog blog);
    //博客文章修改浏览量功能
    int update_blog_views(Blog blog);
    //评论删除功能
    int comdelete(int comment_id);
    //评论批量删除功能
    int deletes(int[] ids);
    //评论批量审核功能
    int updates(int[] ids);
    //评论根据id查询
    Comment comfindById(int comment_id);
    //评论根据blog_id查询
    List<Comment> comfindByBlog_Id(int page, int pageSize,int blog_id);
    //分类批量删除
    int catdeletes(int[] ids);
    //分类删除功能
    int catdelete(int category_id);
    //分类添加功能
    int addcat(Category category);
    //分类根据id查询
    Category catfindById(int category_id);
    //标签根据id查询
    Tag tagfindById(int tag_id);
    //分类修改功能
    int editcat(Category category);
    //回复功能
    int reply(Comment comment);
    //标签删除功能
    int tagdelete(int tag_id);
    //标签修改功能
    int tagedit(Tag tag);
    //标签添加功能
    int addtag(Tag tag);
    //标签批量删除
    int tagdeletes(int[] ids);
    //友情链接删除功能
    int linkdelete(int link_id);
    //友情链接批量删除
    int linkdeletes(int[] ids);
    //友情链接添加功能
    int addlink(link link);
    //友情链接根据id查询
    link linkfindById(int link_id);
    //标签修改功能
    int linkedit(link link);
    //配置查询
    List<Config> configFindAll();
    //配置修改
    int configedit(Config config);
    //查询登录用户
    User userfindByuser(User user);
    //修改登录用户的账号和名称
    int useredit(User user);
    //修改登录用户的密码
    int password_edit(String admin_user_id,String login_password,String new_password);
    //根据id查询出用户
    User userfindById(int admin_user_id);
}

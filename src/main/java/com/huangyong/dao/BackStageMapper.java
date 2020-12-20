package com.huangyong.dao;

import com.huangyong.pojo.*;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface BackStageMapper {
    //定时删除多于的浏览量数据
    int deleteView();
    //添加浏览量
    int addview(int num);
    //博客分类统计图
    public List<Map<String,Object>> blogCategroyOfArticleCount();
    //博客一个月访问量统计图
    public List<Map<String,Object>> getViewNum();
    int update_blog_views(Blog blog);
    List<Blog> findAllByTag(String table_name,String blog_tags);
    int findCount(String table_name);
    List<Blog> blogfindAll(String table_name,String blog_title);
    List<Blog> clickFindAll(String table_name,String blog_title);
    List<Blog> findAll(String table_name,String blog_title);
    List<Comment> comFindAll(String table_name);
    List<Category> catFindAll(String table_name);
    List<Tag> tagFindAll(String table_name,String tag_name);
    List<link> linkFindAll(String table_name);
    Blog findById(int blog_id);
    int add_Blog(Blog blog);
    int edit_Blog(Blog blog);
    List<Category> classifyAll();
    List<Tag> lableAll();
    int delete(int blog_id);
    int comdelete(int comment_id);
    int deletes(int[] ids);
    int updates(int[] ids);

    int catdeletes(int[] ids);
    int catdelete(int category_id);
    int addcat(Category category);

    int addtag(Tag tag);
    int addlink(link link);
    int add_comment(Comment comment);
    int tagdeletes(int[] ids);
    int linkdeletes(int[] ids);
    List<Comment> comfindByBlog_Id(int blog_id);
    Comment comfindById(int comment_id);
    Category catfindById(int category_id);
    Tag tagfindById(int tag_id);
    link linkfindById(int link_id);

    int editcat(Category category);
    int tagedit(Tag tag);
    int linkedit(link link);

    int tagdelete(int tag_id);

    int linkdelete(int link_id);


    List<Config> configFindAll();
    int configedit(Config config);

    User userfindByuser(User user);
    int password_edit(String  admin_user_id,String login_password,String new_password);
    User userfindById(int admin_user_id);

    int useredit(User user);
    //回复功能
    int reply(Comment comment);

}

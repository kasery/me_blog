package com.huangyong.service.impl;

import com.github.pagehelper.PageHelper;
import com.huangyong.dao.BackStageMapper;
import com.huangyong.pojo.*;
import com.huangyong.service.BackStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BackStageServiceImpl implements BackStageService {
    @Autowired
    BackStageMapper backStageMapper;

    @Override
    public int findCount(String table_name) {
        return backStageMapper.findCount(table_name);
    }

    @Override
    public List<Map<String, Object>> blogCategroyOfArticleCount() {
        return backStageMapper.blogCategroyOfArticleCount();
    }

    @Override
    public List<Map<String, Object>> getViewNum() {
        return backStageMapper.getViewNum();
    }

    @Override
    public int deleteView() {
        return backStageMapper.deleteView();
    }

    @Override
    public int addview(int num) {
        return backStageMapper.addview(num);
    }

    @Override
    public int add_comment(Comment comment) {
        return backStageMapper.add_comment(comment);
    }

    @Override
    public List<Blog> findAllByTag(int page, int pageSize, String table_name, String blog_tags) {
        PageHelper.startPage(page, pageSize, "blog_id desc");
        return backStageMapper.findAllByTag(table_name,blog_tags);
    }

    //首页查询所有文章
    @Override
    public List<Blog> blogfindAll(int page, int pageSize, String table_name,String blog_title) {
        //设置分页参数
        PageHelper.startPage(page, pageSize, "blog_id desc");
        return backStageMapper.blogfindAll(table_name,blog_title);
    }

    //首页查询点击发布
    @Override
    public List<Blog> clickFindAll(int page, int pageSize, String table_name,String blog_title) {
        //设置分页参数
        PageHelper.startPage(page, pageSize, "blog_views desc");
        return backStageMapper.clickFindAll(table_name,blog_title);
    }

    //查询所有文章
    @Override
    public List<Blog> findAll(int page, int pageSize, String table_name,String blog_title) {
        //设置分页参数
        PageHelper.startPage(page, pageSize, "blog_id desc");
        return backStageMapper.findAll(table_name,blog_title);
    }

    //查询所有评论
    @Override
    public List<Comment> comFindAll(int page, int pageSize, String table_name) {
        //设置分页参数
        PageHelper.startPage(page, pageSize, "comment_id desc");
        return backStageMapper.comFindAll(table_name);
    }

    //查询所有分类
    @Override
    public List<Category> catFindAll(int page, int pageSize, String table_name) {
        //设置分页参数
        PageHelper.startPage(page, pageSize, "category_id desc");
        return backStageMapper.catFindAll(table_name);
    }

    //查询所有友情链接
    @Override
    public List<Tag> tagFindAll(int page, int pageSize, String table_name,String tag_name) {
        //设置分页参数
        PageHelper.startPage(page, pageSize, "tag_id desc");
        return backStageMapper.tagFindAll(table_name,tag_name);
    }
    //查询所有友情链接
    @Override
    public List<link> linkFindAll(int page, int pageSize, String table_name) {
        //设置分页参数
        PageHelper.startPage(page, pageSize, "link_id desc");
        return backStageMapper.linkFindAll(table_name);
    }
    //添加页面分类渲染
    @Override
    public List<Category> classifyAll() {
        return backStageMapper.classifyAll();
    }

    @Override
    public List<Tag> lableAll() {
        return backStageMapper.lableAll();
    }

    //添加博客文章
    @Override
    public int add_blog(Blog blog) {
        return backStageMapper.add_Blog(blog);
    }

    @Override
    public int delete(int blog_id) {
        return backStageMapper.delete(blog_id);
    }

    @Override
    public int edit_blog(Blog blog) {
        return backStageMapper.edit_Blog(blog);
    }

    @Override
    public int update_blog_views(Blog blog) {
        return backStageMapper.update_blog_views(blog);
    }

    @Override
    public int comdelete(int comment_id) {
        return backStageMapper.comdelete(comment_id);
    }

    @Override
    public int deletes(int[] ids) {
        return backStageMapper.deletes(ids);
    }

    @Override
    public int updates(int[] ids) {
        return backStageMapper.updates(ids);
    }

    @Override
    public int catdeletes(int[] ids) {
        return backStageMapper.catdeletes(ids);
    }

    @Override
    public int catdelete(int category_id) {
        return backStageMapper.catdelete(category_id);
    }

    @Override
    public int addcat(Category category) {
        return backStageMapper.addcat(category);
    }

    @Override
    public Category catfindById(int category_id) {
        return backStageMapper.catfindById(category_id);
    }

    @Override
    public Tag tagfindById(int tag_id) {
        return backStageMapper.tagfindById(tag_id);
    }

    @Override
    public int editcat(Category category) {
        return backStageMapper.editcat(category);
    }

    @Override
    public int tagedit(Tag tag) {
        return backStageMapper.tagedit(tag);
    }

    @Override
    public int addtag(Tag tag) {
        return backStageMapper.addtag(tag);
    }

    @Override
    public Comment comfindById(int comment_id) {
        return backStageMapper.comfindById(comment_id);
    }

    @Override
    public List<Comment> comfindByBlog_Id(int page, int pageSize,int blog_id) {
        //设置分页参数
        PageHelper.startPage(page, pageSize, "comment_id desc");
        return backStageMapper.comfindByBlog_Id(blog_id);
    }

    @Override
    public int reply(Comment comment) {
        return backStageMapper.reply(comment);
    }

    @Override
    public int tagdelete(int tag_id) {
        return backStageMapper.tagdelete(tag_id);
    }

    @Override
    public Blog findById(int blog_id) {
        // TODO Auto-generated method stub
        return backStageMapper.findById(blog_id);
    }

    @Override
    public int tagdeletes(int[] ids) {
        return backStageMapper.tagdeletes(ids);
    }

    @Override
    public int linkdelete(int link_id) {
        return backStageMapper.linkdelete(link_id);
    }

    @Override
    public int linkdeletes(int[] ids) {
        return backStageMapper.linkdeletes(ids);
    }

    @Override
    public int addlink(link link) {
        return backStageMapper.addlink(link);
    }

    @Override
    public link linkfindById(int link_id) {
        return backStageMapper.linkfindById(link_id);
    }


    @Override
    public int linkedit(link link) {
        return backStageMapper.linkedit(link);
    }

    @Override
    public List<Config> configFindAll() {
        return backStageMapper.configFindAll();
    }

    @Override
    public User userfindByuser(User user) {
        return backStageMapper.userfindByuser(user);
    }

    @Override
    public int useredit(User user) {
        return backStageMapper.useredit(user);
    }

    @Override
    public int password_edit(String  admin_user_id,String login_password,String new_password) {
        return backStageMapper.password_edit(admin_user_id,login_password,new_password);
    }

    @Override
    public User userfindById(int admin_user_id) {
        return backStageMapper.userfindById(admin_user_id);
    }

    @Override
    public int configedit(Config config) {
        int num = 0;
        try {
            for (Config config1 : config.getConfigList()) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                config1.setUpdate_time(df.format(new Date()));// new Date()为获取当前系统时间
                num+=backStageMapper.configedit(config1);
            }
        }catch(Exception e){
            num = 0;
            e.printStackTrace();
        }
        return num;
    }
}

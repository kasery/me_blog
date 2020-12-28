package com.huangyong.controller;

import com.github.pagehelper.PageInfo;
import com.huangyong.pojo.*;
import com.huangyong.service.BackStageService;
import com.huangyong.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/blog")
public class BackStageController {
    @Autowired
    BackStageService backStageService;

    //安全退出
    @RequestMapping("/safequit")
    public int safequit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return 1;
    }

    //记录博客访问量
    @RequestMapping("/view")
    public int viewCount(HttpServletRequest request){
        return backStageService.addview(1);
    }
    //获取当前访问量
    @RequestMapping("/getViewNum")
    public List<Map<String,Object>> getViewNum(){
        return backStageService.getViewNum();
    }
    //定时删除
    @RequestMapping("/deleteView")
    public int deleteView(){
        return backStageService.deleteView();
    }
    //查询出5张表的总数
    @RequestMapping("/num")
    public Map<String, Integer> count() {
        Map<String, Integer> map = new HashMap<>();
        List<String> table_names = new ArrayList<>();
        table_names.add("tb_blog");
        table_names.add("tb_blog_comment");
        table_names.add("tb_blog_category");
        table_names.add("tb_blog_tag");
        table_names.add("tb_link");
        for (String table_name : table_names) {
            int num = backStageService.findCount(table_name);
            map.put(table_name, num);
        }
        return map;
    }

    //博客分类统计图
    @RequestMapping("/categoryNum")
    public List<Map<String,Object>> blogCategroyOfArticleCount(){
        return backStageService.blogCategroyOfArticleCount();
    }

    //博客内容查询全部
    @RequestMapping("/findAll")
    public Result<PageInfo<Blog>> findAll(@RequestParam(defaultValue = "1", name = "page") int page, @RequestParam(defaultValue = "10", name = "limit") int pageSize, String blog_title) {
        System.out.println(blog_title);
        List<Blog> blogs = backStageService.findAll(page, pageSize, "tb_blog", blog_title);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogs);

        pageInfo.setNavigatePages(5);

        Result<PageInfo<Blog>> result = Result.success(pageInfo);

        return result;
    }

    //评论查询全部
    @RequestMapping("/comFindAll")
    public Result<PageInfo<Comment>> comFindAll(@RequestParam(defaultValue = "1", name = "page") int page, @RequestParam(defaultValue = "10", name = "limit") int pageSize) {
        List<Comment> comments = backStageService.comFindAll(page, pageSize, "tb_blog_comment");
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(comments);

        pageInfo.setNavigatePages(5);

        Result<PageInfo<Comment>> result = Result.success(pageInfo);

        return result;
    }

    //分类查询全部
    @RequestMapping("/catFindAll")
    public Result<PageInfo<Category>> catFindAll(@RequestParam(defaultValue = "1", name = "page") int page, @RequestParam(defaultValue = "10", name = "limit") int pageSize) {
        List<Category> categorys = backStageService.catFindAll(page, pageSize, "tb_blog_category");
        PageInfo<Category> pageInfo = new PageInfo<Category>(categorys);

        pageInfo.setNavigatePages(5);

        Result<PageInfo<Category>> result = Result.success(pageInfo);

        return result;
    }

    //标签查询全部
    @RequestMapping("/tagFindAll")
    public Result<PageInfo<Tag>> tagFindAll(@RequestParam(defaultValue = "1", name = "page") int page, @RequestParam(defaultValue = "100", name = "limit") int pageSize, String tag_name) {
        System.out.println(tag_name);
        List<Tag> tags = backStageService.tagFindAll(page, pageSize, "tb_blog_tag", tag_name);
        PageInfo<Tag> pageInfo = new PageInfo<Tag>(tags);

        pageInfo.setNavigatePages(5);

        Result<PageInfo<Tag>> result = Result.success(pageInfo);

        return result;
    }

    //友链查询全部
    @RequestMapping("/linkFindAll")
    public Result<PageInfo<link>> linkFindAll(@RequestParam(defaultValue = "1", name = "page") int page, @RequestParam(defaultValue = "30", name = "limit") int pageSize) {
        List<link> links = backStageService.linkFindAll(page, pageSize, "tb_link");
        PageInfo<link> pageInfo = new PageInfo<link>(links);

        pageInfo.setNavigatePages(5);

        Result<PageInfo<link>> result = Result.success(pageInfo);

        return result;
    }

    //页面操作
    //分类渲染
    @RequestMapping("/classify")
    public Result<List<Category>> add_blog_classify() {
        List<Category> list = backStageService.classifyAll();
        Result<List<Category>> result = Result.success(list);
        return result;
    }

    //标签渲染
    @RequestMapping("/lable")
    public Result<List<Tag>> add_blog_lable() {
        List<Tag> list = backStageService.lableAll();
        Result<List<Tag>> result = Result.success(list);
        return result;
    }

    //新增博客文章
    @RequestMapping("/add_Blog")
    public Result<Integer> add_blog(String blog_title, String blog_sub_url, String blog_category_id_name,
                                    @RequestParam(name = "blog_tags") String[] blog_tags,
                                    String blog_content, @RequestParam("file") MultipartFile file) {
        Result<Integer> result = new Result<Integer>(0, "", null);

        int blog_category_id = Integer.parseInt(blog_category_id_name.split(",")[0]);
        String blog_category_name = blog_category_id_name.split(",")[1];
        System.out.println("blog_title" + blog_title);
        if (blog_title != null && !blog_title.equals("")) {
            Blog blog = new Blog();
            blog.setBlog_title(blog_title);
            blog.setBlog_sub_url(blog_sub_url);
            blog.setBlog_category_id(blog_category_id);
            blog.setBlog_category_name(blog_category_name);
            String blog_tag = "";
            for (String tag : blog_tags) {
                blog_tag += "," + tag;
            }
            blog.setBlog_tags(blog_tag.substring(1, blog_tag.length()));
            blog.setBlog_content(blog_content);

            //图片上传
            if (file.isEmpty()) {
                result.setCode(1);
                result.setMsg("未选择文件！");
                return result;
            }

            String fileName = file.getOriginalFilename();

            String suffixName = fileName.substring(fileName.lastIndexOf("."));

            fileName = UUID.randomUUID().toString() + suffixName;

            String path = "D:/uploads/";

            File sfile = new File(path + fileName);


            if (!sfile.getParentFile().exists()) {
                sfile.getParentFile().mkdirs();
            }

            try {
                file.transferTo(sfile);
            } catch (Exception e) {
                e.printStackTrace();
                result.setCode(1);
                result.setMsg("文件上传失败");
                return result;
            }
            blog.setBlog_cover_image("/uploads/" + fileName);
            int num = backStageService.add_blog(blog);
            result.setData(num);
            result.setMsg("保存成功");
            return result;
        } else {
            result.setCode(3);
            result.setMsg("博客文章标题不能为空！");
            return result;
        }
    }

    //根据id来获取文章
    @RequestMapping("/findById")
    public Result<Blog> findById(int blog_id) {
        Blog blog = backStageService.findById(blog_id);
        Result<Blog> result = Result.success(blog);
        return result;
    }

    //修改博客文章
    @RequestMapping("/edit_Blog")
    public Result<Integer> edit_blog(String blog_id, String blog_title, String blog_status,
                                     String blog_category_id_name,
                                     @RequestParam(name = "blog_tags[]") String[] blog_tags,
                                     String blog_content) {

        Result<Integer> result = new Result<Integer>(0, "", null);
        int blog_category_id = Integer.parseInt(blog_category_id_name.split(",")[0]);
        String blog_category_name = blog_category_id_name.split(",")[1];

        Blog blog = new Blog();
        blog.setBlog_id(Integer.parseInt(blog_id));
        blog.setBlog_title(blog_title);
        blog.setBlog_status(Integer.parseInt(blog_status));
        blog.setBlog_category_id(blog_category_id);
        blog.setBlog_category_name(blog_category_name);

        String blog_tag = "";
        for (String tag : blog_tags) {
            blog_tag += "," + tag;
        }
        blog.setBlog_tags(blog_tag.substring(1, blog_tag.length()));
        blog.setBlog_content(blog_content);
        System.out.println(blog.toString());
        int num = backStageService.edit_blog(blog);
        result.setData(num);
        result.setMsg("修改成功");
        return result;

    }

    //修改图片
    @RequestMapping("/img_edit")
    public Result<Integer> img_eidt(String blog_id, String blog_title, String blog_status,
                                    String blog_category_id_name,
                                    @RequestParam(name = "blog_tags") String[] blog_tags,
                                    String blog_content,
                                    String blog_cover_image, @RequestParam("file") MultipartFile file) {
        Result<Integer> result = new Result<Integer>(0, "", null);
        int blog_category_id = Integer.parseInt(blog_category_id_name.split(",")[0]);
        String blog_category_name = blog_category_id_name.split(",")[1];

        Blog blog = new Blog();
        blog.setBlog_id(Integer.parseInt(blog_id));
        blog.setBlog_title(blog_title);
        blog.setBlog_status(Integer.parseInt(blog_status));
        blog.setBlog_category_id(blog_category_id);
        blog.setBlog_category_name(blog_category_name);

        String blog_tag = "";
        for (String tag : blog_tags) {
            blog_tag += "," + tag;
        }
        blog.setBlog_tags(blog_tag.substring(1, blog_tag.length()));
        blog.setBlog_content(blog_content);

        String blog_cover_image2 = blog_cover_image;
        //图片上传
        if (file.isEmpty()) {
            result.setCode(1);
            result.setMsg("未选择文件！");
            return result;
        }

        String path = "D:";

        File sfile = new File(path + blog_cover_image2);


        if (!sfile.getParentFile().exists()) {
            sfile.getParentFile().mkdirs();
        }

        try {
            file.transferTo(sfile);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg("文件上传失败");
            return result;
        }
        System.out.println(blog_cover_image2);
        blog.setBlog_cover_image(blog_cover_image2);

        int num = backStageService.edit_blog(blog);
        result.setData(num);
        result.setMsg("修改成功");
        return result;
    }

    //博客文章删除功能
    @RequestMapping("/delete")
    public int delete(int blog_id) {
        Blog blog = backStageService.findById(blog_id);
        if(blog.getBlog_cover_image() != null && !blog.getBlog_cover_image().equals("")) {
            File file = new File(blog.getBlog_cover_image());
            if (file.exists() && file.isFile()) {
                if (file.delete()) {
                    System.out.println("删除单个文件" + blog.getBlog_cover_image() + "成功！");
                } else {
                    System.out.println("删除单个文件" + blog.getBlog_cover_image() + "失败！");
                }
            } else {
                System.out.println("删除单个文件失败：" + blog.getBlog_cover_image() + "不存在！");
            }
        }
        int row = backStageService.delete(blog_id);

        return row;
    }


    //评论删除功能
    @RequestMapping("/comdel")
    public int comdel(int comment_id) {
        int row = backStageService.comdelete(comment_id);

        return row;
    }

    //评论批量删除
    @RequestMapping("/deletes")
    public int deletes(@RequestParam(name = "ids[]") int[] ids) {
        int row = backStageService.deletes(ids);

        return row;
    }

    //评论批量审核
    @RequestMapping("/updates")
    public int updates(@RequestParam(name = "ids[]") int[] ids) {
        int row = backStageService.updates(ids);
        return row;
    }

    //评论回复功能
    //根据id来获取评论
    @RequestMapping("/comfindById")
    public Result<Comment> comfindById(int comment_id) {
        Comment comment = backStageService.comfindById(comment_id);
        Result<Comment> result = Result.success(comment);
        return result;
    }
    //评论回复
    @RequestMapping("/rep")
    public int reply(String comment_id, String reply_body) {
        Comment comment = new Comment();
        comment.setComment_id(Integer.parseInt(comment_id));
        comment.setReply_body(reply_body);
        return backStageService.reply(comment);
    }

    //分类批量删除
    @RequestMapping("/catdeletes")
    public int catdeletes(@RequestParam(name = "ids[]") int[] ids) {
        for(int id : ids){
            Result<Category> categorys = catfindById(id);
            if(categorys.getData().getCategory_icon() != null && !categorys.getData().getCategory_icon().equals("")){
                File file = new File(categorys.getData().getCategory_icon());
                if (file.exists() && file.isFile()) {
                    if (file.delete()) {
                        System.out.println("删除单个文件" +categorys.getData().getCategory_icon() + "成功！");
                    } else {
                        System.out.println("删除单个文件" + categorys.getData().getCategory_icon() + "失败！");
                    }
                } else {
                    System.out.println("删除单个文件失败：" + categorys.getData().getCategory_icon() + "不存在！");
                }
            }
        }
        int row = backStageService.catdeletes(ids);
        return row;
    }

    //分类删除功能
    @RequestMapping("/catdel")
    public int catdel(int category_id) {
        Result<Category> categorys = catfindById(category_id);

        if(categorys.getData().getCategory_icon() != null && !categorys.getData().getCategory_icon().equals("")){
            File file = new File(categorys.getData().getCategory_icon());
            if (file.exists() && file.isFile()) {
                if (file.delete()) {
                    System.out.println("删除单个文件" +categorys.getData().getCategory_icon() + "成功！");
                } else {
                    System.out.println("删除单个文件" + categorys.getData().getCategory_icon() + "失败！");
                }
            } else {
                System.out.println("删除单个文件失败：" + categorys.getData().getCategory_icon() + "不存在！");
            }
        }
        int row = backStageService.catdelete(category_id);
        return row;
    }

    //分类添加功能
    @RequestMapping("/addcat")
    public Result<Integer> addcat(String category_name,@RequestParam("file") MultipartFile file) {

        Result<Integer> result = new Result<Integer>(0, "", null);

        if (category_name != null && !category_name.equals("")) {
            Category category = new Category();
            category.setCategory_name(category_name);


            //图片上传
            if (file.isEmpty()) {
                result.setCode(1);
                result.setMsg("未选择文件！");
                return result;
            }

            String fileName = file.getOriginalFilename();

            String suffixName = fileName.substring(fileName.lastIndexOf("."));

            fileName = UUID.randomUUID().toString() + suffixName;

            String path = "D:/uploads/";

            File sfile = new File(path + fileName);


            if (!sfile.getParentFile().exists()) {
                sfile.getParentFile().mkdirs();
            }

            try {
                file.transferTo(sfile);
            } catch (Exception e) {
                e.printStackTrace();
                result.setCode(1);
                result.setMsg("文件上传失败");
                return result;
            }
            category.setCategory_icon("/uploads/" + fileName);

            int row = backStageService.addcat(category);
            result.setData(row);
            result.setMsg("保存成功");
            return result;
        } else {
            result.setCode(3);
            result.setMsg("分类名称不能为空！");
            return result;
        }
    }

    //分类根据id查询
    @RequestMapping("/catfindById")
    public Result<Category> catfindById(int category_id) {
        Category category = backStageService.catfindById(category_id);
        Result<Category> result = Result.success(category);
        return result;
    }

    //分类修改功能
    @RequestMapping("/editcat")
    public int editcat(Category category) {
        int row = backStageService.editcat(category);
        return row;
    }

    //分类修改图片
    @RequestMapping("/img_catedit")
    public Result<Integer> img_cateidt(Category category,@RequestParam("file") MultipartFile file) {
        Result<Integer> result = new Result<Integer>(0, "", null);

        //图片上传
        if (file.isEmpty()) {
            result.setCode(1);
            result.setMsg("未选择文件！");
            return result;
        }

        String path = "D:";

        File sfile = new File(path + category.getCategory_icon());


        if (!sfile.getParentFile().exists()) {
            sfile.getParentFile().mkdirs();
        }

        try {
            file.transferTo(sfile);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg("文件上传失败");
            return result;
        }
        System.out.println(category.getCategory_icon());
        category.setCategory_icon(category.getCategory_icon());

        int num = backStageService.editcat(category);
        result.setData(num);
        result.setMsg("修改成功");
        return result;
    }

    //标签删除功能
    @RequestMapping("/tagdel")
    public int tagdel(int tag_id) {
        int row = backStageService.tagdelete(tag_id);
        return row;
    }

    //标签添加功能
    @RequestMapping("/tagedit")
    public int tagedit(Tag tag) {
        int row = backStageService.tagedit(tag);
        return row;
    }

    //标签根据id查询
    @RequestMapping("/tagfindById")
    public Result<Tag> tagfindById(int tag_id) {
        Tag tag = backStageService.tagfindById(tag_id);
        Result<Tag> result = Result.success(tag);
        return result;
    }

    //标签添加功能
    @RequestMapping("/addtag")
    public int addtag(String tag_name) {
        Tag tag = new Tag();
        tag.setTag_name(tag_name);
        int row = backStageService.addtag(tag);
        return row;
    }

    //标签批量删除
    @RequestMapping("/tagdeletes")
    public int tagdeletes(@RequestParam(name = "ids[]") int[] ids) {
        int row = backStageService.tagdeletes(ids);
        return row;
    }

    //友情链接删除功能
    @RequestMapping("/linkdel")
    public int linkdel(int link_id) {
        int row = backStageService.linkdelete(link_id);
        return row;
    }

    //友情链接批量删除
    @RequestMapping("/linkdeletes")
    public int linkdeletes(@RequestParam(name = "ids[]") int[] ids) {
        int row = backStageService.linkdeletes(ids);
        return row;
    }

    //友情链接添加功能
    @RequestMapping("/add_link")
    public int add_link(link link) {
        int row = backStageService.addlink(link);
        return row;
    }

    //友情链接根据id查询
    @RequestMapping("/linkfindById")
    public Result<link> linkfindById(int link_id) {
        link link = backStageService.linkfindById(link_id);
        Result<link> result = Result.success(link);
        return result;
    }

    //友情链接修改功能
    @RequestMapping("/edit_link")
    public int editlink(link link) {
        int row = backStageService.linkedit(link);
        return row;
    }

    //配置查询全部
    @RequestMapping("/config")
    public Result<List<Config>> configFindAll() {
        List<Config> configs = backStageService.configFindAll();
        Result<List<Config>> result = Result.success(configs);
        return result;
    }

    //配置修改功能
    @RequestMapping("/set")
    public int configedit(@RequestBody Config config) {
        System.out.println(config.toString());
        int row = backStageService.configedit(config);
        return row;
    }

    //用户查询全部
    @RequestMapping("/pass")
    public Result<User> passFindAll(HttpSession session) {
        User user1 = (User) session.getAttribute("user");
        System.out.println("session:" + user1);
        User user2 = backStageService.userfindByuser(user1);
        Result<User> result = Result.success(user2);
        return result;
    }

    //用户名修改功能
    @RequestMapping("/user_edit")
    public int user_edit(User user, HttpSession session) {
        int row = backStageService.useredit(user);
        //用id查询出修改好的用户然后存入seesion中
        User user1 = backStageService.userfindById(user.getAdmin_user_id());
        session.setAttribute("user", user1);
        session.setMaxInactiveInterval(604800);
        return row;
    }

    //密码修改功能
    @RequestMapping("/password_edit")
    public int password_edit(String admin_user_id, String login_password, String new_password, HttpSession session) {
        System.out.println("老密码"+ DigestUtils.md5DigestAsHex(login_password.getBytes()));
        System.out.println("新密码"+ DigestUtils.md5DigestAsHex(new_password.getBytes()));
        int row = backStageService.password_edit(admin_user_id, DigestUtils.md5DigestAsHex(login_password.getBytes()), DigestUtils.md5DigestAsHex(new_password.getBytes()));
        //用id查询出修改好的用户然后存入seesion中
        User user1 = backStageService.userfindById(Integer.parseInt(admin_user_id));
        session.setAttribute("user", user1);
        session.setMaxInactiveInterval(604800);
        return row;
    }
}

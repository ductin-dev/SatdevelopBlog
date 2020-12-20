//package com.satellite.myblog.action;
//
//import com.opensymphony.xwork2.ActionSupport;
//import com.satellite.model.Blog.Blog;
//import com.satellite.model.Blog.BlogSevices;
//import com.satellite.model.DatabaseDAO;
//import org.apache.struts2.interceptor.SessionAware;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Map;
//
//public class BlogController extends ActionSupport implements SessionAware {
//    //View Blog
//    private int viewingBlog_id;
//    private Blog viewingBlog = new Blog();
//
//    //Add Blog
//    private String category;
//    private String title;
//    private String description;
//    private String createdby;
//    private String image;
//    private String blogContent;
//
//    //Edit Blog
//    private int editingBlog_id;
//    private int editingThisBlog_id;
//    private String category1;
//    private String title1;
//    private String description1;
//    private String createdby1;
//    private String image1;
//    private String blogContent1;
//
//    //Delete Blog
//    private int deletingBlog_id;
//
//    public static ArrayList<Blog> blogList = new ArrayList<>();
//    public static ArrayList<Blog> blogList_Life = new ArrayList<>();
//    public static ArrayList<Blog> blogList_IT = new ArrayList<>();
//    public static ArrayList<Blog> blogList_TUT = new ArrayList<>();
//    public static ArrayList<Blog> blogList_Other = new ArrayList<>();
//    public Map<String, Object> session;
//
//    public String execute() throws Exception {
//        return "success";
//    }
//
//    public String getAllBlogList() {
//        try {
//            //Init
//            BlogSevices dataController = new BlogSevices();
//            DatabaseDAO db = new DatabaseDAO();
//
//            //Validation
//
//            //Excute
//            try {
//                db.openConnection();
//                dataController.setConnection(db.getConnection());
//                blogList = dataController.selectAll();
//                db.closeConnection();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                db.closeConnection();
//            }
//
//            //Update list
//            blogList_Life = new ArrayList<>();
//            blogList_IT = new ArrayList<>();
//            blogList_TUT = new ArrayList<>();
//            blogList_Other = new ArrayList<>();
//            for (Blog i : blogList) {
//                switch (i.getCategory()) {
//                    case "LIFE":
//                        blogList_Life.add(i);
//                        break;
//                    case "IT":
//                        blogList_IT.add(i);
//                        break;
//                    case "TUT":
//                        blogList_TUT.add(i);
//                        break;
//                    default:
//                        blogList_Other.add(i);
//                        break;
//                }
//            }
//            //View
//        } catch (Exception e) {
//            e.printStackTrace();
//            session.put("log_blog", e.toString().replaceAll("java.lang.Exception: ", ""));
//            return "failure";
//        }
//        return "success";
//    }
//
//    public String viewBlog() {
//        try {
//            //Init
//            BlogSevices dataController = new BlogSevices();
//            DatabaseDAO db = new DatabaseDAO();
//
//            //Validation
//
//            //Excute
//            try {
//                db.openConnection();
//                dataController.setConnection(db.getConnection());
//                viewingBlog = dataController.selectById(viewingBlog_id);
//                viewingBlog.setView(viewingBlog.getView() + 1);
//                dataController.updateViewRate(viewingBlog);
//                db.closeConnection();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                db.closeConnection();
//            }
//
//            //View
//        } catch (Exception e) {
//            e.printStackTrace();
//            session.put("log_blog", e.toString().replaceAll("java.lang.Exception: ", ""));
//            return "failure";
//        }
//        return "success";
//    }
//
//    public String addBlog() {
//        try {
//            //Init
//            BlogSevices dataController = new BlogSevices();
//            DatabaseDAO db = new DatabaseDAO();
//
//            //Validation
//            if (session.get("user")==null) throw new Exception("Not Login");
//            Validation.validateEmpty(category);
//            Validation.validateEmpty(title);
//            Validation.validateEmpty(description);
//            Validation.validateEmpty(image);
//            Validation.validateEmpty(createdby);
//            Validation.validateVarchar(category,40);
//
//            //Excute
//            try {
//                db.openConnection();
//                dataController.setConnection(db.getConnection());
//                Blog a = new Blog(category, title, description, image, blogContent, createdby, 0, 0);
//                dataController.add(a);
//                db.closeConnection();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                db.closeConnection();
//            }
//
//            //View
//        } catch (Exception e) {
//            e.printStackTrace();
//            session.put("log_blogadd", e.toString().replaceAll("java.lang.Exception: ", ""));
//            return "failure";
//        }
//        return "success";
//    }
//
//    public String editBlog() {
//        try {
//            //Init
//            BlogSevices dataController = new BlogSevices();
//            DatabaseDAO db = new DatabaseDAO();
//
//            //Validation
//            if (session.get("user")==null) throw new Exception("Not Allowed");
//
//            //Excute
//            try {
//                db.openConnection();
//                dataController.setConnection(db.getConnection());
//                Blog a=dataController.selectById(editingBlog_id);
//                category1=a.getCategory();
//                title1=a.getTitle();
//                description1=a.getDescription();
//                image1=a.getImage();
//                createdby1=a.getCreatedby();
//                blogContent1=a.getText();
//                db.closeConnection();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                db.closeConnection();
//            }
//
//            //View
//        } catch (Exception e) {
//            e.printStackTrace();
//            session.put("log_blogedit", e.toString().replaceAll("java.lang.Exception: ", ""));
//            return "failure";
//        }
//        return "success";
//    }
//    public String editThisBlog() {
//        try {
//            //Init
//            BlogSevices dataController = new BlogSevices();
//            DatabaseDAO db = new DatabaseDAO();
//            //Validation
//            if (session.get("user")==null) throw new Exception("Not Allowed");
//            Validation.validateEmpty(category1);
//            Validation.validateEmpty(title1);
//            Validation.validateEmpty(description1);
//            Validation.validateEmpty(image1);
//            Validation.validateEmpty(createdby1);
//            Validation.validateVarchar(category1,40);
//
//            //Excute
//            try {
//                db.openConnection();
//                dataController.setConnection(db.getConnection());
//                Blog a = new Blog(category1, title1, description1, image1, blogContent1, createdby1, 0, 0);
//                a.setId(editingThisBlog_id);
//                dataController.update(a);
//                db.closeConnection();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                db.closeConnection();
//            }
//
//            //View
//        } catch (Exception e) {
//            e.printStackTrace();
//            session.put("log_blogedit", e.toString().replaceAll("java.lang.Exception: ", ""));
//            return "failure";
//        }
//        return "success";
//    }
//
//    public String deleteBlog() {
//        try {
//            //Init
//            BlogSevices dataController = new BlogSevices();
//            DatabaseDAO db = new DatabaseDAO();
//
//            //Validation
//            if (session.get("user")==null) throw new Exception("Not Allowed");
//
//            //Excute
//            try {
//                db.openConnection();
//                dataController.setConnection(db.getConnection());
//                dataController.delete(deletingBlog_id);
//                db.closeConnection();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                db.closeConnection();
//            }
//
//            //View
//        } catch (Exception e) {
//            e.printStackTrace();
//            session.put("log_blog", e.toString().replaceAll("java.lang.Exception: ", ""));
//            return "failure";
//        }
//        return "success";
//    }
//    @Override
//    public void setSession(Map<String, Object> map) {
//        session = map;
//    }
//
//    public Blog getViewingBlog() {
//        return viewingBlog;
//    }
//
//    public void setViewingBlog(Blog viewingBlog) {
//        this.viewingBlog = viewingBlog;
//    }
//
//    public int getViewingBlog_id() {
//        return viewingBlog_id;
//    }
//
//    public void setViewingBlog_id(int viewingBlog_id) {
//        this.viewingBlog_id = viewingBlog_id;
//    }
//
//    public String getBlogContent() {
//        return blogContent;
//    }
//
//    public void setBlogContent(String blogContent) {
//        this.blogContent = blogContent;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getCreatedby() {
//        return createdby;
//    }
//
//    public void setCreatedby(String createdby) {
//        this.createdby = createdby;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public String getCategory1() {
//        return category1;
//    }
//
//    public void setCategory1(String category1) {
//        this.category1 = category1;
//    }
//
//    public String getTitle1() {
//        return title1;
//    }
//
//    public void setTitle1(String title1) {
//        this.title1 = title1;
//    }
//
//    public String getDescription1() {
//        return description1;
//    }
//
//    public void setDescription1(String description1) {
//        this.description1 = description1;
//    }
//
//    public String getCreatedby1() {
//        return createdby1;
//    }
//
//    public void setCreatedby1(String createdby1) {
//        this.createdby1 = createdby1;
//    }
//
//    public String getImage1() {
//        return image1;
//    }
//
//    public void setImage1(String image1) {
//        this.image1 = image1;
//    }
//
//    public String getBlogContent1() {
//        return blogContent1;
//    }
//
//    public void setBlogContent1(String blogContent1) {
//        this.blogContent1 = blogContent1;
//    }
//
//    public int getDeletingBlog_id() {
//        return deletingBlog_id;
//    }
//
//    public void setDeletingBlog_id(int deletingBlog_id) {
//        this.deletingBlog_id = deletingBlog_id;
//    }
//
//    public int getEditingBlog_id() {
//        return editingBlog_id;
//    }
//
//    public void setEditingBlog_id(int editingBlog_id) {
//        this.editingBlog_id = editingBlog_id;
//    }
//
//    public int getEditingThisBlog_id() {
//        return editingThisBlog_id;
//    }
//
//    public void setEditingThisBlog_id(int editingThisBlog_id) {
//        this.editingThisBlog_id = editingThisBlog_id;
//    }
//}
package com.satellite.myblog.model.Blog;

import java.io.Serializable;

public class Blog implements Serializable {
    private static final long serialVersionUID = -6500665823330706018L;

    private int id;
    private String category;
    private String title;
    private String description;
    private String image;
    private String text;
    private String datecreated;
    private String datemodified;
    private String createdby;
    private int view;
    private float rate;

    public Blog() {
    }

    public Blog(String category,String title, String description,String image, String text, String createdby, int view, float rate) {
        this.category=category;
        this.title = title;
        this.description = description;
        this.image=image;
        this.text = text.replace("/(?:\r\n|\r|\n)/g", "<br>");
        this.createdby = createdby;
        this.view = view;
        this.rate = rate;
    }

    public Blog(int id,String category, String title, String description,String image, String text, String datecreated, String datemodified, String createdby, int view, float rate) {
        this.id = id;
        this.category=category;
        this.title = title;
        this.description = description;
        this.image=image;
        this.text = text;
        this.datecreated = datecreated;
        this.datemodified = datemodified;
        this.createdby = createdby;
        this.view = view;
        this.rate = rate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category=category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image=image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

    public String getDatemodified() {
        return datemodified;
    }

    public void setDatemodified(String datemodified) {
        this.datemodified = datemodified;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", text='" + text + '\'' +
                ", datecreated='" + datecreated + '\'' +
                ", datemodified='" + datemodified + '\'' +
                ", createdby='" + createdby + '\'' +
                ", view=" + view +
                ", rate=" + rate +
                '}';
    }
}

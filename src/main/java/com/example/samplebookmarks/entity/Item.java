package com.example.samplebookmarks.entity;

import javax.persistence.Entity;

@Entity
public class Item extends BaseEntity {

    private String title;
    private String url;
    private String note;
    private Long   user_id;
    
    //private User user;
    
    public Item(){
    }
    
    public Item(String title, String url, String note){
        this.title = title;
        this.url = url;
        this.note = note;
    }
    
    
    /*
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    */
    
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
    
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }


    
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }    
    
}
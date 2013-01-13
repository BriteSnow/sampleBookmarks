package com.example.samplebookmarks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class User extends BaseEntity {

    private Long   id; 
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String photoUrl;
    
    public User(){};

    public User(String userName, String password, String firstName, String lastName){
        setUserName(userName);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
    }

    @Transient
    public String getFullName(){
        StringBuilder sb = new StringBuilder();
        if (firstName != null){
            sb.append(firstName).append(" ");
        }
        if (lastName != null){
            sb.append(lastName);
        }
        if (firstName == null && lastName == null){
            sb.append(userName);
        }
        return sb.toString();
    }
    
    // --------- Persistent Properties --------- //
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    // --------- /Persistent Properties --------- //
    
    
}

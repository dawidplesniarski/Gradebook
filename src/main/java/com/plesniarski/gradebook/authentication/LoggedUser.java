package com.plesniarski.gradebook.authentication;

import com.plesniarski.gradebook.domain.dto.AllUsersDto;

import java.io.Serializable;

public class LoggedUser implements Serializable {
    private String token;
    private Long userId;
    private String name;
    private String lastName;
    private Long albumNo;
    private boolean admin;
    private Long universityId;
    private String login;
    private String course;

    public LoggedUser(){}

    public LoggedUser(Builder builder){
        token = builder.token;
        userId = builder.userId;
        name = builder.name;
        lastName = builder.lastName;
        albumNo = builder.albumNo;
        admin = builder.admin;
        universityId = builder.universityId;
        login = builder.login;
        course = builder.course;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getAlbumNo() {
        return albumNo;
    }

    public boolean isAdmin() {
        return admin;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public String getLogin() {
        return login;
    }

    public String getCourse() {
        return course;
    }

    public String getToken() {
        return token;
    }

    public static final class Builder{
        private String token;
        private Long userId;
        private String name;
        private String lastName;
        private Long albumNo;
        private boolean admin;
        private Long universityId;
        private String login;
        private String course;

        public Builder token(String token){
            this.token = token;
            return this;
        }
        public Builder id(Long userId){
            this.userId = userId;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder albumNo(Long albumNo){
            this.albumNo = albumNo;
            return this;
        }
        public Builder admin(boolean admin){
            this.admin = admin;
            return this;
        }
        public Builder universityId(Long universityId){
            this.universityId = universityId;
            return this;
        }
        public Builder login(String login){
            this.login = login;
            return this;
        }
        public Builder course(String course){
            this.course = course;
            return this;
        }

        public LoggedUser build(){
            return new LoggedUser(this);
        }

    }
}

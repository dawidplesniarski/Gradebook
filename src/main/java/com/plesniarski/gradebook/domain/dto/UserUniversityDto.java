package com.plesniarski.gradebook.domain.dto;

public class UserUniversityDto {
    private Long userId;
    private String name;
    private String lastName;
    private Long albumNo;
    private Boolean admin;
    private String universityName;

    public UserUniversityDto(Builder builder){
        userId = builder.userId;
        name = builder.name;
        lastName = builder.lastName;
        albumNo = builder.albumNo;
        admin = builder.admin;
        universityName = builder.universityName;
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

    public Boolean getAdmin() {
        return admin;
    }

    public String getUniversityName() {
        return universityName;
    }

    public static final class Builder{
        private Long userId;
        private String name;
        private String lastName;
        private Long albumNo;
        private Boolean admin;
        private String universityName;

        public Builder userId(Long userId){
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
        public Builder isAdmin(Boolean admin){
            this.admin = admin;
            return this;
        }
        public Builder universityName(String universityName){
            this.universityName = universityName;
            return this;
        }

        public UserUniversityDto build(){
            return new UserUniversityDto(this);
        }

    }
}
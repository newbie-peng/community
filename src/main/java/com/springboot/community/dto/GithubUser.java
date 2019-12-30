package com.springboot.community.dto;

/**
 * ClassName:GithubUser
 * Package:com.springboot.community.dto
 * Descripetion:
 *
 * @Date:2019/12/30 11:29
 * @Author: 李一鹏
 */
public class GithubUser {
    private String name;
    private Long id;
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}

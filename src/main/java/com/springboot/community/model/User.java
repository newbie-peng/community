package com.springboot.community.model;

/**
 * ClassName:User
 * Package:com.springboot.community.model
 * Descripetion:
 *
 * @Date:2019/12/30 16:27
 * @Author: 李一鹏
 */
public class User {
    private Integer id;
    private String name ;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long getModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGetModified() {
        return getModified;
    }

    public void setGetModified(Long getModified) {
        this.getModified = getModified;
    }
}

package com.springboot.community.dao;

import com.springboot.community.model.User;

/**
 * ClassName:UserDao
 * Package:com.springboot.community.dao
 * Descripetion:
 *
 * @Date:2019/12/30 20:47
 * @Author: 李一鹏
 */
public interface UserDao {
    /**
     * 向数据库中插入 新的用户数据
     * @param name 用户的名字
     * @param accountId 用户在别的平台上的id
     * @param token 用户的token值
     * @param gmtCreat 用户的创建时间
     * @param gmtModified 用户的更新时间
     * @return 返回查询到的用户信息
     */
    public Boolean insert(String name,String accountId,String token,Long gmtCreat,Long gmtModified);

    /**
     * 根据用户的id查询制定的用户
     * @param id  用户的id
     * @return 返回查询到的用户信息
     */
    public User selectOne(Integer id);

    /**
     * 根据制定的条件查询数据库中用户的数据
     * @param connection 制定的条件
     * @return 返回查询到的用户信息
     */
    public User selectBy(String connection);

    /**
     * 查询数据库中所有的用户数据
     * @return 返回查询到的用户信息
     */
    public User selectAll();

}

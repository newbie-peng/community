package com.springboot.community.dao;

import com.springboot.community.model.User;
import com.springboot.community.util.DbLinkUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.management.Query;
import java.sql.SQLException;

/**
 * ClassName:UserDaoImpl
 * Package:com.springboot.community.dao
 * Descripetion:
 *
 * @Date:2019/12/30 20:58
 * @Author: 李一鹏
 */
public class UserDaoImpl implements UserDao {
    @Override
    public Boolean insert(String name, String accountId, String token, Long gmtCreat, Long gmtModified) {
        QueryRunner queryRunner = new QueryRunner(DbLinkUtils.getDataSource());
        String sql ="INSERT INTO users (name,accountId,token,gmtCreat,gmtModified) values(?,?,?,?,?)";
        try {
            int update = queryRunner.update(sql, name, accountId, token, gmtCreat, gmtModified);
            if (update!=0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User selectOne(Integer id) {
        return null;
    }

    @Override
    public User selectBy(String connection) {
        QueryRunner queryRunner = new QueryRunner(DbLinkUtils.getDataSource());
        String sql = "select * from users where token=?";
        try {
            User query = queryRunner.query(sql, new BeanHandler<>(User.class), connection);
            return query;
        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public User selectAll() {
        return null;
    }
}

package com.springboot.community.util;

import com.springboot.community.dao.HikarMysql;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ClassName:DbLinkUtils
 * Package:com.springboot.community.util
 * Descripetion:
 *
 * @Date:2019/12/30 21:05
 * @Author: 李一鹏
 */
public class DbLinkUtils {
    private static HikariDataSource hikariDataSource;
    //静态代码块 - 随着该类的字节码文件加载而加载，整个类的生命周期中，只记载一次。
    static{
        //池通过数据库连接  连接数据库
        URL resource = HikarMysql.class.getResource("/hikari.properties");
        HikariConfig confing = new HikariConfig(resource.getPath());
        hikariDataSource = new HikariDataSource(confing);
    }
    public static Connection getConnection() throws SQLException {
        //获取数据库连接对象
        Connection connection =hikariDataSource.getConnection();
        //返回数据库连接对象
        return connection;
    }
    //关闭资源
    public static void myClose(ResultSet resultSet, Statement statement, Connection connection){
        if(resultSet !=null){
            try{
                resultSet.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try{
                statement.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try{
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public static HikariDataSource getDataSource() {
        return hikariDataSource;
    }

}

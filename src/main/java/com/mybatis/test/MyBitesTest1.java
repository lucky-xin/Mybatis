package com.mybatis.test;

import com.ssm.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBitesTest1 {
    //原始方法   重复代码多
    // sqlSession.update("test.updateUser", user); “test.updateUser”硬编码
    //如果“test.updateUser”写错  到执行阶段才会发现
    private static SqlSession sqlSession = null;

    static {
        // 1.获取配置文件
        String resource = "SqlMapConfig.xml";
        InputStream in;
        try {
            in = Resources.getResourceAsStream(resource);
            // 2.创建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            sqlSession = factory.openSession();
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }

    }

    @Test
    public void updateUser() {
        try {
            // 4.通过SQLSession操作数据库
            // 第一个参数：映射文件中statement的id,等于命名空间.id
            // 第二个参数：指定和映射文件中所匹配的parameterType类型参数
            User user = new User("Tencent@qq.com", "马化腾", "男", new Date(
                    20121212), "北京", "Tencent");
            user.setId(10);
            sqlSession.update("com.mybatis.mapper.UserMapper.updateUser", user);
            sqlSession.commit();

        } finally {
            if (sqlSession != null) {
                try {
                    // 5.释放资源
                    sqlSession.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                }
            }

        }

    }

    @Test
    public void deleteUser() {
        try {
            if (sqlSession == null) {
                return;
            }
            // 4.通过SQLSession操作数据库
            // 第一个参数：映射文件中statement的id,等于命名空间.id
            // 第二个参数：指定和映射文件中所匹配的parameterType类型参数
            sqlSession.delete("com.mybatis.mapper.UserMapper.deleteUser", 37);
            sqlSession.commit();
        } finally {
            if (sqlSession != null) {
                try {
                    // 5.释放资源
                    sqlSession.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                }
            }

        }

    }

    @Test
    public void insertUser() {
        try {
            if (sqlSession == null) {
                return;
            }

            // 4.通过SQLSession操作数据库
            // 第一个参数：映射文件中statement的id,等于命名空间.id
            // 第二个参数：指定和映射文件中所匹配的parameterType类型参数
            User user = new User("1314@qq.com", "范冰冰", "女",
                    new Date(), "北京", "zlibaba");

            sqlSession.selectList("com.mybatis.mapper.UserMapper.insertUser", user);
            sqlSession.commit();
        } catch (Exception e) {
        } finally {
            if (sqlSession != null) {
                try {
                    // 5.释放资源
                    sqlSession.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                }
            }

        }

    }

    @Test
    public void findUserByName() {
        try {
            if (sqlSession == null) {
                return;
            }
            // 4.通过SQLSession操作数据库
            // 第一个参数：映射文件中statement的id,等于命名空间.id
            // 第二个参数：指定和映射文件中所匹配的parameterType类型参数
            List<User> list = sqlSession
                    .selectList("com.mybatis.mapper.UserMapper.findUserByName", "范冰冰");
            for (User user : list) {
                System.out.println(user);
            }
        } finally {
            if (sqlSession != null) {
                try {
                    // 5.释放资源
                    sqlSession.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                }
            }

        }

    }

    @Test
    public void findUserById() throws Exception {
        // 1.获取配置文件
        String resource = "SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 2.创建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3.通过工厂得到SQLSession
        SqlSession sqlSession = factory.openSession();
        // 4.通过SQLSession操作数据库
        // 第一个参数：映射文件中statement的id,等于命名空间.id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型参数
        User user = sqlSession.selectOne("com.mybatis.mapper.UserMapper.findUserById", 1);
        System.out.println(user);
        // 5.释放资源
        sqlSession.close();
    }
}

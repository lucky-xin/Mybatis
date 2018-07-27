package com.mybatis.mapper;

import com.mybatis.utils.MySqlSessionFactory;
import com.ssm.po.User;
import com.ssm.po.UserCustom;
import com.ssm.po.UserQueryVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

    static SqlSession sqlSession = null;
    static UserMapper userMapper = null;

    static {
        sqlSession = MySqlSessionFactory.openSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void test1(){
        String str="";
        String resource = str.getClass().getName().replace('.', '/') + ".java (best guess)";
        System.out.println(resource);
    }
    @Test
    public void testFindUserById() throws Exception {
//        userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper);
        User user = userMapper.findUserById(42);
        //User [id=42, name=Ivan, password=123, email=1314@qq.com, sex=男, birth=Thu Jan 01 00:00:00 CST 1970, address=长沙]
        System.out.println(user);
    }

    //一级缓存: 也就SqlSession级的缓存(默认开启) SqlSession执行相同sql语句，第一次查询完毕会将数据库中查询的数据写入缓存，之后
    //此后再用此SqlSession执行相同的语句会从缓存之中读取数据
    //session commit或close后,缓存就会被清空
    @Test
    public void testCache() throws Exception {
        //只执行一次查询 select *from user_tbl where id=?
        User user1;
        User user2;
        user1 = userMapper.findUserById(42);
        System.out.println(user1);
        user2 = userMapper.findUserById(42);
        System.out.println(user2);
        System.out.println(user2==user1);
    }

    //二级缓存测试 namespace="com.mybatis.mapper.UserMapper"级
    //多个SqlSession执行相同的语句只会执行第一次请求，之后从缓存之中读取数据
    @Test
    public void testCache1() throws Exception {
        List<User> users1;
        List<User> users2;
        List<User> users3;
        //只执行一次select *from user_tbl where name like '%冰冰%'  跨session
        SqlSession sqlSession1 = MySqlSessionFactory.openSqlSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        users1 = userMapper1.findUserByName("冰冰");
        System.out.println(users1);
        sqlSession1.close();

        SqlSession sqlSession2 = MySqlSessionFactory.openSqlSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        users2 = userMapper2.findUserByName("冰冰");
        System.out.println(users2);
        System.out.println();
        sqlSession2.close();

        SqlSession sqlSession3 = MySqlSessionFactory.openSqlSession();
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
        users3 = userMapper3.findUserByName("冰冰");
        System.out.println(users3);
        sqlSession3.close();
    }

    @Test
    public void testFindUserByResultMap() throws Exception {
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByNames() throws Exception {
        List<User> user = userMapper.findUserByName("冰冰");
        System.out.println(user);
    }

    // 综合查询测试
    @Test
    public void testFindUserList() throws Exception {
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom custom = new UserCustom();
        //foreach测试
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(42);
        ids.add(43);
        ids.add(44);
        ids.add(45);

        custom.setSex("男");
        custom.setName("Ivan");
        userQueryVo.setUserCustom(custom);
        userQueryVo.setIds(ids);
        List<UserCustom> customs = userMapper.findUserList(userQueryVo);
        System.out.println(customs);
    }

    @Test
    public void testFindUserByHashMap() throws Exception {
        //构造查询条件Hashmap对象
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", 43);
        map.put("username", "Ivan");

        //传递HashMap对象查询用户列表
        List<User> list = userMapper.findUserByHashMap(map);
        System.out.println(list);
        //关闭session
        sqlSession.close();
    }

    @Test
    public void testFindUserCount() throws Exception {
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom custom = new UserCustom();
        custom.setSex("男");
        custom.setName("Ivan");
        userQueryVo.setUserCustom(custom);
        int count = userMapper.findUserCount(userQueryVo);
        System.out.println(count);
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User("范冰冰@qq.com", "范冰冰", "女",
                new java.sql.Date(System.currentTimeMillis()), "北京", "123456789");
        userMapper.updateUser(user);
        sqlSession.commit();
    }

    @Test
    public void testDeleteUser() {
        sqlSession = MySqlSessionFactory.getSqlSessionFactory().openSession(false);
        userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            userMapper.deleteUser(33);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsertUser() throws Exception {
        User user = new User("1314@qq.com", "Ivan", "男",
                new java.sql.Date(new Date().getDate()), "长沙", "123");
        userMapper.insertUser(user);
        sqlSession.commit();
    }

    @Test
    public void testDate() {
        Date date = new Date(2016 + 1900, 9, 13);
        System.out.println(date);
    }
}

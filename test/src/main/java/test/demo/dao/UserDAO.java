package test.demo.dao;


import test.demo.model.User;


public interface UserDAO {
 
    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);
     
     
}
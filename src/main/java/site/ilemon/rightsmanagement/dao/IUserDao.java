package site.ilemon.rightsmanagement.dao;
import site.ilemon.rightsmanagement.entity.*;

import java.util.List;

/**
 * 用户数据层接口
 * Created by andy on 2018/12/26.
 */
public interface IUserDao {

    /**
     * 添加user到表t_user
     * @param user
     * @return 新增的主键
     */
    public int insert(User user);

    public int update(User user);

    public List<User> listUser();

    public User getUserById();

    public int delete(Integer id);
    
    public User getUserByName(String username);
}

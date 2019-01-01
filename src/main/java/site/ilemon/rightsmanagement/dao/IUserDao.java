package site.ilemon.rightsmanagement.dao;
import java.util.List;
import java.util.Map;

import site.ilemon.rightsmanagement.entity.User;
import site.ilemon.rightsmanagement.util.SearchCondition;

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

    public Integer countUser(SearchCondition searchCondition);
    
    public List<User> listUser(SearchCondition searchCondition);

    public User getUserById();

    public int delete(Integer id);
    
    public User getUserByName(String username);
    
    public List<Map<String,Object>> getFreqOfCreateUser();
}

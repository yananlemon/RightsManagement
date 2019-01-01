package site.ilemon.rightsmanagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import site.ilemon.rightsmanagement.entity.Permission;
import site.ilemon.rightsmanagement.entity.User;
import site.ilemon.rightsmanagement.util.Pagination;
import site.ilemon.rightsmanagement.util.SearchCondition;

/**
 * Created by andy on 2018/12/26.
 */
public interface IUserService {

    public int insert(User user);

    public int update(User user);

    public Pagination<User> listUser(SearchCondition searchCondition);
    
    public Page<User> listUser2(SearchCondition searchCondition);
    

    public User getUserById();

    public int delete(Integer id);

	public User getUserByName(String username);
	
	public List<Permission> listPermissionOfUser(int userId);
	
	 public List<Map<String,Object>> getFreqOfCreateUser();
}

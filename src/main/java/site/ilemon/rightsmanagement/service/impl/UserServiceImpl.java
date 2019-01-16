package site.ilemon.rightsmanagement.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import site.ilemon.rightsmanagement.dao.IPermissionDao;
import site.ilemon.rightsmanagement.dao.IUserDao;
import site.ilemon.rightsmanagement.entity.Permission;
import site.ilemon.rightsmanagement.entity.Role;
import site.ilemon.rightsmanagement.entity.User;
import site.ilemon.rightsmanagement.service.IRoleService;
import site.ilemon.rightsmanagement.service.IUserService;
import site.ilemon.rightsmanagement.util.Pagination;
import site.ilemon.rightsmanagement.util.SearchCondition;

/**
 * Created by andy on 2018/12/26.
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
    private IUserDao userDao;
	
	@Autowired
    private IPermissionDao permissionDao;
	
	@Autowired
    private IRoleService roleService;
	
	public HashSet<Permission> listPermissionOfUser(int userId){
		HashSet<Permission> set = new HashSet<Permission>();
		List<Role> roles = roleService.listRoleByUserId(userId);
		for(Role role:roles){
			set.addAll(permissionDao.listPermissionsByRoleId(role.getId()));
		}
		return set;
	}

	/**
	 * 新增用户
	 */
    public int insert(User user) {
    	if( user.getPassword() == null )
    		user.setPassword("123456");
    	final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String password = passwordEncoder.encode(user.getPassword());
    	user.setPassword(password);
    	int rs = userDao.insert(user);
        return rs;
    }

    public int update(User user) {
        return 0;
    }
    
    public Pagination<User> listUser(SearchCondition searchCondition) {
    	try {
    		Integer count = userDao.countUser(searchCondition);
    		if( count < searchCondition.getPageSize() && searchCondition.getCurrPage().intValue() > 1){
    			searchCondition.setCurrPage(1);
    			searchCondition.setStartRow(searchCondition.getCurrPage() == 1 ? 0 : (searchCondition.getCurrPage()-1)*(searchCondition.getPageSize()));
    		}
    		//count % searchCondition.getPageSize()
    		List<User> users = userDao.listUser(searchCondition);
    		Pagination<User> rs = new Pagination<User>(searchCondition.getCurrPage(),count,searchCondition.getPageSize(),users);
    		rs.setStartRow(searchCondition.getStartRow());
    		rs.setEndRow(searchCondition.getStartRow()+users.size());
    		return rs;
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }

    public User getUserById() {
        return null;
    }

    public int delete(Integer id) {
        return 0;
    }

	@Override
	public User getUserByName(String username) {
		return userDao.getUserByName(username);
	}

	@Override
	public Page<User> listUser2(SearchCondition searchCondition) {
		
		return null;
	}

	@Override
	public List<Map<String,Object>> getFreqOfCreateUser() {
		return userDao.getFreqOfCreateUser();
	}
}

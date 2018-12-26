package site.ilemon.rightsmanagement.service.impl;

import site.ilemon.rightsmanagement.dao.IUserDao;
import site.ilemon.rightsmanagement.entity.User;
import site.ilemon.rightsmanagement.service.IUserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by andy on 2018/12/26.
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
    private IUserDao userDao;

	/**
	 * 新增用户
	 */
    public int insert(User user) {
    	final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String password = passwordEncoder.encode(user.getPassword());
    	user.setPassword(password);
    	int rs = userDao.insert(user);
        return rs;
    }

    public int update(User user) {
        return 0;
    }

    public List<User> listUser() {

        return userDao.listUser();
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
}

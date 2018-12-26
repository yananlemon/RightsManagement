package site.ilemon.rightsmanagement.service;

import java.util.List;

import site.ilemon.rightsmanagement.entity.User;

/**
 * Created by andy on 2018/12/26.
 */
public interface IUserService {

    public int insert(User user);

    public int update(User user);

    public List<User> listUser();

    public User getUserById();

    public int delete(Integer id);

	public User getUserByName(String username);
}

package site.ilemon.rightsmanagement.dao;
import java.util.List;

import site.ilemon.rightsmanagement.entity.PermissionInput;
import site.ilemon.rightsmanagement.entity.Role;
import site.ilemon.rightsmanagement.entity.UserRoleInput;
import site.ilemon.rightsmanagement.util.SearchCondition;

/**
 * 用户数据层接口
 * Created by andy on 2019/1/2.
 */
public interface IRoleDao {

	public List<Role> listRole();
    
    public List<Role> listRoleByCondition(SearchCondition searchCondition);
    
    public Integer countRole(SearchCondition searchCondition);
    
    public Integer deleteRelation(int roleId);
    
    public Integer insertRelation(PermissionInput param);

	public List<Role> listRoleByUserId(int userId);
	
	public Integer deleteUserRoleRelation(int userId);
	    
    public Integer insertUserRoleRelation(UserRoleInput param);

}

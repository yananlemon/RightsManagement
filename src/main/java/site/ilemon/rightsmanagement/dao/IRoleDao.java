package site.ilemon.rightsmanagement.dao;
import java.util.List;

import site.ilemon.rightsmanagement.entity.PermissionInput;
import site.ilemon.rightsmanagement.entity.Role;
import site.ilemon.rightsmanagement.util.SearchCondition;

/**
 * 用户数据层接口
 * Created by andy on 2019/1/2.
 */
public interface IRoleDao {

    
    public List<Role> listRole(SearchCondition searchCondition);
    
    public Integer countRole(SearchCondition searchCondition);
    
    public Integer deleteRelation(int roleId);
    
    public Integer insertRelation(PermissionInput param);

}

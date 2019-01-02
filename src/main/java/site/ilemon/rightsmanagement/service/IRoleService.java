package site.ilemon.rightsmanagement.service;

import java.util.List;

import site.ilemon.rightsmanagement.entity.PermissionMenu;
import site.ilemon.rightsmanagement.entity.Role;
import site.ilemon.rightsmanagement.util.Pagination;
import site.ilemon.rightsmanagement.util.SearchCondition;

/**
 * Created by andy on 2018/12/26.
 */
public interface IRoleService {

   
    public Pagination<Role> listRole(SearchCondition searchCondition);
    
    public List<PermissionMenu> getPermissionOfRole(int roleId);
    
}

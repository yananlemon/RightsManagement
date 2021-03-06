package site.ilemon.rightsmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.ilemon.rightsmanagement.dao.IPermissionDao;
import site.ilemon.rightsmanagement.dao.IRoleDao;
import site.ilemon.rightsmanagement.entity.Permission;
import site.ilemon.rightsmanagement.entity.PermissionInput;
import site.ilemon.rightsmanagement.entity.PermissionMenu;
import site.ilemon.rightsmanagement.entity.Role;
import site.ilemon.rightsmanagement.entity.State;
import site.ilemon.rightsmanagement.entity.UserRoleInput;
import site.ilemon.rightsmanagement.service.IRoleService;
import site.ilemon.rightsmanagement.util.Pagination;
import site.ilemon.rightsmanagement.util.SearchCondition;

/**
 * Created by andy on 2018/12/26.
 */
@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Autowired
	private IPermissionDao permissionDao;


	@Override
	public List<PermissionMenu> getPermissionOfRole(int roleId) {
		List<PermissionMenu> rs = new ArrayList<PermissionMenu>();
		List<Permission> permissions = permissionDao.listPermissions();// 1-8
		List<Permission> permissionsOfRole = permissionDao.listPermissionsByRoleId(roleId);//1-4
		int id = 1;
		for(Permission per : permissions){
			if(per.getParentPermissionCode().equals("root")){
				PermissionMenu menu = new PermissionMenu();
				menu.setText(per.getPermissionText());
				menu.setCode(per.getPermissionCode());
				menu.setParentCode("root");
				menu.setNodeId(id++);
				if(permissionsOfRole.contains(per)){
					menu.setState(new State(true,true));
				}
				for(Permission child : permissions){
					if(child.getParentPermissionCode().equals(per.getPermissionCode())){
						PermissionMenu cMenu = new PermissionMenu(
								child.getPermissionText(),
								child.getPermissionCode(),
								child.getParentPermissionCode()
								);
						cMenu.setNodeId(id++);
						if(permissionsOfRole.contains(child)){
							cMenu.setState(new State(true,true));
						}

						menu.addChild(cMenu);
					}
				}
				rs.add(menu);
			}

		}
		return rs;
	}


	@Override
	public Pagination<Role> listRole(SearchCondition searchCondition) {
		try {
			Integer count = roleDao.countRole(searchCondition);
			List<Role> users = roleDao.listRoleByCondition(searchCondition);
			Pagination<Role> rs = new Pagination<Role>(searchCondition.getCurrPage(),count,users);
			return rs;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Role> listRole() {
		try {
			List<Role> roles = roleDao.listRole();
			return roles;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public int savePerission(PermissionInput param) throws Exception{
		int rs = 0;
		int deleteAff = roleDao.deleteRelation(param.getRoleId());
		if( deleteAff < 0 )
			throw new Exception();
		int insertAff = roleDao.insertRelation(param);
		if( insertAff < 0 )
			throw new Exception();
		rs = 1;
		return rs;

	}


	@Override
	public List<Role> listRoleByUserId(int userId) {
		return roleDao.listRoleByUserId(userId);
	}
	
	public int saveUserRole(UserRoleInput param)throws Exception{
		int rs = 0;
		int deleteAff = roleDao.deleteUserRoleRelation(param.getUserId());
		if( deleteAff < 0 )
			throw new Exception();
		int insertAff = roleDao.insertUserRoleRelation(param);
		if( insertAff < 0 )
			throw new Exception();
		rs = 1;
		return rs;
	}
}

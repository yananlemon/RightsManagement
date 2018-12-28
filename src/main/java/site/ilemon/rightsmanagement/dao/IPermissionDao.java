package site.ilemon.rightsmanagement.dao;
import site.ilemon.rightsmanagement.entity.*;

import java.util.List;

/**
 * 用户数据层接口
 * Created by andy on 2018/12/26.
 */
public interface IPermissionDao {


    public List<Permission> listPermissionsByUserId(Integer id);

}

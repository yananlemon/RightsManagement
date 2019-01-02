package site.ilemon.rightsmanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import site.ilemon.rightsmanagement.service.IRoleService;
import site.ilemon.rightsmanagement.util.SearchCondition;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

	@Autowired
	private IRoleService service;
	
	@Test
	public void contextLoads() {
		SearchCondition condition = new SearchCondition(1);
		condition.setCurrPage(1);
		condition.setStartRow(0);
		condition.setEndRow(10);
		System.out.println(service.listRole(condition));
	}
	
	@Test
	public void testgetPermissionOfRole(){
		System.out.println(service.getPermissionOfRole(1));
	}

}


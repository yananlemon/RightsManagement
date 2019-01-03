package site.ilemon.rightsmanagement;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import site.ilemon.rightsmanagement.entity.PermissionInput;
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
	@Test
	public void testSave() throws Exception{
		PermissionInput input = new PermissionInput();
		List<String> codes = new ArrayList<String>();
		codes.add("01");
		codes.add("0101");
		codes.add("0102");
		input.setRoleId(1);
		input.setCodes(codes);
		service.savePerission(input);
	}

}


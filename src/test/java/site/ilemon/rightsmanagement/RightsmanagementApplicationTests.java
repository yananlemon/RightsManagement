package site.ilemon.rightsmanagement;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import site.ilemon.rightsmanagement.entity.User;
import site.ilemon.rightsmanagement.service.IUserService;
import site.ilemon.rightsmanagement.util.SearchCondition;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RightsmanagementApplicationTests {

	@Autowired
	private IUserService service;
	
	@Test
	public void contextLoads() {
		SearchCondition condition = new SearchCondition(1);
		condition.setCurrPage(1);
		condition.setStartRow(0);
		condition.setEndRow(10);
		condition.setSearchKeyword("an");
		System.out.println(service.listUser(condition));
	}
	@Test
	public void  testGetFreqOfCreateUser() {
		System.out.println(service.getFreqOfCreateUser());
	}
	
	@Test
	public void testInsertUser(){
		User user = new User();
		user.setUsername("yanan");
		user.setPassword("yanan");
		user.setAddress("河南省安阳县曲沟镇安车村");
		user.setEmail("yanan@yeah.net");
		user.setMobile("13564418187");
		assertTrue(service.insert(user) > 0);
	}

}


package springTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javaTest.MemberDAO;
import service.MemberService;
import service.MemberServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })

public class SpringTest {
	@Autowired
	MemberDAO dao ; //javaTest//MemberDAO

	@Autowired
	MemberService service ; 		//MemberService
	
	@Autowired
	MemberServiceImpl imp ; 		//MemberService

	@Test
	//test1)  Detail 정확하게 구현 했는지 Test
	public void detailTest() {
		//Service 자동주입 확인
		assertNotNull(imp); //green 생성 성공
	}

}














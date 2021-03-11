package springTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javaTest.MemberDAO;
import vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })


public class ex01_DAOTest_Spring{
	
	@Autowired
	MemberDAO dao ; //javaTest//MemberDAO
	@Autowired
	MemberVO vo ; 		//vo/MemberVO
	
	@Test
	//test1)  Detail 정확하게 구현 했는지 Test
	public void detailTest() {
		//DAO 자동주입 확인
		assertNotNull(dao); //green 생성 성공
		
		vo.setId("apple"); //green
		//vo.setId("apple1234"); //red 없는 아이디기 떄문.
	    assertNotNull(dao.selectOne(vo));	//NotNull : green, Null : red
	}
	
	
	//@Test
	//test2) Insert 구현 정확성 Test 
	public void insertTest() {
		vo.setId("unitTest");
		vo.setPassword("1234!");
		vo.setName("jisukim");
		vo.setLev("A");
		vo.setBirthd("1993-07-02");
		vo.setPoint(1000);
		vo.setWeight(44.33);
		vo.setRid("coffee");
		vo.setUploadfile("resources/uploadImage/basicman2.jpg");
		//입력 성공이면 1 return 실패이면 0
		 assertEquals(dao.insert(vo), 1);  //true : green , false : red   
	}
}


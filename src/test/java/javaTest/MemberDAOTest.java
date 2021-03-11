package javaTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import vo.MemberVO;

public class MemberDAOTest {

	MemberDAO dao = new MemberDAO();
	MemberVO vo = new MemberVO();
	
	@Test
	//test1)  Detail 정확하게 구현 했는지 Test
	public void detailTest() {
		vo.setId("apple123"); //green
		assertNotNull(dao.selectOne(vo));	//NotNull : green, Null : red
	}
}

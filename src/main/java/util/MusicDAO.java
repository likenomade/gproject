package util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MusicVO;

// ** Board CRUD 구현
@Repository
public class MusicDAO {
	
	@Autowired
	private SqlSession sqlSession; 
	
	private static final String NS ="com.ncs.MusicMapper.";
	
// ** selectList
	public List<MusicVO> selectList() {
		return sqlSession.selectList(NS+"selectList");
	} //selectList
	

} //class

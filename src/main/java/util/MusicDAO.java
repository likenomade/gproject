package util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import criteria.Criteria;
import vo.FaqVO;
import vo.MusicVO;
import vo.PageVO;

// ** Board CRUD 구현
@Repository
public class MusicDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NS = "com.ncs.MusicMapper.";

	// ** selectList
	public List<MusicVO> selectList() {
		return sqlSession.selectList(NS + "selectList");
	} // selectList

	// ** selctOne
	public MusicVO selectOne(MusicVO vo) {
		return sqlSession.selectOne(NS + "selectOne", vo);
	} // selctOne

	public void musicCount(MusicVO vo) {
		sqlSession.update(NS + "musicCount", vo);
	}
	
	/*-------------검색부분 추가--------------*/
	//SearchCriteria PageList
		public int searchRowCountM(Criteria cri) {
			return sqlSession.selectOne(NS+"searchRowCountM");
		}  
		public List<MusicVO> searchMList(Criteria cri) {
			return sqlSession.selectList(NS+"searchMList",cri);
		}
		public List<MusicVO> searchNList(Criteria cri) {
			System.out.println(cri.getKeyword());
			return sqlSession.selectList(NS+"searchNList",cri);
		}
		

		// ** Criteria PageList	
		public List<MusicVO> criMList(Criteria cri) {
			return sqlSession.selectList(NS+"pageMList",cri);
		}
		public List<MusicVO> criNList(Criteria cri) {
			return sqlSession.selectList(NS+"pageNList",cri);
		}
		
		/*---------------------------------------------------*/
		// ** Page BoardList
		public int totalRowCountM() {
			return sqlSession.selectOne(NS+"totalRowCountM");
		}  
		public List<MusicVO> pageMList(PageVO<MusicVO> vo) {
			return sqlSession.selectList(NS+"pageMList",vo);
		}

	
	


} // class

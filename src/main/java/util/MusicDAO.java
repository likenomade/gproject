package util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import criteria.Criteria;
import criteria.SearchCriteria;
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
	public int searchRowCountAll(SearchCriteria cri) {
		return sqlSession.selectOne(NS+"searchRowCountAll",cri);
	}  
	public int searchRowCountSname(SearchCriteria cri) {
		return sqlSession.selectOne(NS+"searchRowCountSname",cri); 
	}
	public int searchRowCountSingerName(SearchCriteria cri) {
		return sqlSession.selectOne(NS+"searchRowCountSingerName",cri); 
	}
	public int searchRowCountLyrics(SearchCriteria cri) {
		return sqlSession.selectOne(NS+"searchRowCountLyrics",cri); 
	}


	public List<MusicVO>searchAllList(SearchCriteria cri) {
		return sqlSession.selectList(NS+"searchAllList",cri);
	}
	public List<MusicVO> searchSnameList(SearchCriteria cri) {
		return sqlSession.selectList(NS+"searchSnameList",cri);
	}
	public List<MusicVO> searchSingerNameList(SearchCriteria cri) {
		return sqlSession.selectList(NS+"searchSingerNameList",cri);
	}
	public List<MusicVO> searchLyricsList(SearchCriteria cri) {
		return sqlSession.selectList(NS+"searchLyricsList",cri);
	}


	// ** Criteria PageList	
	public List<MusicVO> criAllList(Criteria cri) {
		return sqlSession.selectList(NS+"pageAllList",cri);
	}
	public List<MusicVO> criSnameList(Criteria cri) {
		return sqlSession.selectList(NS+"pageSnameList",cri);
	}
	public List<MusicVO> criSingerNameList(Criteria cri) {
		return sqlSession.selectList(NS+"pageSnameList",cri);
	}
	public List<MusicVO> criLyricsList(Criteria cri) {
		return sqlSession.selectList(NS+"pageSnameList",cri);
	}

	/*---------------------------------------------------*/
	// ** Page BoardList
	/*
	 * 
	 * public int totalRowCountAll() { return
	 * sqlSession.selectOne(NS+"totalRowCountAll"); } public int
	 * totalRowCountSname() { return sqlSession.selectOne(NS+"totalRowCountSname");
	 * } public int totalRowCountSingerName() { return
	 * sqlSession.selectOne(NS+"totalRowCountSingerName"); } public int
	 * totalRowCountLyrics() { return
	 * sqlSession.selectOne(NS+"totalRowCountLyrics"); }
	 * 
	 * public List<MusicVO> pageMList(PageVO<MusicVO> vo) { return
	 * sqlSession.selectList(NS+"pageMList",vo); }
	 */




} // class

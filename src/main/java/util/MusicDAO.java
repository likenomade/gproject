package util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import criteria.Criteria;
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
	public int searchRowCountSname(Criteria cri) {
		return sqlSession.selectOne(NS+"searchRowCountSname",cri); 
	}
	public int searchRowCountSingerName(Criteria cri) {
		return sqlSession.selectOne(NS+"searchRowCountSingerName",cri); 
	}
	public int searchRowCountLyrics(Criteria cri) {
		return sqlSession.selectOne(NS+"searchRowCountLyrics",cri); 
	}


	public List<MusicVO> searchSnameList(Criteria cri) {
		return sqlSession.selectList(NS+"searchSnameList",cri);
	}
	public List<MusicVO> searchSingerNameList(Criteria cri) {
		return sqlSession.selectList(NS+"searchSingerNameList",cri);
	}
	public List<MusicVO> searchLyricsList(Criteria cri) {
		return sqlSession.selectList(NS+"searchLyricsList",cri);
	}

	// ** Criteria PageList	
	public List<MusicVO> criSnameList(Criteria cri) {
		return sqlSession.selectList(NS+"criSnameList",cri);
	}
	public List<MusicVO> criSingerNameList(Criteria cri) {
		return sqlSession.selectList(NS+"criSingerNameList",cri);
	}
	public List<MusicVO> criLyricsList(Criteria cri) {
		return sqlSession.selectList(NS+"criLyricsList",cri);
	}

	// ** genreList
		public List<MusicVO> snameList(Criteria cri) {
			return sqlSession.selectList(NS + "snameList", cri);
		} // SnameList

		public int snameRowCount(MusicVO vo) {
			return sqlSession.selectOne(NS+ "snameRowCount",vo);
		}

} // class

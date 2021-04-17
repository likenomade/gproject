package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import criteria.Criteria;
import criteria.SearchCriteria;
import util.MusicDAO;
import vo.MusicVO;
import vo.PageVO;

@Service
public class MusicServiceimpl implements MusicService {

	@Autowired
	MusicDAO dao;

	public List<MusicVO> selectList() {
		return dao.selectList();
	} // selectList

	public MusicVO selectOne(MusicVO vo) {
		return dao.selectOne(vo);
	} // selectOne

	public void musicCount(MusicVO vo) {
		dao.musicCount(vo);
	}

	/*-------------------검색부분--------------------*/
	// ** SearchCriteria PageList
	public int searchRowCountAll(SearchCriteria cri) {
		return dao.searchRowCountAll(cri);
	}
	public int searchRowCountSname(SearchCriteria cri) {
		return dao.searchRowCountSname(cri);
	}
	public int searchRowCountSingerName(SearchCriteria cri) {
		return dao.searchRowCountSingerName(cri);
	}
	public int searchRowCountLyrics(SearchCriteria cri) {
		return dao.searchRowCountLyrics(cri);
	}
	

	public List<MusicVO> searchAllList(SearchCriteria cri) {
		return dao.searchAllList(cri);
	}
	public List<MusicVO> searchSnameList(SearchCriteria cri) {
		return dao.searchSnameList(cri);
	}
	public List<MusicVO> searchSingerNameList(SearchCriteria cri) {
		return dao.searchSingerNameList(cri);
	}
	public List<MusicVO> searchLyricsList(SearchCriteria cri) {
		return dao.searchLyricsList(cri);
	}

	// ** Criteria PageList
	/*
	 * public int totalRowCountAll() { return dao.totalRowCountAll(); } public int
	 * totalRowCountSname() { return dao.totalRowCountSname(); } public int
	 * totalRowCountSingerName() { return dao.totalRowCountSingerName(); } public
	 * int totalRowCountLyrics() { return dao.totalRowCountLyrics(); }
	 */
	
	
	public List<MusicVO> criAllList(Criteria cri) {
		return dao.criAllList(cri);
	}
	public List<MusicVO> criSnameList(Criteria cri) {
		return dao.criSnameList(cri);
	}
	public List<MusicVO> criSingerNameList(Criteria cri) {
		return dao.criSingerNameList(cri);
	}
	public List<MusicVO> criLyricsList(Criteria cri) {
		return dao.criLyricsList(cri);
	}



	// ** Page BoardList
	// => totalRowCount set, 출력할 board row set 
	/*
	 * public PageVO<MusicVO> pageMList(PageVO<MusicVO> vo) {
	 * vo.setTotalRowCount(dao.totalRowCountAll()); vo.setList(dao.pageMList(vo));
	 * return vo; }
	 */

}

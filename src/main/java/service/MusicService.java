package service;

import java.util.List;

import criteria.Criteria;
import criteria.SearchCriteria;
import vo.MusicVO;
import vo.PageVO;

public interface MusicService {

	public List<MusicVO> selectList();
	public MusicVO selectOne(MusicVO vo);
	public void musicCount(MusicVO vo);
	
	
	//검색 페이징 부분 추가
	// ** SearchCriteria PageList
	public int searchRowCountAll(SearchCriteria cri) ;
	public int searchRowCountSname(SearchCriteria cri) ;
	public int searchRowCountSingerName(SearchCriteria cri);
	public int searchRowCountLyrics(SearchCriteria cri);
	
	
	
	public List<MusicVO> searchAllList(SearchCriteria cri) ;
	public List<MusicVO> searchSnameList(SearchCriteria cri) ;
	public List<MusicVO> searchSingerNameList(SearchCriteria cri) ;
	public List<MusicVO> searchLyricsList(SearchCriteria cri) ;
	// ** Criteria PageList
	
	/*
	 * public int totalRowCountAll(); public int totalRowCountSname(); public int
	 * totalRowCountSingerName(); public int totalRowCountLyrics();
	 */
	
	public List<MusicVO> criAllList(Criteria cri) ;
	public List<MusicVO> criSnameList(Criteria cri) ;
	public List<MusicVO> criSingerNameList(Criteria cri) ;
	public List<MusicVO> criLyricsList(Criteria cri) ;
	// ** PageList
	//public PageVO<MusicVO> pageMList(PageVO<MusicVO> vo);
	

}// interface

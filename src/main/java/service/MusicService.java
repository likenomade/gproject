package service;

import java.util.List;

import criteria.Criteria;
import vo.MusicVO;
import vo.PageVO;

public interface MusicService {

	public List<MusicVO> selectList();
	public MusicVO selectOne(MusicVO vo);
	public void musicCount(MusicVO vo);
	
	
	//검색 페이징 부분 추가
	// ** SearchCriteria PageList
	public int searchRowCountSname(Criteria cri) ;
	public int searchRowCountSingerName(Criteria cri);
	public int searchRowCountLyrics(Criteria cri);
	
	
	// ** Criteria PageList
	public List<MusicVO> searchSnameList(Criteria cri) ;
	public List<MusicVO> searchSingerNameList(Criteria cri) ;
	public List<MusicVO> searchLyricsList(Criteria cri) ;

	
	public List<MusicVO> criSnameList(Criteria cri) ;
	public List<MusicVO> criSingerNameList(Criteria cri) ;
	public List<MusicVO> criLyricsList(Criteria cri) ;
	
	
	public List<MusicVO> snameList(Criteria cri);
	public int snameRowCount(MusicVO vo);
	

}// interface

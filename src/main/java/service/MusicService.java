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
	public int searchRowCountM(Criteria cri) ;
	public List<MusicVO> searchMList(Criteria cri) ;
	// ** Criteria PageList
	public int totalRowCount() ;
	public List<MusicVO> criMList(Criteria cri) ;
	// ** PageList
	public PageVO<MusicVO> pageMList(PageVO<MusicVO> vo);


}// interface

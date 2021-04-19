package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import criteria.Criteria;
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

	public int searchRowCountSname(Criteria cri) {
		return dao.searchRowCountSname(cri);
	}
	public int searchRowCountSingerName(Criteria cri) {
		return dao.searchRowCountSingerName(cri);
	}
	public int searchRowCountLyrics(Criteria cri) {
		return dao.searchRowCountLyrics(cri);
	}


	public List<MusicVO> searchSnameList(Criteria cri) {
		return dao.searchSnameList(cri);
	}
	public List<MusicVO> searchSingerNameList(Criteria cri) {
		return dao.searchSingerNameList(cri);
	}
	public List<MusicVO> searchLyricsList(Criteria cri) {
		return dao.searchLyricsList(cri);
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

	@Override
	public List<MusicVO> snameList(Criteria cri) {
		return dao.snameList(cri);
	}

	@Override
	public int snameRowCount(MusicVO vo) {
		return dao.snameRowCount(vo);
	}

}

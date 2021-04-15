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
		public int searchRowCountM(Criteria cri) {
			return dao.searchRowCountM(cri);
		}
			public List<MusicVO> searchMList(Criteria cri) {
				return dao.searchMList(cri);
			}
		
		// ** Criteria PageList
		public int totalRowCountM() {
			return dao.totalRowCountM();
		}
		public List<MusicVO> criMList(Criteria cri) {
			return dao.criMList(cri);
		}
		public List<MusicVO> searchNList(Criteria cri){
		return dao.searchNList(cri);
		}
		
		// ** Page BoardList
		// => totalRowCount set, 출력할 board row set 
		public PageVO<MusicVO> pageMList(PageVO<MusicVO> vo) {
			vo.setTotalRowCount(dao.totalRowCountM());
			vo.setList(dao.pageMList(vo));
			return vo; 
		}

}

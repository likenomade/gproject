package com.ncs.green;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import criteria.Criteria;
import criteria.PageMaker;
import service.ChartService;
import service.MusicService;
import vo.ChartVO;
import vo.MusicVO;

@Controller
public class GmusicController {

	@Autowired
	MusicService service;

	@Autowired
	ChartService chartService;

	@RequestMapping(value = "/musicCount")
	public void musicCount(HttpServletRequest request, ModelAndView mv, MusicVO vo, ChartVO cvo) {

		vo = service.selectOne(vo); // vo값 불러오기
		vo.setCount(vo.getCount() + 1); // count + 1
		service.musicCount(vo);

		// 일간 count +
		cvo = chartService.dailyOne(cvo); // vo값 불러오기
		cvo.setCount(cvo.getCount() + 1);
		chartService.dailyMusicCount(cvo);

		cvo = chartService.weeklyOne(cvo); // vo값 불러오기
		cvo.setCount(cvo.getCount() + 1);
		chartService.weeklyMusicCount(cvo);

		cvo = chartService.monthlyOne(cvo); // vo값 불러오기
		cvo.setCount(cvo.getCount() + 1);
		chartService.monthlyMusicCount(cvo);
	}

	// ** 최신음악
	@RequestMapping(value = "/musiclist")
	public ModelAndView musiclist(HttpServletRequest request, ModelAndView mv, Criteria cri, PageMaker pageMaker) {
		if ("section1_2".equals(request.getParameter("pagingCode"))) {
			cri.setRowPerPage(4);
		} else {
			cri.setRowPerPage(20);
		}
		cri.setSnoEno();

		List<MusicVO> list = service.releasedateList(cri);
		if (list != null) {
			mv.addObject("Banana", list);
		}
		pageMaker.setCri(cri); // 계산된 cri를 페이지 메이커의 필드변수에 담아줌
		pageMaker.setTotalRow(service.releasedateRowCount()); // 장르 곡목록의 수

		mv.addObject("pageMaker", pageMaker);
		if ("section1_2".equals(request.getParameter("pagingCode"))) {
			mv.setViewName("musicview/ajaxMusicList");
		} else {
			mv.setViewName("musicview/musiclist");
		}

		return mv;
	}// musiclist

	// ** 장르음악
	@RequestMapping(value = "/genrelist")
	public ModelAndView genrelist(HttpServletRequest request, ModelAndView mv, Criteria cri, PageMaker pageMaker,
			MusicVO vo) {
		System.out.println("***********Test " + vo.getGenre()); // vo엔 자동으로 장르만 들어와있음.

		if ("section1_1".equals(request.getParameter("pagingCode"))) {
			cri.setRowPerPage(4);
		} else {
			cri.setRowPerPage(10); // 한 페이지당 20곡씩 출력
		}
		cri.setSnoEno();
		cri.setGenre(vo.getGenre());

		List<MusicVO> list = service.genreList(cri); // 장르에 해당하는 곡목록이 들어옴
		if (list != null) {
			mv.addObject("Banana", list);
		}
		pageMaker.setCri(cri); // 계산된 cri를 페이지 메이커의 필드변수에 담아줌
		pageMaker.setTotalRow(service.genreRowCount(vo)); // 장르 곡목록의 수

		mv.addObject("pageMaker", pageMaker);
		mv.addObject("musicGenre", vo.getGenre());
		if ("section1_1".equals(request.getParameter("pagingCode"))) {
			mv.setViewName("musicview/ajaxGenreList");
		} else {
			mv.setViewName("musicview/genrelist");
		}
		return mv;
	}// genrelist

	// playlist
	@RequestMapping(value = "/playlist")
	public ModelAndView playlist(HttpServletRequest request, ModelAndView mv) {
		// 파라미터로 값을 받음
		String snumVal = request.getParameter("snumVal");
		request.getSession().setAttribute("snumValSession", snumVal);

		MusicVO vo = new MusicVO();

		// 스트링 배열 "," 기준으로 쪼개 담음
		String splitsnumVal[] = snumVal.split(",");

		// sql snum 형식이 int 이기 때문에 int 배열에 다시 담음
		int intsnumVal[] = new int[splitsnumVal.length];

		for (int i = 0; i < splitsnumVal.length; i++) {
			intsnumVal[i] = Integer.parseInt(splitsnumVal[i]);
		}

		List<MusicVO> list = new ArrayList<MusicVO>();
		for (int i = 0; i < intsnumVal.length; i++) {
			vo.setSnum(intsnumVal[i]);
			list.add(service.selectOne(vo));

		}
		if (list != null) {
			if ("U".equals(request.getParameter("jcode"))) {
				// 셔플 함수 참고
				// https://zetawiki.com/wiki/%ED%95%A8%EC%88%98_shuffle()
				Collections.shuffle(list);
			}
			mv.addObject("Banana", list);
			mv.setViewName("musicview/playlist");
		}

		return mv;
	} // playlist

	// ** 가사 보기
	@RequestMapping(value = "/lyricsview")
	public ModelAndView lyricsview(HttpServletRequest request, ModelAndView mv, MusicVO vo) {

		vo = service.selectOne(vo);
		if (vo != null) {
			mv.addObject("Apple", vo);
		} else {
			mv.addObject("message", "~~ 해당 곡이 존재하지 않습니다 ~~");
		}
		mv.setViewName("musicview/lyrics");

		return mv;

	} // lyricsview

	// ** Image DownLoad
	@RequestMapping(value = "/dnload")
	public ModelAndView dnload(ModelAndView mv, @RequestParam("dnfile") String dnfile) {
		dnfile = "C:/NamCheolWoo/gproject/src/main/webapp/" + dnfile;
		System.out.println("** dnfile => " + dnfile);
		File file = new File(dnfile);

		mv.addObject("downloadFile", file);
		mv.setViewName("download");

		// 일반적인 경우 views/download.jsp 를 찾음, 그러나 이 경우에는 아님

		// viewresolver bean 체크하기 기본적으로 viewresolver
		// => servlet-context.xzml 에 설정하는 view 클래스 (DownloadView.java) 의
		// id 와 동일 해야함.
		return mv;

		/*
		 * 위 50~51 행은 아래처럼 작성할 수도 있다. return new ModelAndView("download",
		 * "downloadFile", file);
		 * 
		 * => 생성자 참고 public ModelAndView(View view, String modelName, Object
		 * modelObject) { this.view = view; addObject(modelName, modelObject); }
		 */
	} // dnload

	/*--------------------------------------------------검색--------------------------------------------*/
	@RequestMapping(value = "/mSearch") // 통합검색
	public ModelAndView mSearch(ModelAndView mv, Criteria cri, PageMaker pageMaker) {

		/*
		 * System.out.println(cri.getKeyword()); System.out.println("첫번쨰");
		 */
		cri.setRowPerPage(10);
		cri.setSnoEno();

		mv.addObject("UserKeyword", cri.getKeyword());
		cri.setKeyword(cri.getKeyword().replace(" ", ""));

		mv.addObject("Banana", service.searchSnameList(cri));
		mv.addObject("Carot", service.searchSingerNameList(cri));
		mv.addObject("Durian", service.searchLyricsList(cri));

		pageMaker.setCri(cri);

		mv.addObject("Banana2", service.searchRowCountSname(cri));
		mv.addObject("Carot2", service.searchRowCountSingerName(cri));
		mv.addObject("Durian2", service.searchRowCountLyrics(cri));

		mv.addObject("pageMaker", pageMaker);

		mv.setViewName("musicview/musicSearch");
		return mv;
	} // mSearch

	@RequestMapping(value = "/searchSname") // 곡 검색
	public ModelAndView searchSname(ModelAndView mv, Criteria cri, PageMaker pageMaker) {

		cri.setSnoEno();
		
		mv.addObject("UserKeyword", cri.getKeyword());
		cri.setKeyword(cri.getKeyword().replace(" ", ""));
		mv.addObject("Banana", service.searchSnameList(cri));

		pageMaker.setCri(cri);
		pageMaker.setTotalRow(service.searchRowCountSname(cri));

		mv.addObject("pageMaker", pageMaker);
		mv.setViewName("musicview/SearchSname");

		return mv;
	} // searchSname

	@RequestMapping(value = "/searchSingerName") // 가수 검색
	public ModelAndView searchSingerName(ModelAndView mv, Criteria cri, PageMaker pageMaker) {

		cri.setSnoEno();

		mv.addObject("UserKeyword", cri.getKeyword());
		cri.setKeyword(cri.getKeyword().replace(" ", ""));
		mv.addObject("Carot", service.searchSingerNameList(cri));

		pageMaker.setCri(cri);
		pageMaker.setTotalRow(service.searchRowCountSingerName(cri));
		mv.addObject("pageMaker", pageMaker);

		mv.setViewName("musicview/SearchSingerName");

		return mv;
	} // searchSingerName

	@RequestMapping(value = "/searchLyrics") // 가사 검색
	public ModelAndView searchLyrics(ModelAndView mv, Criteria cri, PageMaker pageMaker) {

		cri.setSnoEno();
		
		mv.addObject("UserKeyword", cri.getKeyword());
		cri.setKeyword(cri.getKeyword().replace(" ", ""));
		mv.addObject("Durian", service.searchLyricsList(cri));

		pageMaker.setCri(cri);
		pageMaker.setTotalRow(service.searchRowCountLyrics(cri));
		mv.addObject("pageMaker", pageMaker);

		mv.setViewName("musicview/SearchLyrics");

		return mv;
	} // searchLyrics
	/*------------------------------------------------------------------------------------------*/

}

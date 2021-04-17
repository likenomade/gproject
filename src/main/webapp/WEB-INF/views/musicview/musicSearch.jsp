<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색음악</title>
<script src="resources/myLib/jquery-3.2.1.min.js"></script>
<style>
#musicSearch{
margin: 64px 449px -8px;
}

#noResult{
text-align: left;
}

</style>
<script>
   $(function() { //ready

      // input checkbox
      // https://emessell.tistory.com/149 참고
      //1. 전체 선택, 전체 해제
      $("#check_all_1").click(function() {

         var checked = $(this).is(":checked");

         if (checked) {
            $(".normalCheck_1").prop('checked', true);
         } else {
            $(".normalCheck_1").prop('checked', false);
         }
      });
   
      $("#check_all_2").click(function() {

          var checked = $(this).is(":checked");

          if (checked) {
             $(".normalCheck_2").prop('checked', true);
          } else {
             $(".normalCheck_2").prop('checked', false);
          }
       });
      
      $("#check_all_3").click(function() {

          var checked = $(this).is(":checked");

          if (checked) {
             $(".normalCheck_3").prop('checked', true);
          } else {
             $(".normalCheck_3").prop('checked', false);
          }
       });
      
      $("#check_all_4").click(function() {

          var checked = $(this).is(":checked");

          if (checked) {
             $(".normalCheck_4").prop('checked', true);
          } else {
             $(".normalCheck_4").prop('checked', false);
          }
       });
/* -------------------------------------------전체선택 end---------------------------------------------------------- */
      // 2. 전체선택 후 하나만 해제했을 때, 전체선택도 해체
      // 3. 개별 선택으로 전체 다 선택되었을 때, 전체선택에도 체크
      $(".normalCheck_1").click(function() {
         var checked = $(this).is(":checked");
         if (!checked) {
            $("#check_all_1").prop('checked', false);
         } else {
            var is_checked = true;
            $(".normalCheck_1").each(function() {
               is_checked = is_checked && $(this).is(":checked");
            });
            $("#check_all_1").prop("checked", is_checked);
         }
      });//1
      
      $(".normalCheck_2").click(function() {
          var checked = $(this).is(":checked");
          if (!checked) {
             $("#check_all_2").prop('checked', false);
          } else {
             var is_checked = true;
             $(".normalCheck_2").each(function() {
                is_checked = is_checked && $(this).is(":checked");
             });
             $("#check_all_2").prop("checked", is_checked);
          }
       });//2
      
      $(".normalCheck_3").click(function() {
          var checked = $(this).is(":checked");
          if (!checked) {
             $("#check_all_3").prop('checked', false);
          } else {
             var is_checked = true;
             $(".normalCheck_3").each(function() {
                is_checked = is_checked && $(this).is(":checked");
             });
             $("#check_all_3").prop("checked", is_checked);
          }
       });//3
      
      $(".normalCheck_4").click(function() {
          var checked = $(this).is(":checked");
          if (!checked) {
             $("#check_all_4").prop('checked', false);
          } else {
             var is_checked = true;
             $(".normalCheck_4").each(function() {
                is_checked = is_checked && $(this).is(":checked");
             });
             $("#check_all_4").prop("checked", is_checked);
          }
       });
      
     /* -----------------------------------단일선택 end------------------------------------- */
      // 곡명 버튼 눌렀을때 실행 
      // 플레이 리스트에 단일로 실행됨
      $("button[name=sname]").click(function() {
         var buttonSnumVal = $(this).val();
         url = "playlist";
         window.open(url, "myview",
                     "toolbar=no,menubar=yes,scrollbars=no,resizable=no,width=700,height=800");
       
         document.musicSearch.action =url;
         document.musicSearch.method="post";
         document.musicSearch.target="myview";
         
         $('input[name=snumVal]').attr('value',buttonSnumVal);
      
         document.musicSearch.submit();
      });
   });//ready *
   
   
   // window.open post 방식으로 전달하기
   // https://darkhorizon.tistory.com/284 참고
   // 체크박스(checkbox)에 선택 된 값 출력하기
   // https://hianna.tistory.com/430 참고
   function getCheckboxValue()  {
      // 선택된 목록 가져오기
      const query = 'input[name="snum"]:checked'; //snum_1  ,snumVal_1 로 바꾸고 해도 안되네;;
      const selectedEls = document.querySelectorAll(query);
   
      // 선택된 목록에서 value 찾기
      let result = '';
      selectedEls.forEach((el) => {
      result += el.value + ',';
      });
      
      // div에 출력 하기
      document.getElementById('result').innerText
      = result;
      
      url = "playlist";
      window.open(url, "myview",
                  "toolbar=no,menubar=yes,scrollbars=no,resizable=no,width=700,height=800");
    
      document.musicSearch.action =url;
      document.musicSearch.method="post";
      document.musicSearch.target="myview";
      
      // 항목 추가 실험중 넣으면 항목 추가됨
      //var addsnumVal = $('input[name=snumVal]').val();
      //if (addsnumVal != null) {
      //   $('input[name=snumVal]').attr('value',addsnumVal+result);
      //}else{
         $('input[name=snumVal]').attr('value',result);
      //}
      document.musicSearch.submit();
   }
</script>


</head>
<body>
	<!-- 통합검색 -->
	 <form id="musicSearch" name="musicSearch" align="center" >
 <%--  <h1>통합검색결과</h1>
      <button type="button" onclick="getCheckboxValue()">플레이리스트</button>
      <div id='result'></div>
      <input type="hidden" id="snumVal" name="snumVal" value="">
      <table style="width: 1200px;" border="1" >
         <tr align="center" height="2" bgcolor="#0b3f9a" >
            <td width="50">
               <input type="checkbox" id="check_all_1" name="check_all_1">
            </td>
            <td width="40">번 호</td>
            <td>Image</td>
            <td>곡 명</td>
            <td>가 수</td>
            <td>앨범명</td>
            <td>downloadfile</td>
         </tr>
         <c:forEach var="row" items="${Apple}" varStatus="vs">
            <tr>
               <td align="center">
                  <input type="checkbox" class="normalCheck_1" id="snum${row.snum}" name="snum" value="${row.snum}">
               </td>
               <td align="center">${vs.count}</td>
               <td>
                  <img src="${row.image}" width="70" height="70">
               </td>
               <td>
                  <button type="button" name="sname" value="${row.snum}">${row.sname}</button>
               </td>
               <td>${row.singername}</td>
               <td>${row.stitle}</td>
               <td>
                  <a href="dnload?dnfile=${row.downloadfile}">${row.downloadfile}</a>
               </td>
            </tr>
            </c:forEach>
      </table>
             <c:if test="${empty Apple}"> 
				<h2>통합 검색한 결과가 없습니다.</h2>
      	   </c:if> 
   
   	<!-- ------------------페이징---------------------------->
	<!--** Page Criteria 추가   
    1) First << ,  Prev < : enabled 여부
    2) sPage~ePage 까지 displayPageNo 값 만큼 출력, 
    3) Next >  ,   Last >> : enabled 여부
	-->
<div  align="center"style="font-size: 20px; ">
	<!-- ** ver01 : pageMaker.makeQuery(?) -->
	<!-- ** ver02 : pageMaker.searchQuery(?)  -->
	<!-- 1) First << ,  Prev < : enabled 여부 -->
	<c:if test="${pageMaker.prev && pageMaker.sPageNo>1 }">
		<a href="mSearch${pageMaker.searchQuery(1)}">First</a>&nbsp;  
		<!-- "bpage?currPage=1" -->
		<a href="mSearch${pageMaker.searchQuery(pageMaker.sPageNo-1)}">Prev</a>&nbsp;&nbsp;
	</c:if>
	<!-- 2) sPage~ePage 까지 displayPageNo 값 만큼 출력, -->
	<c:forEach var="i" begin="${pageMaker.sPageNo}" end="${pageMaker.ePageNo}">
		<c:if test="${i==pageMaker.cri.currPage}">
			<font size="5" color="Orange">${i}&nbsp;</font>
		</c:if>
		<c:if test="${i!=pageMaker.cri.currPage}">
			<a href="mSearch${pageMaker.searchQuery(i)}">${i}</a>&nbsp;
		</c:if>
		<!-- 삼항식과 비교  
		<c:out value="${i==pageMaker.cri.currPage ? 'class=active' : '' }"/>
		-->
	</c:forEach>
		
	<!-- 3) Next >  ,   Last >> : enabled 여부	 -->
	<c:if test="${pageMaker.next && pageMaker.ePageNo>0}">
		<a href="mSearch${pageMaker.searchQuery(pageMaker.ePageNo+1)}">&nbsp;&nbsp;Next</a>&nbsp;  
		<a href="mSearch${pageMaker.searchQuery(pageMaker.lastPageNo)}">Last</a>&nbsp;&nbsp;
	</c:if>
	</div> --%>
	<!-- -----------------------------------------------통합검색 end---------------------------------------------------------- -->

<!-- 곡검색 -->
  <h1>곡 검색</h1>
      <button type="button" onclick="getCheckboxValue()">플레이리스트</button>
      <div id='result'></div>
      <input type="hidden" id="snumVal" name="snumVal" value="">
      <table style="width: 1200px;" border="1" >
         <tr align="center" height="2" bgcolor="#0b3f9a" >
            <td width="50">
               <input type="checkbox" id="check_all_2" name="check_all_2">
            </td>
            <td width="40">번 호</td>
            <td>Image</td>
            <td>곡 명</td>
            <td>가 수</td>
            <td>앨범명</td>
            <td>downloadfile</td>
         </tr>
         <c:forEach var="row" items="${Banana}" varStatus="vs">
            <tr>
               <td align="center">
                  <input type="checkbox" class="normalCheck_2" id="snum${row.snum}" name="snum" value="${row.snum}">
               </td>
               <td align="center">${vs.count}</td>
               <td>
                  <img src="${row.image}" width="70" height="70">
               </td>
               <td>
                  <button type="button" name="sname" value="${row.snum}">${row.sname}</button>
               </td>
               <td>${row.singername}</td>
               <td>${row.stitle}</td>
               <td>
                  <a href="dnload?dnfile=${row.downloadfile}">${row.downloadfile}</a>
               </td>
            </tr>
         </c:forEach>
      </table>
         <c:if test="${empty Banana}"> 
				<h2>곡 검색한 결과가 없습니다.</h2>
      	   </c:if> 
   
   	<!-- ------------------페이징---------------------------->
	<!--** Page Criteria 추가   
    1) First << ,  Prev < : enabled 여부
    2) sPage~ePage 까지 displayPageNo 값 만큼 출력, 
    3) Next >  ,   Last >> : enabled 여부
	-->
<div  align="center"style="font-size: 20px; ">
	<!-- ** ver01 : pageMaker.makeQuery(?) -->
	<!-- ** ver02 : pageMaker.searchQuery(?)  -->
	<!-- 1) First << ,  Prev < : enabled 여부 -->
	
	<c:if test="${pageMaker2.prev && pageMaker2.sPageNo>1 }">
		<a href="mSearch${pageMaker2.searchQuery(1)}">First</a>&nbsp;  
		<!-- "bpage?currPage=1" -->
		<a href="mSearch${pageMaker2.searchQuery(pageMaker2.sPageNo-1)}">Prev</a>&nbsp;&nbsp;
	</c:if>
	
	<!-- 2) sPage~ePage 까지 displayPageNo 값 만큼 출력, -->
	<c:forEach var="i" begin="${pageMaker2.sPageNo}" end="${pageMaker2.ePageNo}">
		<c:if test="${i==pageMaker2.cri.currPage}">
			<font size="5" color="Orange">${i}&nbsp;</font>
		</c:if>
		<c:if test="${i!=pageMaker2.cri.currPage}">
			<a href="mSearch${pageMaker2.searchQuery(i)}">${i}</a>&nbsp;
		</c:if>
		<!-- 삼항식과 비교  
		<c:out value="${i==pageMaker.cri.currPage ? 'class=active' : '' }"/>
		-->
	</c:forEach>
		
	<!-- 3) Next >  ,   Last >> : enabled 여부	 -->
	<c:if test="${pageMaker2.next && pageMaker2.ePageNo>0}">
		<a href="mSearch${pageMaker2.searchQuery(pageMaker2.ePageNo+1)}">&nbsp;&nbsp;Next</a>&nbsp;  
		<a href="mSearch${pageMaker2.searchQuery(pageMaker2.lastPageNo)}">Last</a>&nbsp;&nbsp;
	</c:if>
	</div>
	<!-- -----------------------------------------곡 검색 end--------------------------------------------------->
	<!-- 아티스트명 검색 -->
  <h1>아티스트명으로 검색</h1>
      <button type="button" onclick="getCheckboxValue()">플레이리스트</button>
      <div id='result'></div>
      <input type="hidden" id="snumVal" name="snumVal" value="">
      <table style="width: 1200px;" border="1" >
         <tr align="center" height="2" bgcolor="#0b3f9a" >
            <td width="50">
               <input type="checkbox" id="check_all_3" name="check_all_3">
            </td>
            <td width="40">번 호</td>
            <td>Image</td>
            <td>곡 명</td>
            <td>가 수</td>
            <td>앨범명</td>
            <td>downloadfile</td>
         </tr>
         <c:forEach var="row" items="${Carot}" varStatus="vs">
            <tr>
               <td align="center">
                  <input type="checkbox" class="normalCheck_3" id="snum${row.snum}" name="snum" value="${row.snum}">
               </td>
               <td align="center">${vs.count}</td>
               <td>
                  <img src="${row.image}" width="70" height="70">
               </td>
               <td>
                  <button type="button" name="sname" value="${row.snum}">${row.sname}</button>
               </td>
               <td>${row.singername}</td>
               <td>${row.stitle}</td>
               <td>
                  <a href="dnload?dnfile=${row.downloadfile}">${row.downloadfile}</a>
               </td>
            </tr>
         </c:forEach>
      </table>
      <c:if test="${empty Carot}"> 
				<h2>아티스트로 검색한 결과가 없습니다.</h2>
      </c:if> 
   
   	<!-- ------------------페이징---------------------------->
	<!--** Page Criteria 추가   
    1) First << ,  Prev < : enabled 여부
    2) sPage~ePage 까지 displayPageNo 값 만큼 출력, 
    3) Next >  ,   Last >> : enabled 여부
	-->
<div  align="center"style="font-size: 20px; ">
	<!-- ** ver01 : pageMaker.makeQuery(?) -->
	<!-- ** ver02 : pageMaker.searchQuery(?)  -->
	<!-- 1) First << ,  Prev < : enabled 여부 -->
	<c:if test="${pageMaker.prev && pageMaker.sPageNo>1 }">
		<a href="mSearch${pageMaker.searchQuery(1)}">First</a>&nbsp;  
		<!-- "bpage?currPage=1" -->
		<a href="mSearch${pageMaker.searchQuery(pageMaker.sPageNo-1)}">Prev</a>&nbsp;&nbsp;
	</c:if>
	
	<!-- 2) sPage~ePage 까지 displayPageNo 값 만큼 출력, -->
	<c:forEach var="i" begin="${pageMaker.sPageNo}" end="${pageMaker.ePageNo}">
		<c:if test="${i==pageMaker.cri.currPage}">
			<font size="5" color="Orange">${i}&nbsp;</font>
		</c:if>
		<c:if test="${i!=pageMaker.cri.currPage}">
			<a href="mSearch${pageMaker.searchQuery(i)}">${i}</a>&nbsp;
		</c:if>
		<!-- 삼항식과 비교  
		<c:out value="${i==pageMaker.cri.currPage ? 'class=active' : '' }"/>
		-->
	</c:forEach>
		
	<!-- 3) Next >  ,   Last >> : enabled 여부	 -->
	<c:if test="${pageMaker.next && pageMaker.ePageNo>0}">
		<a href="mSearch${pageMaker.searchQuery(pageMaker.ePageNo+1)}">&nbsp;&nbsp;Next</a>&nbsp;  
		<a href="mSearch${pageMaker.searchQuery(pageMaker.lastPageNo)}">Last</a>&nbsp;&nbsp;
	</c:if>
	</div>
	<!--------------------------------------------------아티스트 검색 end----------------------------------------------------- -->
	<!-- 가사검색 -->
  <h1>가사 검색</h1>
      <button type="button" onclick="getCheckboxValue()">플레이리스트</button>
      <div id='result'></div>
      <input type="hidden" id="snumVal" name="snumVal" value="">
      <table style="width: 1200px;" border="1" >
         <tr align="center" height="2" bgcolor="#0b3f9a" >
            <td width="50">
               <input type="checkbox" id="check_all_4" name="check_all_4">
            </td>
            <td width="40">번 호</td>
            <td>Image</td>
            <td>곡 명</td>
            <td>가 수</td>
            <td>앨범명</td>
            <td>downloadfile</td>
         </tr>
         <c:forEach var="row" items="${Durian}" varStatus="vs">
            <tr>
               <td align="center">
                  <input type="checkbox" class="normalCheck_4" id="snum${row.snum}" name="snum" value="${row.snum}">
               </td>
               <td align="center">${vs.count}</td>
               <td>
                  <img src="${row.image}" width="70" height="70">
               </td>
               <td>
                  <button type="button" name="sname" value="${row.snum}">${row.sname}</button>
               </td>
               <td>${row.singername}</td>
               <td>${row.stitle}</td>
               <td>
                  <a href="dnload?dnfile=${row.downloadfile}">${row.downloadfile}</a>
               </td>
            </tr>
         </c:forEach>
      </table>
       <c:if test="${empty Durian}" > 
				<h2>가사로 검색한 결과가 없습니다.</h2>
      </c:if> 
   	<!-- ------------------페이징---------------------------->
	<!--** Page Criteria 추가   
    1) First << ,  Prev < : enabled 여부
    2) sPage~ePage 까지 displayPageNo 값 만큼 출력, 
    3) Next >  ,   Last >> : enabled 여부
	-->
<div  align="center"style="font-size: 20px; ">
	<!-- ** ver01 : pageMaker.makeQuery(?) -->
	<!-- ** ver02 : pageMaker.searchQuery(?)  -->
	<!-- 1) First << ,  Prev < : enabled 여부 -->
	<c:if test="${pageMaker4.prev && pageMaker4.sPageNo>1 }">
		<a href="mSearch${pageMaker4.searchQuery(1)}">First</a>&nbsp;  
		<!-- "bpage?currPage=1" -->
		<a href="mSearch${pageMaker4.searchQuery(pageMaker4.sPageNo-1)}">Prev</a>&nbsp;&nbsp;
	</c:if>
	
	<!-- 2) sPage~ePage 까지 displayPageNo 값 만큼 출력, -->
	<c:forEach var="i" begin="${pageMaker4.sPageNo}" end="${pageMaker4.ePageNo}">
		<c:if test="${i==pageMaker4.cri.currPage}">
			<font size="5" color="Orange">${i}&nbsp;</font>
		</c:if>
		<c:if test="${i!=pageMaker4.cri.currPage}">
			<a href="mSearch${pageMaker4.searchQuery(i)}">${i}</a>&nbsp;
		</c:if>
		<!-- 삼항식과 비교  
		<c:out value="${i==pageMaker.cri.currPage ? 'class=active' : '' }"/>
		-->
	</c:forEach>
		
	<!-- 3) Next >  ,   Last >> : enabled 여부	 -->
	<c:if test="${pageMaker4.next && pageMaker4.ePageNo>0}">
		<a href="mSearch${pageMaker4.searchQuery(pageMaker4.ePageNo+1)}">&nbsp;&nbsp;Next</a>&nbsp;  
		<a href="mSearch${pageMaker4.searchQuery(pageMaker4.lastPageNo)}">Last</a>&nbsp;&nbsp;
	</c:if>
	</div>
	</form>
  <!--  -----------------------------------------------가사 검색 end--------------------------------------------------- -->
</body>
</html>
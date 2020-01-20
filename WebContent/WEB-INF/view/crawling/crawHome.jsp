<%@page import="exam.crawling.dto.StockDto"%>
<%@page import="java.util.List"%>
<%@page import="exam.common.util.CommonUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String kindType = CommonUtils.getString(request.getParameter("kindType"));
	List<StockDto> stockList = (List<StockDto>)request.getAttribute("stockList");
	
	int stockListCnt = (stockList ==null) ? 0 : stockList.size();
%>
<html>
<head>
<meta charset="UTF-8">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var kindType = "<%=kindType%>";
			if(kindType != ""){
				if(kindType == "A"){			//전체 검색
					$("#kindType1").attr('checked','checked');
				}else if(kindType == "P"){	//코스피
					$("#kindType2").attr('checked','checked');
				}else if(kindType =="D"){	//코스닥
					$("#kindType3").attr('checked','checked');
				}
				
			}else{			//초기 진입?
				$("#kindType1").attr('checked','checked');
			}
			
		});
		
		function fnSearch(){
			var frm = document.frm01;
			var kindType = $(":input[name=kindType]:checked").val(); 
			
			
			frm.action = "/home.do";
			frm.method = "POST";
			frm.submit();
		}
	</script>
<title>Insert title here</title>
</head>
<body>
	<form name="frm01">
	<div>
		<table>
			<tr>
				<th>구분</th>
				<td>
					<input type="radio" name="kindType" id="kindType1" value="A" onclick="" > 전체 
					<input type="radio" name="kindType" id="kindType2" value="P" onclick="" > 코스피
					<input type="radio" name="kindType" id="kindType3" value="D" onclick="" > 코스닥
				</td>
			</tr>
			<tr>
				<th>회사 명</th>
				<td>
					<input type="text" name="compName" id="compName">
				</td>
				<td>
					종목 코드
				</td>
				<td>
					<input type="text" name="tickerCode" id="tickerCode">
				</td>
			</tr>
		</table>
	</div>
	
	<div>
		<span><button id="searchBtn" name="searchBtn" onClick="fnSearch()">검색</button></span>
	</div>
	
	<%
	if(stockListCnt != 0){
	%>
	<div>
		<table>
			<thead>
				<tr>
					<th>종목 코드</th>
					<th>기업명</th>
				</tr>
			</thead>
			<tbody>
				<%for(int i=0; i<stockList.size(); i++){ %>
				<tr>
					<td><%=stockList.get(i).getTicker_code() %></td>
					<td><%=stockList.get(i).getComp_name() %></td>
				</tr>
				<%}%>
			</tbody>
			
		</table>
	</div>
	
	<%
	}
	%>
	</form>
</body>
</html>
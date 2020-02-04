<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2 class="text-center">공지 쓰기</h2>
		<div class="row">
			<form method="post" action="noticeboard_insert_ok.do">
				<table class="table">
					<tr>
						<th class="text-right info" width="20%">관리자명</th>
						<td width="80%" class="text-left">
							<input type="text" name="id" size="15" class="input-sm" value="${id }" readonly="readonly" id="id">
						</td>
					</tr>
					<tr>
					<th class="text-right info" width="20%">제목</th>
						<td width="80%" class="text-left">
							<input type="text" name="subject" size="60" class="input-sm" id="sub">
						</td>
					</tr>
					<tr>
					<th class="text-right info" width="20%">내용</th>
						<td width="80%">
							<textarea rows="20" cols="105" name="content" id="cont"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="button" value="공지 등록" class="btn btn-sm btn-info">
							<input type="button" value="취소" class="btn btn-sm btn-danger"
								onclick="javascript:history.back()"
							>
						</td>
					</tr>
				</table>
			</form>
		</div>	
	</div>
</body>
</html>
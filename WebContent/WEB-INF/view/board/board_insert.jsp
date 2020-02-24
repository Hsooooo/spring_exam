<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
function showEmojiCode() {
	for(int i=1; i<4; i++){
		var eCode = document.getElementById('emojiBtn'+i).value;	
	}
	alert(eCode);
	
	var hex = eCode.codePointAt(0).toString(16); // 문자
	var emo = String.fromCodePoint("0x"+hex);    // 이모지
	
	document.getElementById('cont').value= document.getElementById('cont').value + "&#x"+hex+";";

}
</script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">작성 중 .. </h2>
		<div class="row">
			<form method="post" action="/board_insert_ok.do" >
				<table class="table">
					<tr>
						<th class="text-right info" width="20%">글쓴이</th>
						<td width="80%" class="text-left">
							<input type="text" size="25" class="input-sm" value="${email }" placeholder=" ${email }" readonly="readonly" id="email" name="email">
							</input>
						</td>
					</tr>
					<tr>
					<th class="text-right info" width="20%">제목</th>
						<td width="80%" class="text-left">
							<input type="text" name="subject" size="60" class="input-sm" id="sub" name="subject">
							<input type="button" value="Show_Emoji" class="btn btn-sm btn-primary" id="show" onclick="showEmojiCode();">
						</td>
					</tr>
					<th class="text-right info" width="20%"></th>
						<td width="80%" class="text-left">
							<table>
								<div id="box">
									<input type="button" value="&#x1F601;" id="emojiBtn1" onclick="showEmojiCode();">
									<input type="button" value="&#x1F602;" id="emojiBtn2" onclick="showEmojiCode();">
									<input type="button" value="&#x1F603;" id="emojiBtn3" onclick="showEmojiCode();">
								</div>								
							</table>
						</td>
					</tr>
					<tr>
					<th class="text-right info" width="20%">내용</th>
						<td width="80%">
							<textarea rows="20" cols="105" name="content" id="cont" ></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="submit" value="등록" class="btn btn-sm btn-info" id="insertBtn">
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
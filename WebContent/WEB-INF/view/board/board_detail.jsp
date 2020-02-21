<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#delBtn').click(function(){
		var board_no = $('#no').val();
		alert(board_no);
		
		$.ajax({
			type:'post',
			url:'/boardDelete.do',
			data:{board_no:board_no},
			success:function(res){
				location.href='/main.do';
			}
		})
	});
});
</script> 
</head>
<body>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800"></h1>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">SB 게시판 글쓰기</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
              	<div id="dataTable_wrpper" class="dataTables_wrapper dt-bootstrap4">
              		<div class="row">
              				<div class="container">
								<h2 class="text-center" style="padding: 2ex;">${list.board_email }의 작성 글 </h2>
									<div class="row">
										<div style="height: auto; width: 100%; border:2px solid blue;">
										<table class="table">
											<tr>
												<th class="text-left"><font style="font-size: large;;"></font></th>
												<th class="text-right"></th>
											</tr>
											<tr>
												<th class="text-left"><font style="font-size: 13pt;"> 제목 : ${list.board_subject }</font></th>
												<th class="text-right">조회수 : ${list.board_hit }</th>
											</tr>
										</table>
										<table class="table" frame="void">
											<tr>
												<td colspan="2" class="text-left" valign="top" height="200">
												<pre style="white-space: pre-line; border: none; background-color: white; font-size: 13pt; font-family: sans-serif;">
												${list.board_content } </pre></td>
											</tr>
										</table>
										</div>
										<table class="table">
											<tr>
									          <td colspan="2" class="text-right">
										            <a href="${list.board_no }" class="btn btn-sm btn-info">수정</a>
										            <!-- <input type="button" class="btn btn-sm btn-danger" onclick="del('${list.board_no }')" value="삭제"> -->
											        	 <input type="button" class="btn btn-sm btn-danger"  value="삭제" id="delBtn">
										            	 <input type="hidden" name="no" value="${list.board_no }" id="no">
										            <a href="/main.do" class="btn btn-sm btn-info">목록</a>
									          </td>
									        </tr>
									     </table>
									</div>
								</div>
              </div>
            </div>
            <div class="row">
            
            </div>
          </div>
		</div>
     </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
</body>
</html>
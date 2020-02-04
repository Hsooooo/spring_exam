<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800"></h1>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">SB 게시판</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
              	<div id="dataTable_wrpper" class="dataTables_wrapper dt-bootstrap4">
              		<div class="row">
              			<div class="col-sm-12 col-md-6">
              				<div class="dataTables_length" id="dataTable_length">
              					<label>
									"Show "
									<select name="dataTable_length" aria-controls="dataTable" class="custom-select custom-select-sm form-control form-control-sm">
										<option value="10">10</option>
										<option value="25">25</option>
										<option value="50">50</option>
										<option value="100">100</option>
									</select>
									" entries"
              					</label>
              				</div>
              			</div>
              			<div id="dataTable_filter" class="dataTables_filter">
              				<label>
              					Search:
              					<input type="search" class="form-control form-control-sm" placeholder="" aria-controls="dataTable">
              				</label>
              			</div>
              			<div class="col-sm-12 col-md-12">
            				<a href="/board_insert.do" aria-controls="dataTable" data-dt-idx="12" tabindex="0" class="page-link">쓰기</a>
              			</div>
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th class="text-center"  width="15%" >게시물번호</th>
                      <th class="text-center"  width="35%">제목</th>
                      <th class="text-center"  width="15%">작성자</th>
                      <th class="text-center"  width="25%">작성일</th>
                      <th class="text-center"  width="10%">조회수</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="list" items="${list }" >
                    <tr>
                    	<td class="text-center" width="10%"><a href="/board_detail.do?no=${list.board_no }">${list.num }</a></td>
                    	<td><a href="/board_detail.do?no=${list.board_no }">${list.board_subject }</a></td>
                    	<td><a href="/board_detail.do?no=${list.board_no }">${list.board_name }</a></td>
                    	<td><a href="/board_detail.do">${list.today }</a></td>
                    	<td><a href="/board_detail.do">${list.board_hit }</a></td>
                    </tr>
                    </c:forEach>
                  </tbody>
                  
                </table>
              </div>
            </div>
            <div class="row">
            	<div class="col-sm-12 col-md-7">
            		<div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
            			<ul class="pagination">
            				<li class="pagination">
            					<a href="#" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
            				</li>
            				
            				<li class="paginate_button page-item active">
            					<a href="#" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link">1</a>
            				</li>
            				<li class="paginate_button page-item next" id="dataTable_next">
            					<a href="#" aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link">Next</a>
            				</li>
            			</ul>
            		</div>
            	</div>
            </div>
          </div>
		</div>
     </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
</body>
</html>
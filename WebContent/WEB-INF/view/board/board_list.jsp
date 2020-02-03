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
          <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
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
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>게시물번호</th>
                      <th>제목</th>
                      <th>작성자</th>
                      <th>작성일</th>
                      <th>조회수</th>
                    </tr>
                  </thead>
                  <c:forEach var="list" items="${list }" >
                  <tbody>
                    <tr>
                      <td>${list.board_no }</td>
                      <td>${list.board_subject }</td>
                      <td>신다울</td>
                      <td>${list.board_regdate }</td>
                      <td>${list.board_hit }</td>
                    </tr>
                  </tbody>
                  </c:forEach>
                  <tfoot>
                    <tr>
                      <th>게시물번호</th>
                      <th>제목</th>
                      <th>작성자</th>
                      <th>작성일</th>
                      <th>조회수</th>
                    </tr>
                  </tfoot>
                  
                </table>
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
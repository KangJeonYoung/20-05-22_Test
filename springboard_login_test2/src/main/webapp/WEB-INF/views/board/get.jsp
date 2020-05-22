<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../includes/header.jsp" %>    
    
<div class="row">
	<div class="col-lg-12">
		<h1 class = "page-header">Board Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class ="panel panel-default">
		
			<div class="panel-heading">Board Register</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
			
				<div class="row">
                    <div class="col-md-6 pr-1">
                      <div class="form-group">
                        <label> 번호 </label>
                        <input class="form-control" name='bno'
					value = '<c:out value="${board.bno }" />' readonly = "readonly">
                      </div>
                    </div>
                    <div class="col-md-6 pl-1">
                      <div class="form-group">
                        <label> 작성자 </label>
                        <input class="form-control" name='writer'
					value = '<c:out value="${board.writer }" />' readonly = "readonly">
                      </div>
                    </div>
                  </div>
                  
                 <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label> 제목 </label>
                        <input class="form-control" name='title'
					value = '<c:out value="${board.title }" />' readonly = "readonly">
                      </div>
                    </div>
                  </div>
				
				<div class="form-grop">
					<label>텍스트 내용</label>
					<textarea rows="3" class="form-control" name='content' readonly="readonly">
					<c:out value="${board.content }"></c:out>
					</textarea>
				</div>
				
				<button type="modify" class="btn btn-primary pull-right" onclick="location.href='/board/modify?bno=<c:out value="${board.bno }"/>'">글 수정</button>
				<button type="list" class="btn btn-primary pull-right" onclick="location.href='/board/list'">리스트</button>
			</div>
			<!-- end panel-body -->
		</div>
		<!-- end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->

	<form role="form" action="/replies/register" method="post">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
		<div class = "panel panel-default">
			<div class= "panel-heading">
				<i class = "fa fa-comments fa-fw"></i> 댓글
					<input type="hidden" name="bno" value="${board.bno }" />
					<button type="submit" id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
			</div>
			
			<div class = "panel-body">
				<ul class = "chat">
					<li class = "left clearfix" data-rno = '12'>
						<div>
							<div class = "header">
								<label>작성자</label> <input class="form-control" name='replyer'>
							</div>
							<label>내용</label>
							<p><textarea class = "form-control" rows="3" name ='reply'></textarea></p>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</form>

<c:forEach items="${list }" var="replies">
<c:if test="${replies.bno eq board.bno }" >
<div class = 'row'>
	<div class = "col-lg-12">
		
		<div class = "panel panel-default">
			<div class= "panel-heading">
				<i class = "fa fa-comments fa-fw"></i> 댓글
			</div>
			
			<div class = "panel-body">
				<ul class = "chat">
				
					<li class = "left clearfix" data-rno = '12'>
						<div>
							<div class = "header">
								<strong class = "primary-font"><c:out value="${replies.replyer }"/></strong>
								<small class = "pull-right text-muted"><fmt:formatDate pattern="yyyy-MM-dd"
                                   		value="${replies.replyDate }"/></small>								
							</div>
							<p><c:out value="${replies.reply }"/></p>
							
							<!-- 댓글의 삭제 버튼과 수정 버튼을 생성 -->
							<form action="/replies/remove" method="get">
							<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
							<input type="hidden" name="rno" value="${replies.rno }">
							<button type="button" class="btn btn-primary btn-xs pull-right" onclick="location.href='/replies/modify?rno=<c:out value="${replies.rno }"/>'">수 정</button>
							<button type="submit" id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>삭 제</button>
							</form>
							<!-- 댓글의 삭제 버튼과 수정 버튼을 생성 끝 -->
						
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
</c:if>
</c:forEach>



<%@include file="../includes/footer.jsp"%>
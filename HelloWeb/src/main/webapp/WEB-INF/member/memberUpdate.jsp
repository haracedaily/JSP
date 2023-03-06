<%@page import="co.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "../../includes/sidebar.jsp" %>
    <%@ include file = "../../includes/top.jsp" %>
<h3>회원수정조회(memberUpdate.jsp)</h3>
<%
MemberVO member = (MemberVO) request.getAttribute("vo");
String message = (String) request.getAttribute("message"); %>
<%if(message != null){ %>
<p><%=message %></p>
<%} %>

<form action="memberSearch.do">
<input type = "hidden" name="job" value="update">
찾을 ID : <input type ="text" name="id">
<input type ="submit" value="찾기">
</form>

<p></p>
<h3>회원 수정 정보</h3>
<%
	if(member != null){
%>
<form action="memberUpdate.do">
ID : <input type ="text" name="id" value="<%=member.getId() %>" readonly><br>
PW : <input type ="text" name="pw" value="<%=member.getPw() %>"><br>
NAME : <input type ="text" name="name" value="<%=member.getName() %>"><br>
MAIL : <input type ="text" name="mail" value="<%=member.getMail() %>"><br>
<input type="submit" value="수정">
</form>
<%
}
%>



    <%@ include file = "../../includes/footer.jsp" %>

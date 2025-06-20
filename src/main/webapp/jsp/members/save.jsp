<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
MemberSaveServlet.java 에 있는
httpservlet으로 파라미터 받고 memberRepository에 저장하는것과 완전히 똑같은 로직이 필요
그리고 <% <<< 이 표시는 자바 코드를 넣을 수 있음 -> 자바코드 그대로 복붙
참고! : request, response 는 그냥 그대로 사용가능
--%>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();

  System.out.println("MemberSaveServlet.service");
  String username = request.getParameter("username");
  String ageString = request.getParameter("age"); //request.getparameter 의 응답은 항상 문자형식임
  int age = Integer.parseInt(ageString);

  Member member = new Member(username,age);
  memberRepository.save(member);
%>


<%--
결국 얘네도 w.write로 다 찍는것임
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
  <li>id=<%=member.getId()%></li>
  <li>username=<%=member.getUsername()%></li>
  <li>age=<%=member.getUsername()%></li>
</ul>
<a href="/index.html">메인</a>

</body>
</html>

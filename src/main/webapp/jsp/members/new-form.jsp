<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 이부분이 jsp 파일이라는 의미 --%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/jsp/members/save.jsp" method="post">
    username:   <input type="text" name="username" />
    age:        <input type="text" name="age" />
    <button type="submit">전송</button>
</form>

</body>
</html>


<%-- form 부분은 basic.helllo-form.html에 있던 html 코드와 똑같음 --%>
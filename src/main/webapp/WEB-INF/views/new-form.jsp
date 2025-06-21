<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>

  <!-- 그냥 save << 상대경로 사용, [현재 URL이 속한 계층 경로 + /save]
  이렇게  상대경로를 사용하면 폼 전송시 현재 URL이 속한 계층 경로 + save가 호출-->
  <form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
  </form>

  </body>
</html>

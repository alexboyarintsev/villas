<%--
  Created by IntelliJ IDEA.
  User: shamp_000
  Date: 09.11.2014
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath}/admin/galleries" enctype="multipart/form-data">
  File to upload: <input type="file" name="file"><br />
  File name: <input type="text" name="fileName"><br /> <br />
  <input type="submit" value="Upload"> Press here to upload the file!
</form>

</body>
</html>

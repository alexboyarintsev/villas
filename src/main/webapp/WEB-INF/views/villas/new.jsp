<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>New villa</title>
</head>
<body>

<form method="POST" action="${pageContext.request.contextPath}/admin/villas" enctype="multipart/form-data">
    File to upload: <input type="file" name="file"><br />
    Name: <input type="text" name="name"><br /> <br />
    Description: <input type="text" name="description"><br /> <br />
    Price: <input type="text" name="price"><br /> <br />
    <input type="submit" value="Upload"> Press here to upload the file!
</form>

</body>
</html>
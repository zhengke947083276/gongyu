<%--
  Created by IntelliJ IDEA.
  User: 94708
  Date: 2018/5/25
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>批量导入客户</title>
<body>
    批量添加
    <form role="form" action="${contextPath}/excelDao/importUser" method="POST" enctype="multipart/form-data">
        <div>
            <label for="file">上传文件</label>
            <input type="file" id="file" name="file">
        </div>
        <input type="submit">提交</input>
    </form>

</body>
</html>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加员工</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3>添加员工页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="eno">员工号：</label>
            <input type="number" class="form-control" id="eno" name="eno" maxlength="8" placeholder="请输入员工号">
        </div>

        <div class="form-group">
            <label for="ename">姓名：</label>
            <input type="text" class="form-control" id="ename" name="ename" maxlength="10" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="esex" value="男" checked="checked"/>男
            <input type="radio" name="esex" value="女"/>女
        </div>


        <div class="form-group">
            <label for="edept">部门：</label>
            <select name="edept" class="form-control" id="edept">
            <c:forEach items="${departments}" var="departmnet" varStatus="s">
                <option value=${departmnet.dname}>${departmnet.dname}</option>
            </c:forEach>
            </select>
        </div>


        <div class="form-group">
            <label for="egrade">职位：</label>
            <select name="egrade" class="form-control" id="egrade">
                <c:forEach items="${salarygrades}" var="salarygrade" varStatus="s">
                    <option value=${salarygrade.grade}>${salarygrade.grade}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="erank">评价：</label>
            <select name="erank" class="form-control" id="erank">
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
                <option value="D">D</option>
            </select>
        </div>

        <div class="form-group">
            <label for="eage">工龄：</label>
            <input type="number" class="form-control" id="eage" name="eage" maxlength="2" placeholder="请输入工龄"/>
        </div>

        <div class="form-group">
            <label for="ewelfare">福利：</label>
            <select name="ewelfare" class="form-control" id="ewelfare">
                <c:forEach items="${welfares}" var="welfare" varStatus="s">
                    <option value=${welfare.wname}>${welfare.wname}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" onclick="history.back()"/>
        </div>
    </form>
</div>
</body>
</html>
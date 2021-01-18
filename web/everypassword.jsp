<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>


</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="">工资管理系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a style="text-align: left" href="${pageContext.request.contextPath}/everyListServlet?eno=${user.id}">查询个人信息</a></li>
                <li><a style="text-align: left" href="${pageContext.request.contextPath}/everySalaryServlet?eno=${user.id}">查询/打印工资</a></li>
                <li style="align-content: end"><a href="login.jsp">${employees.ename}，退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">
    <br>


    <h3 style="text-align: center">用户信息列表</h3>


    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>部门</th>
            <th>性别</th>
            <th>职位</th>
            <th>评价</th>
            <th>工龄</th>
            <th>福利</th>
        </tr>

            <tr>
                <td>${employees.eno}</td>
                <td>${employees.ename}</td>
                <td>${employees.edept}</td>
                <td>${employees.esex}</td>
                <td>${employees.egrade}</td>
                <td>${employees.erank}</td>
                <td>${employees.eage}</td>
                <td>${employees.ewelfare}</td>
            </tr>



    </table>
    </form>


</div>


</body>
</html>

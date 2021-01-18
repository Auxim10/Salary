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
<div class="container">
    <br>

    <a style="text-align: left" href="index.jsp">返回首页</a>
    <a style="text-align: right" href="login.jsp">退出登录</a>

    <h3 style="text-align: center">用户信息列表</h3>


    <form id="form" action="${pageContext.request.contextPath}/findSalaryServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCb"></th>
            <th>员工号</th>
            <th>姓名</th>
            <th>基础工资</th>
            <th>部门工资</th>
            <th>工龄工资</th>
            <th>福利津贴</th>
            <th>总工资</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${salarys}" var="salary" varStatus="s">
            <tr>
                <td>${salary.sno}</td>
                <td>${salary.sname}</td>
                <td><input type="text" class="form-control" value="${salary.basicsalary}" name="basicsalary" placeholder="请输入姓名"></td>
                <td><input type="text" class="form-control" value="${salary.vocationsalary}" name="vocationsalary" placeholder="请输入姓名"></td>
                <td><input type="text" class="form-control" value="${salary.agesalary}" name="agesalary" placeholder="请输入姓名"></td>
                <td><input type="text" class="form-control" value="${salary.welfare}" name="welfare" placeholder="请输入姓名"></td>
                <td><input type="text" class="form-control" value="${salary.allsalary}" name="allsalary" placeholder="请输入姓名"></td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findSalaryServlet">修改</a>&nbsp;
            </tr>

        </c:forEach>


    </table>
    </form>


</div>

</body>
</html>

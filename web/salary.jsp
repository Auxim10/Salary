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
    <title>工资管理系统</title>

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
            <a class="navbar-brand" href=""><img src="money.png" width="22" height="22"> 工资管理系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a style="text-align: left" href="${pageContext.request.contextPath}/findUserByPageServlet">查询员工信息</a></li>
                <li><a style="text-align: left" href="${pageContext.request.contextPath}/salaryServlet">查询工资信息</a></li>
                <li><a style="text-align: left" href="${pageContext.request.contextPath}/deptGradeWelfareServlet">工资设定</a></li>
                <li style="align-content: end"><a href="login.jsp">管理员，退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h3 style="text-align: center">员工工资信息列表</h3>

    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover table-striped">
        <tr class="success">
            <th>员工号</th>
            <th>姓名</th>
            <th>基础工资</th>
            <th>部门工资</th>
            <th>工龄工资</th>
            <th>福利津贴</th>
            <th>总工资</th>
            <th class="Noprint">操作</th>
        </tr>
            <style type="text/css" > @media print {
                .Noprint   {   display:   none;}
            } </style>
        <c:forEach items="${salaries}" var="salary" varStatus="s">
            <tr>
                <td>${salary.sno}</td>
                <td>${salary.sname}</td>
                <td>${salary.basicsalary}</td>
                <td>${salary.vocationsalary}</td>
                <td>${salary.agesalary}</td>
                <td>${salary.welfare}</td>
                <td>${salary.allsalary}</td>
                <td class="Noprint">
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findSalaryServlet?sno=${salary.sno}">修改</a>&nbsp;
                   </td>
            </tr>

        </c:forEach>
            <p id="ymd"></p>
            <script>
                var date = new Date()<!--获得日期数据-->
                var y = date.getFullYear();<!--年-->
                var m = date.getMonth()+1;<!--月，这里的月份必须要+1才是当前月份-->
                var lastm = date.getMonth();
                var d = date.getDate(); <!--日，getDay是获得当前星期几（0-6），getDate是获得当前日期-->
                document.getElementById("ymd").innerHTML = "工资日期："+y+"-"+m+"-"+d+"";
            </script>

    </table>
    </form>


</div>
    <center class="Noprint">
        <a class="btn btn-default btn-sm" href="javascript:window.print();" >打印</a>
    </center>



</body>
</html>

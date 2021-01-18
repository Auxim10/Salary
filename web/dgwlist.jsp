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

    <script>
        function update(id){
                location.href="${pageContext.request.contextPath}/2222?id="+id
        }
    </script>
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
    <br>


    <h4 style="text-align: center">部门信息列表</h4>




    <form id="form" action="${pageContext.request.contextPath}/updateDeptServlet" method="post">
        <table border="1" class="table table-bordered table-hover table-striped">
        <tr class="success">
            <th>部门</th>
            <th>部门基础工资</th>
            <th>操作</th>
        </tr>


        <c:forEach items="${departments}" var="department" varStatus="s">
            <tr>
                <td>${department.dname}</td>
                <td>${department.vocationsalary}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findDeptServlet?dname=${department.dname}">修改</a>
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/delDeptServlet?deptid=${department.dname}">删除</a></td>
            </tr>

        </c:forEach>

    </table>
    </form>
    <div style="float: right;margin: 5px;">

    <a class="btn btn-primary" href="${pageContext.request.contextPath}/adddept.jsp" >添加部门</a>

</div>
</div>



<div class="container">

    <h4 style="text-align: center">职位信息列表</h4>




    <form id="form2" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover table-striped">
            <tr class="success">
                <th>职位</th>
                <th>职位工资</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${salarygrades}" var="salarygrade" varStatus="s">
                <tr>
                    <td>${salarygrade.grade}</td>
                    <td>${salarygrade.gradesalary}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findGradeServlet?grade=${salarygrade.grade}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/delDeptServlet?said=${salarygrade.grade}">删除</a></td>
                </tr>

            </c:forEach>

        </table>
    </form>
    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/addgrade.jsp">添加职位</a>

    </div>

</div>

<p></p>
<p></p>
<div class="container">


    <h4 style="text-align: center">津贴信息列表</h4>


    <form id="form3" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover table-striped">
            <tr class="success">
                <th>福利</th>
                <th>福利工资</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${welfares}" var="welfare" varStatus="s">
                <tr>
                    <td>${welfare.wname}</td>
                    <td>${welfare.wsalary}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findWelServlet?wname=${welfare.wname}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/delDeptServlet?welid=${welfare.wname}">删除</a></td>
                </tr>

            </c:forEach>

        </table>
    </form>
    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/addwelfare.jsp">添加津贴</a>

    </div>

</div>



</div>



</div>

</body>
</html>

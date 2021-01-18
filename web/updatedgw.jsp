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
    <title>修改</title>

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
        function deleteUser(eno){
            //用户安全提示
            if(confirm("您确定要删除吗？")){
                //访问路径
                location.href="${pageContext.request.contextPath}/delUserServlet?eno="+eno;
            }
        }

        window.onload = function(){
            //给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick = function(){
                if(confirm("您确定要删除选中条目吗？")){

                    var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0; i < cbs.length; i++) {
                        if(cbs[i].checked){
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                    }

                    if(flag){//有条目被选中
                        //表单提交
                        document.getElementById("form").submit();
                    }

                }

            }
            //1.获取第一个cb
            document.getElementById("firstCb").onclick = function(){
                //2.获取下边列表中所有的cb
                var cbs = document.getElementsByName("uid");
                //3.遍历
                for (var i = 0; i < cbs.length; i++) {
                    //4.设置这些cbs[i]的checked状态 = firstCb.checked
                    cbs[i].checked = this.checked;

                }

            }


        }


    </script>
</head>
<body>
<div class="container">
    <br>

    <a style="text-align: left" href="index.jsp">返回首页</a>
    <a style="text-align: right" href="login.jsp">退出登录</a>

    <h4 style="text-align: center">部门信息列表</h4>



    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加部门</a>

    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>部门</th>
            <th>部门基础工资</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${departments}" var="depament" varStatus="s">
            <tr>
                <td>${depament.dname}</td>
                <td>${depament.vocationsalary}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?eno=${depament.dname}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/delDeptServlet?deptid=${depament.dname}">删除</a></td>
            </tr>

        </c:forEach>

    </table>
    </form>


</div>

<div class="container">

    <h4 style="text-align: center">职位信息列表</h4>



    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加职位</a>

    </div>
    <form id="form2" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>职位</th>
                <th>职位工资</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${salarygrades}" var="salarygrade" varStatus="s">
                <tr>
                    <td>${salarygrade.grade}</td>
                    <td>${salarygrade.gradesalary}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?eno=${salarygrade.grade}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/delDeptServlet?said=${salarygrade.grade}">删除</a></td>
                </tr>

            </c:forEach>

        </table>
    </form>


</div>


<div class="container">


    <h4 style="text-align: center">部门信息列表</h4>



    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加津贴</a>

    </div>
    <form id="form3" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>福利</th>
                <th>福利工资</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${welfares}" var="welfare" varStatus="s">
                <tr>
                    <td>${welfare.wname}</td>
                    <td>${welfare.wsalary}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?eno=${welfare.wname}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/delDeptServlet?welid=${welfare.wname}">删除</a></td>
                </tr>

            </c:forEach>

        </table>
    </form>


</div>


</div>



</div>

</body>
</html>

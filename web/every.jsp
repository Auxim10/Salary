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

    <h3 style="text-align: center">用户信息列表</h3>


    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCb"></th>
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
                <td><input type="checkbox" name="uid" value="${employee.eno}"></td>
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
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">
                </c:if>

                <c:if test="${pb.currentPage != 1}">
                    <li>
                </c:if>


                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage - 1}&rows=5&ename=${condition.ename[0]}&eno=${condition.eno[0]}&edept=${condition.edept[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>


                <c:forEach begin="1" end="${pb.totalPage}" var="i" >


                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&ename=${condition.ename[0]}&eno=${condition.eno[0]}&edept=${condition.edept[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&ename=${condition.ename[0]}&eno=${condition.eno[0]}&edept=${condition.edept[0]}">${i}</a></li>
                    </c:if>

                </c:forEach>


                <li>
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage + 1}&rows=5&ename=${condition.ename[0]}&eno=${condition.eno[0]}&edept=${condition.edept[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>

            </ul>
        </nav>


    </div>


</div>

<div class="container">
    <h3 style="text-align: center">员工工资信息列表</h3>

    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
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
            <tr>
                <td>${salaries.sno}</td>
                <td>${salaries.sname}</td>
                <td>${salaries.basicsalary}</td>
                <td>${salaries.vocationsalary}</td>
                <td>${salaries.agesalary}</td>
                <td>${salaries.welfare}</td>
                <td>${salaries.allsalary}</td>
                <td class="Noprint">&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:window.print();">打印</a></td>
            </tr>

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

</body>
</html>

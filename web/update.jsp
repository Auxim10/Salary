<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改员工信息</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>


    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改员工信息</h3>
        <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${employee.eno}">

            <div class="form-group">
                <label for="eno">员工号：</label>
                <input type="text" readonly class="form-control" value="${employee.eno}" name="eno" maxlength="8" placeholder="请输入员工号">
            </div>

            <div class="form-group">
                <label for="ename">姓名：</label>
                <input type="text" class="form-control" value="${employee.ename}" name="ename" maxlength="10" placeholder="请输入姓名">
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
                <select name="erank" class="form-control" value="${employee.erank}">
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                </select>
            </div>

            <div class="form-group">
                <label for="eage">工龄：</label>
                <input type="number" class="form-control" value="${employee.eage}" name="eage" maxlength="2" placeholder="请输入工龄"/>
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
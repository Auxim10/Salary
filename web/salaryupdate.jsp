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
        <title>修改工资信息</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改工资信息</h3>
        <form action="${pageContext.request.contextPath}/updateSalaryServlet" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="sno" value="${salary.sno}">

            <div class="form-group">
                <label for="eage">基础工资：</label>
                <input type="number" class="form-control" value="${salary.basicsalary}" maxlength="7" name="basicsalary" placeholder="请输入工龄"/>
            </div>


            <div class="form-group">
                <label for="eage">职位工资：</label>
                <input type="number" class="form-control" value="${salary.vocationsalary}" maxlength="7" name="vocationsalary" placeholder="请输入工龄"/>
            </div>

            <div class="form-group">
                <label for="eage">工龄工资：</label>
                <input type="number" class="form-control" value="${salary.agesalary}" maxlength="7" name="agesalary" placeholder="请输入工龄"/>
            </div>

            <div class="form-group">
                <label for="eage">福利津贴：</label>
                <input type="number" class="form-control" value="${salary.welfare}" maxlength="7" name="welfare" placeholder="请输入工龄"/>
            </div>

            <div class="form-group">
                <label for="eage">总工资：</label>
                <input readonly type="text" class="form-control" value="${salary.allsalary}" maxlength="7" name="allsalary" placeholder="请输入工龄"/>
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
<%@ page import="org.springframework.ui.Model" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
    <title>
        HTML audio autoplay Attribute
    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<%--                 알람 관련?--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<%--                   -----------------------  --%>
</head>
<h1>Welcome to Hello World!</h1>
<table class="table table-striped table-hover">
<%--    <div class = "alert alert-success alert-dismissible" role="alert">--%>

<%--        <button type="button" class = "close" data-dismiss="alert">×</button>--%>

<%--        <strong>성공 알림 발생!</strong> 메시지를 보시려면 <a href="#" class = "alert-link">이것</a>을 누르세요--%>

<%--    </div>--%>
    <%
         Object a=request.getAttribute("name");
         System.out.println("메인화면 파라미터 확인:"+a);
         if(a!=null){
    %>
    <script>
        alert("로그인 완료");

    </script>
    <%
        }
    %>


<tr var="name" items="${name}">
    <td>
<%--        <a href="/register/">register</a>--%>
        <input type="button" value="회원가입" onclick="location.href='/register/'">
    </td>
    <td>
<%--        <a href="/board/">board</a>--%>
        <input type="button" value="게시판" onclick="location.href='/board/'">
    </td>
    <td>
<%--        <a href="/boardUpload/">boardUpload</a>--%>
        <input type="button" value="음원 업로드" onclick="location.href='/boardUpload/'">
    </td>
    <td>

        <input type="button" value="알람" onclick="location.href='/alerts/'">
    </td>
    <form action="logout" method="post">
        <button type="submit" class="btn btn-primary">logout</button>
    </form>
</tr>
</table>



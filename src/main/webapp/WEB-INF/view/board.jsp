<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="kr" xmlns:th="http://www.thymeleaf.org">

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시판 목록</title>
<%--    <style>--%>
<%--        table {--%>
<%--            width: 100%;--%>
<%--            border: 1px solid #444444;--%>
<%--            border-collapse: collapse;--%>
<%--        }--%>
<%--        table th {--%>
<%--            border: 1px solid #444444;--%>
<%--            text-align: center;--%>
<%--            height: 40px;--%>
<%--            background-color: dodgerblue;--%>
<%--            color: cornsilk;--%>
<%--        }--%>
<%--        table td {--%>
<%--            border: 1px solid #444444;--%>
<%--            text-align: center;--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>
<div style="text-align: center;">
    <h1>게시판 목록</h1>
    <table class="table table-striped table-hover">
        <tr>
            <th scope="col">id</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">등록일</th>
        </tr>
        <c:forEach var="board" items="${upLoadList}">
            <tr>

                <td>
                        ${board.id}
                </td>
                <td>

                    <a href="<c:url value="/mp3Player/+${board.id}"/>" >${board.title}</a>
<%--                    <a href="/mp3Player/">${board.title}</a>--%>
                </td>
                <td>
                    ${board.name}
                </td>
                <td>
                    ${board.uploadDate}"
                </td>


            </tr>
        </c:forEach>
<%--        <tr th:each="board :${upLoadList}">--%>
<%--            <td>${board}</td>&ndash;%&gt;--%>
<%--        </tr>--%>

    </table>
    <a href="/boardUpload/">새글 등록</a>
</div>
</body>
</html>
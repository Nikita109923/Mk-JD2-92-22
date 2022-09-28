<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Форма голосования</title>
    </head>
    <body>
    <form method="POST">
    <div>
<label>Список продуктов</label>
               <select multiple name="genre">
                               <c:forEach items="${product}" var="item">
                                   <option value="${item.id}">${item.name}</option>
                               </c:forEach>
    </div>


        <input type="submit">
    </form>
    </body>
</html>
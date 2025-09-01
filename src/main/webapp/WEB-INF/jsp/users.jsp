<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h3 class="m-0">Користувачі</h3>
        <a href="${pageContext.request.contextPath}/users/new" class="btn btn-primary">+ Додати</a>
    </div>


    <c:choose>
        <c:when test="${empty users}">
            <div class="alert alert-secondary">Список порожній.</div>
        </c:when>
        <c:otherwise>
            <div class="table-responsive">
                <table class="table table-striped table-hover align-middle">
                    <thead>
                    <tr>
                        <th>ID</th><th>Ім'я</th><th>Прізвище</th><th>Email</th><th>Вік</th><th class="text-end">Дії</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="u" items="${users}">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.firstName}</td>
                            <td>${u.lastName}</td>
                            <td>${u.email}</td>
                            <td><c:out value="${u.age}"/></td>
                            <td class="text-end">
                                <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/users/edit?id=${u.id}">Редагувати</a>
                                <form method="post" action="${pageContext.request.contextPath}/users/delete" class="d-inline"
                                      onsubmit="return confirm('Видалити користувача #${u.id}?');">
                                    <input type="hidden" name="id" value="${u.id}">
                                    <button class="btn btn-sm btn-outline-danger" type="submit">Видалити</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
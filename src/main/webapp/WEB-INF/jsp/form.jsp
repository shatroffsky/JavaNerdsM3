<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><c:out value="${mode == 'edit' ? 'Редагувати' : 'Створити'}"/> користувача</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4">
    <a class="btn btn-link mb-3" href="${pageContext.request.contextPath}/users">← До списку</a>


    <div class="card shadow-sm">
        <div class="card-body">
            <h4 class="card-title mb-3">
                <c:out value="${mode == 'edit' ? 'Редагувати' : 'Створити'}"/> користувача
            </h4>
            <form method="post" action="${pageContext.request.contextPath}${mode == 'edit' ? '/users/update' : '/users/create'}">
                <c:if test="${mode == 'edit'}">
                    <input type="hidden" name="id" value="${user.id}"/>
                </c:if>


                <div class="row g-3">
                    <div class="col-md-6">
                        <label class="form-label">Ім'я</label>
                        <input class="form-control" name="firstName" value="${user.firstName}" required>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Прізвище</label>
                        <input class="form-control" name="lastName" value="${user.lastName}" required>
                    </div>
                    <div class="col-md-8">
                        <label class="form-label">Email</label>
                        <input class="form-control" type="email" name="email" value="${user.email}" required>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Вік</label>
                        <input class="form-control" type="number" name="age" value="${user.age}">
                    </div>
                </div>


                <div class="mt-4 d-flex gap-2">
                    <button class="btn btn-primary" type="submit">Зберегти</button>
                    <a class="btn btn-outline-secondary" href="${pageContext.request.contextPath}/users">Скасувати</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: X1 Carbon
  Date: 10/10/2021
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Free Bootstrap 4 Ecommerce Template</title>
    <!-- CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link href="<c:url value="/template/css/style.css" /> " rel="stylesheet" type="text/css">
</head>
<body>

<%--header--%>
<%@include file="header.jsp"%>
<%--end header--%>

<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                    <li class="breadcrumb-item"><a href="category.html">Category</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Sub-category</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-12 col-sm-3">
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i>Categories</div>
                <ul class="list-group category_block">
                    <c:forEach items="${listcate}" var="o">
                    <li class="list-group-item ${tagactive == o.cate_id ? "active":""}"><a href="product?cid=${o.cate_id}">${o.icon}${o.cname}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="card bg-light mb-3">
                <div class="card-header bg-success text-white text-uppercase">Last product</div>
                <c:forEach items="${list1A}" var="o">
                <div class="card-body">
                    <img class="img-fluid" src="${o.image}" />
                    <h5 class="card-title">${o.name}</h5>
                    <p class="card-text">${o.description}</p>
                    <p class="bloc_left_price">${o.price} $</p>
                </div>
                </c:forEach>
            </div>
        </div>
        <div class="col">
            <div class="row">
                <c:forEach items="${listAPByID}" var="o">
                    <div class="container mt-3 mb-4">
                        <div class="row">
                            <div class="col-sm">
                                <div class="card">
                                    <div class="card-header bg-primary text-white text-uppercase">
                                        <i class="fa fa-trophy"></i> ${o.cname}
                                    </div>
                                        <div class="card-body">
                                        <div class="row">
                                            <c:forEach items="${list}" var="p">
                                                <c:choose>
                                                    <c:when test="${p.categoryID == o.cate_id}">
                                                <div class="col-sm">
                                                    <div class="card">
                                                        <img class="card-img-top" src="${p.image}" alt="Card image cap">
                                                        <div class="card-body">
                                                            <h4 class="card-title"><a href="productdetail?pid=${p.id}" title="View Product">${p.name}</a></h4>
                                                            <p class="card-text">${p.description}</p>
                                                            <div class="row">
                                                                <div class="col">
                                                                    <p class="btn btn-danger btn-block">${p.price} $</p>
                                                                </div>
                                                                <div class="col">
                                                                    <a href="cart.html" class="btn btn-success btn-block">Add to cart</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                    </c:when>
                                                </c:choose>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <c:forEach items="${listAP}" var="o">
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="card">
                        <img class="card-img-top" src="${o.image}" alt="${o.name}">
                        <div class="card-body">
                            <h4 class="card-title"><a href="productdetail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                            <p class="card-text">${o.description}</p>
                            <div class="row">
                                <div class="col">
                                    <p class="btn btn-danger btn-block">${o.price} $</p>
                                </div>
                                <div class="col">
                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
                <div class="col-12">
                    <nav aria-label="...">
                        <ul class="pagination">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1">Previous</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item active">
                                <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Footer -->
<%@include file="footer.jsp"%>

<!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>


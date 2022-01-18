<%@ page import = "java.util.List" %>
<%@ page import = "ru.gb.model.Product" %>
<%@ page contentType = "text/html; character=utf-8" language="java" %>

<html>
    <head>
    <title>Product</title>
    </head>
<body>
    <h2>Product</h2>
    <hr>
    <% for (int i=0; i<10; i++) { %>
       <% Product pr = new Product(i, "Product " + i, 100); %>
       <p>Product name: <%= pr.getTitle() %></p>
       <% } %>

</body>
</html>
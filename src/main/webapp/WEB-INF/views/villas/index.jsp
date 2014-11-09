<%--
  Created by IntelliJ IDEA.
  User: shamp_000
  Date: 16.10.2014
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="app">
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js"></script>
  <script type="text/javascript" src='<%= request.getContextPath() + "/js/app.js" %>'></script>
</head>

<body ng-controller="VillasController as villasCtrl">
<!--  Store Header  -->
<header>
  <h1 class="text-center">Flatlander Crafted Gems</h1>
  <h2 class="text-center">– an Angular store –</h2>
</header>

<!--  Products Container  -->
<div class="list-group">
  <!--  Product Container  -->
  <div class="list-group-item" ng-repeat="villa in villasCtrl.villas">
    <h3>{{villa.name}} <em class="pull-right">{{villa.price | currency}}</em></h3>

    <h4>Description</h4>
    <blockquote>{{villa.description}}</blockquote>

    <!-- Image Gallery  -->
    <div class="img-wrap">
      <img ng-src="http://localhost:8080/admin/galleries/{{villa.images[0]}}" />
    </div>
    <%--<ul class="img-thumbnails clearfix">--%>
      <%--<li class="small-image pull-left thumbnail" ng-repeat="image in product.images">--%>
        <%--<img ng-src="{{image}}" />--%>
      <%--</li>--%>
    <%--</ul>--%>





  </div>
</div>
</body>
</html>

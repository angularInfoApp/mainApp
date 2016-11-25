<!DOCTYPE html>
<html ng-app="myApplication">

    	<head>  
    	<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
     	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" ></meta> 
     	<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
        <title>Jnana</title> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script type="text/javascript" src="./js/SweetAlert.js"></script>
        <script type="text/javascript" src="./js/fusioncharts.js"></script>
         <script type="text/javascript" src="./js/fusioncharts.charts.js"></script>
      	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
      	<script type="text/javascript" src="./js/angular-fusioncharts.js"></script>
      	<script type="text/javascript" src="./js/ngSweetAlertFull.js"></script>
      	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0rc1/angular-route.min.js"></script> 
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>         
        <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/1.3.3/ui-bootstrap.min.js"></script>
        <script type="text/javascript" src="http://code.angularjs.org/1.4.5/angular-animate.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-sanitize.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/1.3.3/ui-bootstrap-tpls.min.js"></script>  
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"></link>
        <link href="/css/sweet-alert.css" type="text/css" rel="stylesheet"></link>
        <script type="text/javascript" src="./js/dirPagination.js"></script>
        <script type="text/javascript" src="./js/mainModule.js"></script>
        <script type="text/javascript" src="./js/searchModule.js"></script>
        <script type="text/javascript" src="./js/adminModule.js"></script>
        <script type="text/javascript" src="./js/reportsModule.js"></script>
        <script type="text/javascript" src="./js/bmModule.js"></script>
        <script type="text/javascript" src="./js/tangCloud.min.js"></script>
        <script type="text/javascript" src="./js/config.js"></script>
        <script type="text/javascript" src="./js/angular-backtop.js"></script>
        <script type="text/javascript" src="./js/errorLog.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/stacktrace.js/1.3.1/stacktrace.js"></script>
        <script src="./js/angular-spinkit.js"></script>
    	<script src="/js/ng-tags-input.min.js"></script>
    	<script src="./js/angularjs-crypto.js"></script>
    	<script src="./js/CryptoJSCipher.js"></script>
    	<script src="./js/aes.js"></script> 
    	<!-- <script src="./js/aes.js"></script>
    	<script src="./js/mdo-angular-cryptography.js"></script> -->
    	<!-- for FF, Chrome, Opera -->
		<link rel="icon" type="image/png" href="/icon/book_blue-32.ico" sizes="16x16"></link> 
		<link rel="icon" type="image/png" href="/icon/book_blue-32.ico" sizes="32x32"></link> 

		<!-- for IE -->
		<link rel="icon" type="image/x-icon" href="/icon/book_blue-32.ico"></link> 
		<link rel="shortcut icon" type="image/x-icon" href="/icon/book_blue-32.ico"></link> 
    	
    	<link rel="stylesheet" href="/css/ng-tags-input.min.css" ></link>  
    	<link href="/css/sweet-alert.css" type="text/css" rel="stylesheet"></link>  
        <link href="/css/footer.css" type="text/css" rel="stylesheet"></link>  
        <link href="/css/main.css" type="text/css" rel="stylesheet"></link>
        <link href="/css/cloud.css" type="text/css" rel="stylesheet"></link>
        <link href="/css/404.css" type="text/css" rel="stylesheet"></link>
        <link href="/css/angular-backtop.css" type="text/css" rel="stylesheet"></link>
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css"></link>
		<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css"></link>    
   	</head>
    <body style="background-color:white">
  	<back-top  button-theme="light">Go to Top</back-top>
    <div class="container">
    <div ng-include="'views/Header.jsp'"></div>
        <ng-view></ng-view>
        </div>
       
 </body>   
 </html>
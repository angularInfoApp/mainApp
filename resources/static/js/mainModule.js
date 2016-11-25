var myApplication = angular.module('myApplication',['ngRoute','searchModule','adminModule','reportsModule','bmModule','tangcloud','ngAnimate', 'ngSanitize', 'ui.bootstrap','ngSweetAlertFull','my-config','loggerModule']);



myApplication.config(['$routeProvider','$httpProvider',
                      function($routeProvider,$httpProvider) {
	
	
	$httpProvider.defaults.cache = false;
    if (!$httpProvider.defaults.headers.get) {
      $httpProvider.defaults.headers.get = {};
    }
    // disable IE ajax request caching
	//$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
   $httpProvider.defaults.headers.get['If-Modified-Since'] = '0';
    
                      $routeProvider.
                      when('/main', {
                          templateUrl: '/views/search.jsp',
                          controller: 'searchCtrl'
                            }).when('/Reports',{ 
                            	
                            	templateUrl:'/views/Reports.jsp',
                            	controller:'reportsController'  
                            		
                            }).when('/Result',{                               	
                            	templateUrl:'/views/Result.jsp',
                            	  controller: 'searchCtrl'  
                            		  
                            }).when('/Admin',{                                	
                            	templateUrl:'/views/admin.jsp',
                            	controller:'adminsController'
                            	
                            }).when('/bookmark',{
                            	 	cache: false,
                            		templateUrl:'/views/bookmark.jsp',
                            		controller:'bmController'
                            			
                            	}).when('/404',{
                                    templateUrl: '/views/404.jsp'   
                                    	
                                }).otherwise({    	
                            		
                          redirectTo: '/main'
                      });
                  }]);
var reports=angular.module('reportsModule',['ng-fusioncharts']);

reports.controller('reportsController',['$scope', '$http', '$rootScope', '$location', 'applicationLoggingService',
                                function($scope, $http, $rootScope, $location,applicationLoggingService) {
	
	$rootScope.myDataSource=false;
	$rootScope.myDocViewSource=false;
	  $scope.names = ["Monthly", "Yearly", "Daily"];
	  $scope.selectedOption=$scope.names[0];
	  
	  $http.get('/getRatingReport').success(function(response){
			  var jsonConverts= angular.toJson(response);
			  $rootScope.finalReport=response;
			  $rootScope.myDataSource=true;
			  $rootScope.myDataSource = {
	              chart: {
	                  caption: "Document Rating Chart",
	                  subCaption: "Top 10 rated documents",
	                  xAxisName: "Document Name",
	                  yAxisName: "Rating",
	                  paletteColors: "#0075c2",
	                  bgColor: "#ffffff",
	                  borderAlpha: "20",
	                  canvasBorderAlpha: "0",
	                  usePlotGradientColor: "0",
	                  plotBorderAlpha: "10",
	                  placevaluesInside: "1",
	                  rotatevalues: "1",
	                  valueFontColor: "#ffffff",
	                  showXAxisLine: "1",
	                  xAxisLineColor: "#999999",
	                  divlineColor: "#999999",
	                  divLineDashed: "1",
	                  showAlternateHGridColor: "0",
	                  subcaptionFontBold: "0",
	                  subcaptionFontSize: "14"
	              },
	              data:$rootScope.finalReport
	            };
	  }).error(function(){
		  
		  SweetAlert.swal('Server Error Occured', 'Contact Administrator for error details', 'error');
	  });
	
	  $http.get('/getIncrDocReport').success(function(response){
		  var jsonConverts= angular.toJson(response);
		  $rootScope.docView=response;
		  $rootScope.myDocViewSource=false;
		  $rootScope.myDocViewSource = {
              chart: {
                  caption: "Document View Chart",
                  subCaption: "Top 10 viewed documents",
                  xAxisName: "Document Name",
                  yAxisName: "View",
                  paletteColors: "#0075c2",
                  bgColor: "#ffffff",
                  borderAlpha: "20",
                  canvasBorderAlpha: "0",
                  usePlotGradientColor: "0",
                  plotBorderAlpha: "10",
                  placevaluesInside: "1",
                  rotatevalues: "1",
                  valueFontColor: "#ffffff",
                  showXAxisLine: "1",
                  xAxisLineColor: "#999999",
                  divlineColor: "#999999",
                  divLineDashed: "1",
                  showAlternateHGridColor: "0",
                  subcaptionFontBold: "0",
                  subcaptionFontSize: "14"
              },
              data:$rootScope.docView
            };
  }).error(function(){
	  
	  SweetAlert.swal('Server Error Occured', 'Contact Administrator for error details', 'error');
  });

	  
	  $scope.optionCh=function(option){
		  console.log(option)
		  
	  }
	
}]);	
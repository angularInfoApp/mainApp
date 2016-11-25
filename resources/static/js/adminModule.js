var reportings=angular.module('adminModule',['ui.bootstrap','angularUtils.directives.dirPagination','ngSweetAlertFull']);


reportings.controller('adminsController',['$scope', '$http', '$rootScope', '$location','$route','SweetAlert',
                                function($scope, $http, $rootScope, $location,$route,SweetAlert) {
	
	/*tooltip description*/
	
	
	
	/*Pagination*/

	$scope.currentPage = 1;
	$scope.pageSize = 5;
	
	
	
	
	/*Loads LAN list*/	
	
	var userName="arun";
		$scope.errorLanMsg=false;
	$http.get('/getLan',{params: {'user': userName}}).success(function(data){
		$rootScope.lanpaths=[];
		$rootScope.lanpaths=data;
		if(!(data.length>0)){
			$scope.lanError="No Records Found!";
			$scope.errorLanMsg=true;
			
		}
	}).error(function(){
		
		SweetAlert.swal('Oops...', 'Something went wrong!', 'error');
		
	});
	
				/*Add LAN*/
	
	$scope.addMsg=false;	
	$scope.addLan=function(reqPath){
		$rootScope.paths=angular.isUndefined(reqPath);
		if($rootScope.paths===true){
			SweetAlert.swal('Field is blank!',
		  			  'Provide search input.',
		  			  'warning');
			}
		else{
			
		if(reqPath!=""){
			
			var reqLan={"userName":"arun","path":reqPath};

		 	var req = {
		 		method : 'POST',
		 		url : 'saveLan',
		 		headers : {
		 			'Content-Type' : 'application/json'
		 		},
		 		data : reqLan
		 	};
		 		$http(req).success(function(response) {
		 			
		 			$rootScope.lanpaths.push({path:$scope.lanPath,userName:"arun"});
					$rootScope.lanPath = '';
					$scope.errorLanMsg=false;
		 			$scope.lanMsg=false;
		 			$scope.addMsg=true;
		 			var myEl = angular.element( document.querySelector('#lanText' ));
		 			myEl.val('');
		 			
		 		}).error(function(response) {	
		 			
		 			SweetAlert.swal('Oops...', 'Something went wrong!', 'error');
	
		 	});
		}else{
			
			SweetAlert.swal('Field is blank!',
		  			  'Provide search input.',
		  			  'warning');
			
		}
	}
	}
			/*Remove LAN path */
	
	$scope.lanMsg=false;
	
	 $scope.remove = function(index,lans,user,id) {
		 
		    $scope.lanpaths.splice(index, 1);
		    
		    $rootScope.reLanPath=lans;
		    
		    $http.delete('/removeLan',{params: {'userName':user,'path':lans}}).success(function(response){
				  
				  $scope.success=lans+" removed from list.";
				  
				  $scope.addMsg=false;
				   $scope.lanMsg=true;
				   
				   if($scope.lanpaths.length<=0){
					   
					   $scope.addMsg=false;
					   $scope.lanMsg=false;
					   $scope.lanError="No Records Found!";
						$scope.errorLanMsg=true;
				   }
				  
			  }).error(function(){
				  
				  $scope.error="Something went wrong.Unable to delete";
				  SweetAlert.swal('Oops...', 'Something went wrong!', 'error');
				 
			  });
		   
		  };
		  
		 

	/*Get All users on load */

var arrayLst=[];

	$http.get('/getAdmins').success(function(data) {
	  $scope.users = data;
	  $scope.albumNameArray = [];
	    angular.forEach($scope.users, function(users){
	    	$scope.albumNameArray.push(users.userName);
	    	
	    });
	
	  arrayLst=$scope.albumNameArray;	  
	  $scope.domains = arrayLst;
	  
});

$scope.selected = undefined;
$scope.adminValue=false;
$scope.erMessage=false;


			/*Search user */

	$scope.searchAdmin=function(name){
		$scope.names=angular.isUndefined(name);	
		if($scope.names!=true){
		if(name!=""){
		
			$rootScope.userName = name;
			$http.get('/getUsers',{params: {'users': name}}).success(function(data){
		
				if(data.length>0){
			$rootScope.adminUser={};
			$rootScope.adminUser = data;
			$scope.erMessage=false;	
			$scope.adminValue=true;
		 }else{
			 $scope.adminValue=false; 
			 $scope.erMessage=true;	
				
		 }
		}).error(function(){
			
			$scope.adminValue=false;
			$scope.errorMsg="No Records found";
			$scope.erMessage=true;
			SweetAlert.swal("Oops...", "Something went wrong!", "error");
			
		});
		}else{
			 $scope.adminValue=false; 
			 $scope.erMessage=true;	
			
		}
}else{
	
	$scope.adminValue=false;
	$scope.errorMsg="No Records found";
	$scope.erMessage=true;
	
}
}

				/* Uncheck */


	$scope.uncheck=function(){
		
		if($scope.checked1==true||$scope.checked2==true||$scope.checked3==true||$scope.checked4==true||
				$scope.checked5==true){
		
		
			$scope.checked1=false;
			$scope.checked2=false;
			$scope.checked3=false;
			$scope.checked4=false;
			$scope.checked5=false;
		}
	}
				/*Save all users	 */
	$scope.saveAll=function(){
		if($scope.checked1==false && $scope.checked2==false && $scope.checked3==false && $scope.checked4==false &&
				$scope.checked5==false){
			
			//alert("No changes to save.Give access to atleast one user and proceed.");
			SweetAlert.swal("No changes to save.Give access to atleast one user and proceed.");
		}
		else{
			
			SweetAlert.swal("Changes saved.");
			
		}
		
	}
	
	
	
	
}]);	
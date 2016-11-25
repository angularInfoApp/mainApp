var bmModel=angular.module('bmModule',['angularjs-crypto']);

bmModel.run(function(cfCryptoHttpInterceptor, $rootScope) {
    $rootScope.base64Key = CryptoJS.enc.Base64.parse("0123456789abcdes");
	$rootScope.iv = CryptoJS.enc.Base64.parse("aaasssssssssssss");
})
	

bmModel.controller('bmController',['$scope', '$http', '$rootScope', '$location',
                                          function($scope, $http, $rootScope, $location) {
    
	

	$scope.erroroMsg=false;
	$scope.bookmarks=["All Tags","Rating","Occurance","Visit"];
       $scope.selectedOption=$scope.bookmarks[0];
       
       $scope.bookmarkFn=function(){
    	   var user_id="inf@global";
           $http.get('/getBookmarks',{params: {'user': user_id}}).success(function(data){
        	   
        	   $scope.bookmarking=data;
        	   if(!(data.length>0)){
     				$scope.bookError="No Bookmarks Found!";
     				$scope.erroroMsg=true;
     			}
           }).error(function(data){
        	   
        	   SweetAlert.swal("Oops...", "Something went wrong!", "error");
        	   
           });
           
       }
       
       /*method to open documents */
  	 
  	 $scope.openDoc=function(url){
  		 
  		/* var encrypted = $crypto.encrypt(url);
 	    var decrypted = $crypto.decrypt(encrypted);
 	   console.log(decrypted);
 	    console.log(encrypted);*/
  		$scope.source_string = url;
  		console.log('source String = ' + $scope.source_string);
  		
  			var encrypted = CryptoJS.AES.encrypt(
  				  $scope.source_string,
  				  $rootScope.base64Key,
  				  { iv: $rootScope.iv });
  			console.log('encrypted = ' + encrypted);

  			$scope.ciphertext = encrypted.ciphertext.toString(CryptoJS.enc.Base64);
  			console.log('ciphertext = ' + $scope.ciphertext);

  			var cipherParams = CryptoJS.lib.CipherParams.create({
  					ciphertext: CryptoJS.enc.Base64.parse($scope.ciphertext)
  				  });
  			
  			var decrypted = CryptoJS.AES.decrypt(
  			  cipherParams,
  			  $rootScope.base64Key,
  			  { iv: $rootScope.iv });
  			console.log("decrypted before:  "+decrypted);
  			  $scope.descrString = decrypted.toString(CryptoJS.enc.Utf8);
  			  console.log('decrypted='+$scope.descrString);
 	    
  		 
  		 $http.get('/openDoc',{params: {'url': url}}).success(function(data){ 			
  				
  		}).error(function(){
  			
  			SweetAlert.swal("Oops...", "Something went wrong!", "error");
  			
  		});
  		 
  	 }
          }]);	
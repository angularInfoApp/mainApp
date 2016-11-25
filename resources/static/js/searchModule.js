var result=angular.module('searchModule',['ui.bootstrap','angularUtils.directives.dirPagination','angularSpinkit','ngSweetAlertFull','my-config','angular.backtop','ngTagsInput']);

result.controller('searchCtrl',['$scope', '$http', '$rootScope', '$location','$sce','SweetAlert','ITEMS_PER_PAGE','applicationLoggingService',
                   function($scope, $http, $rootScope, $location,$sce,SweetAlert,ITEMS_PER_PAGE,applicationLoggingService) {	
	
	
	
	$scope.itemsPerPage=ITEMS_PER_PAGE;
	
	
	
		

	
	
	
	$scope.myVal=false;
	
	 $scope.item = {
			    bookmark: false
			  };
	 
	 
	 		/*Search TypeAhead Functionality */
	 
	 $scope.typeAhead=function(term){
		
		 return	 $http.get('/getTypeAhead',
				 {params: {'query': term}}).then(function(response){
					 
					 console.log(response);
					 $scope.typeList=[];
					 $scope.typeList=response.data;
					 console.log(response.data);
					 
					 return  $scope.typeList;
				
			}).catch(function(response){
				
				 applicationLoggingService.error({
		             message: "error retrieving data",
		             reason: response.body
		         });
				
			});
		 
	 }
	 $scope.searchtag=undefined;
	 
	 	/*method to open documents */	 
	 $scope.openDoc=function(url){
		 console.log(url);
		  $http.get('/openDoc',{params: {'url': url}}).success(function(data){
				
		}).error(function(data){
			
			 applicationLoggingService.error({
	             message: "error retrieving data",
	             reason: data.body
	         });
			
		});
		 
	 }
	 
	 	/*	Get words for clout implementation  */	 
	 
	 var tagLst=[];
	$http.get('/getSearchTags').success(function(data) {
		
		  $scope.tags = data;
		  $scope.tagLstArray = [];
		  
		  angular.forEach($scope.tags, function(tags){
		    	$scope.tagLstArray.push(tags.searchTag);
		    	
		    });
		  
		  
		  tagLst=$scope.tagLstArray;	  
		  $scope.tagList = tagLst;
		  
	}).error(function(data){
		 applicationLoggingService.error({
             message: "error retrieving data",
             reason: data.body
         });
	
	});
	
	/*	Get words for adding tag- implementation  */
	
	$scope.addTag=function(tag){
		alert(tag);
		$http.get('/addTag',{params: {'tag': tag}}).success(function(data) {
			  console.log(data.status);
		}).error(function(data){
			 applicationLoggingService.error({
	             message: "error retrieving data",
	             reason: data.body
	         });
		
		});
	}
		
		/*	Get words for removing tag- implementation  */
		$scope.tagRemove=function(tag){
			$http.get('/removeTag',{params: {'tag': tag}}).success(function(data) {
			  console.log(data.status);
		}).error(function(data){
			 applicationLoggingService.error({
	             message: "error retrieving data",
	             reason: data.body
	         });
		
		});
		}
	
				/*	 */

	$scope.rating = 0;	 
	$scope.currentPage = 1;
	$scope.pageSize = 5;	
	$scope.starRating3 = 0;
	
	
	
					$rootScope.progressing = false;
					
	  			  	$scope.resultValidate=function(searchtag){
	  			  		
	  				$rootScope.progressing = true;
	  				$rootScope.searchVal=searchtag;
	  				var searchValue=$rootScope.searchVal;
	  				if(searchValue==null||searchValue==""){
	  					
	  				SweetAlert.swal('Field is blank!',
	  		  			  'Provide search input.',
	  		  			  'warning');
	  				
	  				$rootScope.progressing = false; 
	  			}
	  		else{
	  				$rootScope.progressing = true;       	
	  				$http.get('/getAll',{params: {'query': searchValue}}).success(function(data){
	  					$rootScope.progressing = true;
	  					$rootScope.documents={};
	  					$rootScope.documents = data;
	  		if(!(data.length>0)){
	  						$rootScope.listFound="No result Found!"
	  						$scope.ResultMsg=true;
	  						$rootScope.progressing = false;
	  						//$location.path('Result');
	  						SweetAlert.swal('Result Not Found!', 'No result found for the searched criteria.', 'warning');
	  		}else{
	  					$scope.ResultMsg=false;
	  					$rootScope.progressing = false;
	  					$location.path('Result');
	  					
	  					}}).error(function(data){
	  						$rootScope.progressing = false;
		  					SweetAlert.swal('Server Error Occured', 'Contact Administrator for error details', 'error');
		  					$rootScope.progressing = false;
	  					$rootScope.progressing = false;  
	  					 applicationLoggingService.error({
	  	                    message: "error retrieving data",
	  	                  reason: data.status
	  	                });
	  					
	  				})
	  			  }
		}
	  			 
	  			  
	  			  
		$scope.resultValidateReload=function(searchtag){
			$scope.myVal=false;
			$rootScope.searchVal=searchtag;
  			var searchValue=$rootScope.searchVal;
  			if(searchValue==null||searchValue==""){					
  				SweetAlert.swal('Field is blank!',
	  		  			  'Provide search input.',
	  		  			  'warning');
  				$rootScope.progressing = false; 
  			}
  		else{ 
  			$rootScope.progressing = true;  
  		$http.get('/getAll',{params: {'query': searchValue}}).success(function(data){
  			$rootScope.progressing = true;
  					$rootScope.documents={};
  					$rootScope.documents = data;
  					if(!(data.length>1)){
  						$rootScope.listFound="No result Found!"
  							$scope.ResultMsg=true;
  							$rootScope.progressing = false;
  			 		 $location.path('Result');
  						
  					}else{
  						$scope.ResultMsg=false;
  					$rootScope.progressing = false;
  					$location.path('Result'); 	
  		}
  				}).error(function(data){
  					$rootScope.progressing = false;
  					SweetAlert.swal('Server Error Occured', 'Contact Administrator for error details', 'error');
  					$rootScope.progressing = false;
  					$rootScope.progressing = false;  
  					 applicationLoggingService.error({
  	                    message: "error retrieving data",
  	                  reason: data.status
  	                });
  					
  				})
  			  }
		}  
		
		/* $scope.test = function(word) {
		        
			 var words=word;
	         $http.get('/getAll',{params: {'query': words}}).success(function(data){
					
					$rootScope.documents={};
					$rootScope.documents = data;
					 $location.path('Result');
							
				}).error(function(data){
					
					 applicationLoggingService.error({
		                    message: "error retrieving data",
		                    reason: data.status
		                });
				});
	     }*/
		 
		 		/* Save bookmark for documents */
		 
		 $scope.bookMrk=function(event,name,path){
			 	var user_id="inf@global";
			    $scope.colors = $(event.currentTarget).css('color');
			    if( $scope.colors == "rgb(0, 0, 0)"){
			    	var status=1;
				 	var bookmark={"user_id":user_id,
				 			"doc_name":name,
				 			"doc_url":path,
				 			"status":status};

				 	var req = {
				 		method : 'POST',
				 		url : 'saveBookmark',
				 		headers : {
				 			'Content-Type' : 'application/json'
				 		},
				 		data : bookmark
				 	};

				 	$http(req).success(function(data) {
				 		SweetAlert.swal({ title: name,
				 				  text: 'Document is now bookmarked.',
				 				  imageUrl: 'http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png',
				 				  imageWidth: 400,
				 				  imageHeight: 200,
				 				  animation: true});
				 	}).error(function(data) {	
				 			
				 		 applicationLoggingService.error({
			                    message: "error retrieving data",
			                    reason: data.body
			                });
				 		$rootScope.progressing = false;
	  					SweetAlert.swal('Server Error Occured', 'Contact administrator', 'error');
	  					$rootScope.progressing = false;
				 		 
				 	});
			    	
			    }
			    else{
			    	$http.delete('/removeBookmark',{params: {'user_id':user_id,'doc_path':path}}).success(function(response){
			    		SweetAlert.swal('UnBookmarked!',
			  		  			  'Bookmark removed for '+name,
			  		  			  'success');
					  }).error(function(){
						  
						  applicationLoggingService.error({
			                    message: "error retrieving data",
			                    reason: data.body
			                });
						  
					  });
			    }
		 }
	  		
		
		 		/* Show document details in preview section	  */
		 
	    $scope.showDetails=function(name,size,author,avgRate,rateCount,content,path){
	    	$scope.myVal=true;
	    	$rootScope.nameLatest=name;
	    	$rootScope.fileSiz=size;
	    	$rootScope.Author=author;
	    	$rootScope.avgRate=avgRate;
	    	$rootScope.rateCounts=rateCount;
	    	$rootScope.contentVal=content;
	    	var strings="/getPreview?file="+path;
	    	$rootScope.pathVal=strings;
	    	console.log(strings);
	    	
	    }
	    
	    
	    	/*	save rating for documents     */
	    
	    $scope.saveRating = function(rating,fileName) {	    	
		 var intRating=parseInt(rating);
		 	var userId="inf@global";
		 	var doc=$rootScope.docId;
		 	var rating={"rating":intRating,"docId":fileName,"userId":userId};//if the id is autoGenerated in business logic send only  rating

		 	var req = {
		 		method : 'POST',
		 		url : 'saveRating',
		 		headers : {
		 			'Content-Type' : 'application/json'
		 		},
		 		data : rating
		 	};

		 	$http(req).success(function(data, status, headers, config) {
		 		if(data==1){
		 			SweetAlert.swal({ title: fileName,
		 				  text: 'Document rated successfuly.',
		 				  imageUrl: 'http://image.flaticon.com/icons/svg/221/221768.svg',
		 				  imageWidth: 400,
		 				  imageHeight: 200,
		 				  animation: true});
		 		}else{
		 			SweetAlert.swal('Already Rated!',
		  		  			  'You have already rated '+fileName,
		  		  			  'warning');
		 		}
		 	}).error(function(data, status, headers, config) {
	
		 		
		 		 applicationLoggingService.error({
	                    message: "error retrieving data",
	                    reason: data.body
	                });
		 		 
		 	});

		 	
		 };
	    
	  			
	  			
	  			
	
}]);

			/*Directive for Bookmark functionality */
result.directive('buttonBookmark', function(){
	  return {
		    scope: true,
		    restrict: 'E',
		    bookVal: '=',
		    onBookSelected: '&',
		    template: '<span style="font-size:12px;cursor:pointer;"  class="glyphicon glyphicon-bookmark" ng-class="{active:item.bookmark||item.status==1}" ng-click="bookMrk($event,item.fileName,item.url)"></span>',
		    link: function($scope, elem) {
		      elem.bind('click', function() {

		        $scope.$apply(function() {
		        	
		        	if($scope.item.status==1){
		        		 
		        		 $scope.item.bookmark = !$scope.item.bookmark;
		        		 $scope.item.status= 0;
		        		 elem.removeClass('active');
		        		 $scope.item.bookmark = !$scope.item.bookmark;
		        		 return;
		        	}else{	        		
		        		
		        	}
		        	 $scope.item.bookmark = !$scope.item.bookmark;
		       
		        });
		      });
		    }
		  };
		});



result.directive('starRating', function () {
    return {
        scope: {
            rating: '=',
            maxRating: '@',
            readOnly: '@',
            click: "&",
            mouseHover: "&",
            mouseLeave: "&"
        },
        restrict: 'EA',
        template:
            "<div style='display: inline-block; margin: 0px; padding: 0px; cursor:pointer;' ng-repeat='idx in maxRatings track by $index'> \
                    <img ng-src='{{((hoverValue + _rating) <= $index) && \"https://cdn1.iconfinder.com/data/icons/hawcons/32/699370-icon-23-star-20.png\" || \"https://cdn0.iconfinder.com/data/icons/small-n-flat/24/678064-star-20.png\"}}' \
                    ng-Click='isolatedClick($index + 1)' \
                    ng-mouseenter='isolatedMouseHover($index + 1)' \
                    ng-mouseleave='isolatedMouseLeave($index + 1)'></img> \
            </div>",
        compile: function (element, attrs) {
            if (!attrs.maxRating || (Number(attrs.maxRating) <= 0)) {
                attrs.maxRating = '5';
            };
        },
        controller: function ($scope, $element, $attrs) {
            $scope.maxRatings = [];

            for (var i = 1; i <= $scope.maxRating; i++) {
                $scope.maxRatings.push({});
            };

            $scope._rating = $scope.rating;
			
			$scope.isolatedClick = function (param) {
				if ($scope.readOnly == 'true') return;

				$scope.rating = $scope._rating = param;
				$scope.hoverValue = 0;
				$scope.click({
					param: param
				});
			};

			$scope.isolatedMouseHover = function (param) {
				if ($scope.readOnly == 'true') return;

				$scope._rating = 0;
				$scope.hoverValue = param;
				$scope.mouseHover({
					param: param
				});
			};

			$scope.isolatedMouseLeave = function (param) {
				if ($scope.readOnly == 'true') return;

				$scope._rating = $scope.rating;
				$scope.hoverValue = 0;
				$scope.mouseLeave({
					param: param
				});
			};
        }
    };
});
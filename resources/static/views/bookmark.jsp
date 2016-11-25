  <div class="row" ng-init="bookmarkFn()">
    <div class="col-sm-7" style="margin-top: -5px;">
      <h2>Bookmarks</h2>
      </div>
      
      <!-- <div class="col-sm-3" style="padding-left: 15px;">
      <h4 style="padding-left: 3px;">Show By: <select class="selectpicker" ng-model="selectedOption" data-ng-options="x for x in bookmarks" style="font-size: 15px !important; margin-right: 80px;">
</select></h4></div>

<div class="col-sm-2">
             <h4> <span style="font-size: 18px !important" class="glyphicon glyphicon-share-alt">Share Bookmarks</span> </h4>
              </div> -->
             
              </div>
              
              <div class="row">
              <div class="col-sm-12">
               <hr class="stylesBook">
              </div>
              </div>
              <div class="row">
              <div class="col-sm-4" ng-repeat="bookmark in bookmarking">
              <div class="well paddingSty">
               <a href="" style="font-size:13px" ng-click="openDoc(bookmark.doc_url)" ng-class="{textStyles:bookmark.doc_name.length >50}">{{bookmark.doc_name}}</a>
                </div>
              
              </div>
              </div>
              <div class="row">
               <div ng-show="erroroMsg">
  			   <p class="text-primary text-center" style="font-size:20px;margin-top: 25px;">{{bookError}}</p>
  				</div>
              </div>
              

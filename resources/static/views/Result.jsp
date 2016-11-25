<div class="row">
<div class="col-md-9" style="background-color:white;border-right: 1px solid black;">

<div class="row">
<div class="col-md-12">
        <br><br>
            <div id="custom-search-input">
                <div class="input-group col-md-12" style="padding-right: 21px; padding-bottom: 12px; margin-top: -22px;">
                    <input type="text" class="form-control input-lg" id="searchTxts" uib-typeahead="domain for domain in typeAhead($viewValue)" ng-model="searchtag" placeholder="Search" ng-keydown="$event.which === 13 && resultValidateReload(searchtag)"  />
                    <span class="input-group-btn">
                        <button class="btn btn-info btn-lg" style="font-size: 18px !important;" type="button" ng-click="resultValidateReload(searchtag)">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </span>
                </div>
            </div> 
             <tags-input ng-model="tagList" placeholder="Search Tag" on-tag-clicked="resultValidateReload($tag.text)" on-tag-adding="addTag($tag.text)" on-tag-removing="tagRemove($tag.text)" min-tags="1"
  max-tags="5" style="cursor:pointer"></tags-input>
             <!-- <circle-spinner ng-show="progressing"></circle-spinner>  -->
                        <wave-spinner ng-show="progressing"></wave-spinner>       
      </div>
      </div>
     <br>
     
   <div dir-paginate="item in documents|orderBy:'-count'|itemsPerPage:itemsPerPage" ng-if="item.count!=0"  current-page="currentPage" id="paginate" style="cursor: pointer;">  
    
     <div class="row">
     <div class="col-md-6">
     <span style="text-decoration: underline; color:#23527c !important;"> <a href="" ng-click="openDoc(item.url)" ><b>{{item.fileName}}</b></a></span>
     </div>
    
     <!-- <div class="star-rating col-md-4"  star-ratings rating-value=item.avgRating data-max="5"></div> -->
      <div class="col-md-4" star-rating rating="item.avgRating" read-only="true" max-rating="5"></div>
     
    
     <div class="col-md-2" style="top: 6px;">
     <a  data-target="#" data-ng-click="showDetails(item.fileName,item.fileSize,item.author,item.avgRating,item.rateCount,item.highlightTxt,item.url)" class="btn btn-success btn-lg" style="font-size:10px !important;">
      <span class="glyphicon glyphicon-preview"></span>Preview</a>
     </div>
     </div>  
     <div class="row">
     <div class="col-md-10" style="margin-top: -16px">
     <div>
     <span style="color:darkslategray;">{{item.date}}</span><span ng-bind-html="item.highlightTxt"  style="font-size: 12px;color:black"></span>
     </div>    
     </div>
     </div>
    

<div class="row" style="margin-bottom: 25px;">
<div class="col-md-2">
  <span style="font-size: 12px !important;">Doc Type: {{item.fileType}}</span>
  </div>
  
  <div class="col-md-3">
  <span style="font-size: 12px !important;">No of Occurances:  {{item.count}}</span>
  </div>
  
  <div class="col-md-2" >
  <span style="font-size: 12px !important;">Bookmark</span>
          <button-bookmark></button-bookmark>
          </div>
          
          
  <div class="col-md-5"  style="text-align: right;top: -9px;">
  <span style="top: 10px; right: 145px; font-size: 12px !important; position: absolute;"> Rate-</span>
  <!-- <span class="star-rating" star-rating rating-value='rating' data-max="5" on-rating-selected='saveRating(rating,item.fileName)'></span> -->
   <div star-rating rating='rating' read-only="false" max-rating="5" click='saveRating(param,item.fileName)'></div>
  </div> 

 
 </div>
</div>
 <p><dir-pagination-controls   max-size="5" direction-links="true" boundary-links="true" ></dir-pagination-controls></p>
<br>
<div class="row" style="margin-top: -55px; margin-bottom: 25px;">
               <div ng-show="ResultMsg">
  			   <p class="text-primary text-center" style="font-size:20px;margin-top: 25px;">{{listFound}}</p>
  				</div>
              </div>
  
  
 </div> 


<div class="col-md-3">
 <div ng-show="myVal">
    
    <br>
    <div style="margin-top: -23px;">
    <p class="text-primary">Author : {{Author}}</p>
    <p class="text-primary">Title : {{nameLatest}}</p>
    <p style="color: dimgray;">{{fileSiz}}</p>
    </div>
    <div>
    <p style="color: dimgray;" ng-bind-html="contentVal">
    </p>
    </div>
    <div>
   
<!-- <div class="col-md-4" star-rating rating="avgRate" read-only="true" max-rating="5"></div> -->
  <div class="col-md-6" star-rating rating="avgRate" read-only="true" max-rating="5"></div>
  <span>
 <p style="color: dimgray; margin-left: 8px; font-size: 15px !important">( {{rateCounts}} Users)</p>
  </span>
    </div>
    <h5 style="color: dimgray; margin-top: 15px !important;">{{item.fileType}} Preview</h5>
    <div>
    <iframe src={{pathVal}} style="width: 350px; height: 400px;"></iframe>
   </div>
    
    </div>
    </div>
    </div>


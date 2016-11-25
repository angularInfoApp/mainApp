<!-- hello jsp..chnages made.-->
<div class="col-sm-3" style="background-color:white">
<br>
<!-- 4 buttons -->
<table>
<tr>
<td>
<nav>
<ul class="nav nav-pills nav-stacked">
  <li  role="presentation" ng-class="{active:items == 1}"><a  class="point" ng-click="items = 1">Configure search paths</a></li>  
  <li role="presentation"  ng-class="{active:items == 2}"><a  class="point" ng-click="items = 2">User permission</a></li>
  <li role="presentation"  ng-class="{active:items == 3}"><a  class="point" ng-click="items = 3">Monitor Jobs</a></li>
  <li  role="presentation" ng-class="{active:items == 4}"><a class="point" ng-click="items = 4">Organise links</a></li>
</ul>
</nav>
</td>
</tr>

</table>
</div>
<div ng-init='items = 1'>
<div class="well well-lg col-sm-9" style="margin-top: 19px; background-color: white;" ng-show='items == 1'>
<br>
<div class="row">
    <div class="input-group col-sm-12">
      <input type="text" class="form-control"  ng-value="lanVal" id="lanText"  ng-model="lanPath" placeholder="Add LAN Path">
      <span class="input-group-btn">
        <button class="btn btn-secondary buttonStys" style="border-color: rgb(204, 204, 204); padding: 6px; color: black; 
        line-height: 16px; font-family: Segoe UI; margin-top: -5px;" type="button" ng-click="addLan(lanPath)">ADD</button>
      </span>
       <span style="top: -22px; left:5px;cursor: pointer;" tooltip-placement="left" uib-tooltip="LAN path has to be in the format:	Eg:C:\\abc\\abc\\abc\\abc..
        	  Please check the URL format before adding." class="glyphicon glyphicon-info-sign"></span>
    </div>
  </div>
  <br>
  <div class="col-sm-12" ng-show="lanMsg">
  <p style="text-align: left;margin-top: 20px;"><span class="lanSpan">LAN Path "{{reLanPath}}"</span> <span class="lanSpan">removed.</span></p>
  </div>
  <div class="col-sm-12" ng-show="addMsg">
 <p style="text-align: left;margin-top: 20px;"><span class="addSpan text-success">LAN Path "{{lanPath}}"</span> <span class="addSpan">added.</span></p>
  </div>
  <table class="table" style="margin-top: 25px;">
	<tr>
		<th class="tabSty">LAN PATH</th>
	</tr>
	<tr ng-repeat="lan in lanpaths" >
		
		<td>{{lan.path}}</td><td><a class="icon point">
		<span class="glyphicon glyphicon-trash delete" ng-click="remove($index,lan.path,lan.userName,lan.id)"></span></a></td>	
	</tr>
</table>
   <div ng-show="errorLanMsg">
   <p class="text-primary text-center" style="font-size:20px;margin-top: 25px;">{{lanError}}</p>
   </div>
   </div>
</div>

<div style="margin-top: 19px;  background-color: white;" class="col-sm-9 well well-lg" ng-show='items == 2'>
<br>

<div class="input-group col-sm-12"><input type="text" class="form-control input-lg"   uib-typeahead="domain for domain in domains | filter:$viewValue | limitTo:20"  ng-model="selected" placeholder="Search For User" />
                    <span class="input-group-btn">
                        <button class="btn btn-info btn-lg" type="button" ng-click="searchAdmin(selected)">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </span></div>
                    
    <div class="col-sm-12" ng-show="erMessage">
    <p class="text-primary text-center" style="font-size:20px;margin-top: 25px;">{{errorMsg}}</p>  
    </div>
                    
<div ng-show="adminValue">
<div class="col-sm-12">
<p class="text-left" style="margin-top: 25px !important">Permission Details for "<span style="font-family: Times New Roman; font-size: 17px !important; font-style: italic; font-weight: 700;">{{userName}}"</span></p>
</div>
<div class="col-sm-12">
<p class="text-right" style="font-family: initial; font-weight: 700;">Admin</p>
</div>
<!-- <div ng-repeat="users in adminUser"> -->
 <div dir-paginate="users in adminUser|itemsPerPage:10" current-page="currentPage" id="paginates">
<div class="row">
<div class="col-sm-11">
<p style="margin-top: 10px; margin-bottom: -7px; margin-left: 16px;">{{users.userName}}</p>

</div>
<div class="col-sm-1">
<input style="margin: 10px 25px -7px 0px;" name='check' type="checkbox" ng-model='users.adminStatus' ng-true-value="1" ng-false-value="0">
</div>
</div>
<hr class="styles">
</div>
<p><dir-pagination-controls  max-size="5" direction-links="true" boundary-links="true" ></dir-pagination-controls></p>
<div align="Left">
<button ng-model="button" class="btn btn-default" ng-click="uncheck()">Cancel</button>
<button type="button" class="btn btn-default" ng-click="saveAll()">Save</button>
</div>
</div>
</div>
<div  style="background-color:white;" class="col-sm-9 well well-lg" ng-show='items == 3'></div>
<div  style="background-color:white;" class="col-sm-9 well well-lg" ng-show='items == 4'></div>


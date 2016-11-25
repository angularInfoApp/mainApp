<div class="row">
        <div class="col-md-12">
        <!-- <hr color="gray" style="height:1px;"> -->
        <br><br>
            <div id="custom-search-input">
                <div class="input-group col-md-12">
                   <!--  <input type="text" class="form-control input-lg" ng-model="searchtag" uib-typeahead="domain for domain in typeAhead($viewValue)| filter:$viewValue | limitTo:20"" placeholder="Search" /> -->
                     <input type="text" class="form-control input-lg" ng-model="searchtag" uib-typeahead="domain for domain in typeAhead($viewValue)"  placeholder="Search" ng-keydown="$event.which === 13 && resultValidate(searchtag)"/>
                    <span class="input-group-btn">
                        <button class="btn btn-info btn-lg" type="button" ng-click="resultValidate(searchtag)" >
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </span>
                    
                </div>
            </div>
           <!--   <circle-spinner ng-show="progressing"></circle-spinner> -->
                     <wave-spinner ng-show="progressing"></wave-spinner>
        </div>
	</div>
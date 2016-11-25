
<div class="row"><div class="col-md-6"><h2>Reports</h2></div><div class="col-sm-6">
<span style="color:black !important; font-size: 15px !important; float:right !important;">Select Period:
<select class="form-control selectpicker" data-ng-change="optionCh(selectedOption)" ng-model="selectedOption" data-ng-options="x for x in names">
</select></span>
</div></div>
  <hr class="stylesBook">

<div class="row">
<div class="col-md-6">
 <fusioncharts
      width="500"
      height="400"
      type="column2d"  dataFormat="json" 
      dataSource="{{myDataSource}}" >
 </fusioncharts>
 </div>
 <div class="col-md-6">
 <fusioncharts
      width="500"
      height="400"
      type="column2d"  dataFormat="json" 
      dataSource="{{myDocViewSource}}" >
 </fusioncharts>
 </div>
</div>

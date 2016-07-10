angular.module('app.service.controller', [])
.factory("controllersService",function(){
	var data = "";
	return{
		setData : function(locData){
			data = locData;
		},
		getData : function(){
			return data;
		}
	}
})
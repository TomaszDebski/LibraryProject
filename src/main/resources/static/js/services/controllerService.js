/**
 * Created by Tomasz Dębski on 10.07.10.
 */
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
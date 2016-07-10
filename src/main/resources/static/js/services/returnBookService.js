/**
 * Created by Tomasz Dębski on 10.07.10.
 */
angular.module('app.service.returnBook',[])
.factory('returnBookService',function(){
	locData="";
	return{
		setData : function(data){
			locData = data;
		},
		getData : function(){
			return locData;
		}
	}
})
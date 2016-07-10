/**
 * Created by Tomasz Dębski on 10.07.10.
 */
angular.module('app.service.bookReader', [])
.factory("bookReaderService", ['$resource', function($resource) {
	return  $resource('/bookReader/:id', {id : "@id"},
			{ 
		'query':  {method:'GET', isArray:true},
		'update' :{method: "PUT"} 
		  })
}]);

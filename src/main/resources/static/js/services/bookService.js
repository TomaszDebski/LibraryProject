/**
 * Created by Tomasz Dębski on 10.07.10.
 */
angular.module('app.service.book', ['ngResource'])
.factory('BookService', ['$resource', function($resource) {
	return $resource('/book/:id', {id : "@id"},
		{ 
		  'update' :{method: "PUT"} 
		  })
}]);
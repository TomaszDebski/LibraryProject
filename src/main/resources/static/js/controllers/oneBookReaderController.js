/**
 * Created by Tomasz Dębski on 10.07.10.
 */
angular.module('app.controller.oneBookReader',[])
.controller('oneBookReaderController', function($scope,$location,$http,
		$rootScope,returnBookService) {
	$http.get("bookReaderBooks/" + $rootScope.user).then(function(value) {
		$scope.books = value.data;
	})
	$scope.return = function(book){
		returnBookService.setData(book);
		$location.path('oneReturnBook');
	}
})
/**
 * Created by Tomasz Dębski on 10.07.10.
 */
angular.module('app.controller.createAccount', [])
.controller("createAccountController", function($scope,$location,bookReaderService) {
	$scope.crateAccount = function(data){
		var bookReader = {};
		$scope.successCreatedUser = false;
		bookReader.readerName = data.username;
		bookReader.password = data.password;
		bookReaderService.save(bookReader,function(){
			$scope.successCreatedUser = true;
		});
	}
});
angular.module('app.controller.createAccount', [])
.controller("createAccountController", function($scope,$location,bookReaderService) {
	$scope.crateAccount = function(data){
		console.log("data " ,data);
		var bookReader = {};
		$scope.successCreatedUser = false;
		bookReader.readerName = data.username;
		bookReader.password = data.password;
		bookReaderService.save(bookReader,function(){
			console.log("successcreatedUser");
			$scope.successCreatedUser = true;
			// $location.path("/");
		});
		
	}
})
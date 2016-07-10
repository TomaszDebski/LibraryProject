/**
 * Created by Tomasz Dębski on 10.07.10.
 */
angular.module('app.controller.login', [])
.controller('loginController', function($scope,$http,$rootScope,$location,$route,$window) {
	console.log("jestem w loginie");
	var self = this;
//	console.log("self.credentials" ,self.credentials);
	$scope.login = function() {
		
//		console.log("username " + userService.getUserName);
//		console.log("dane użytkonwika " +$scope.data.credentials.username);
		var data2 = 'username=' + encodeURIComponent($scope.data.credentials.username) +
        '&password=' + encodeURIComponent($scope.data.credentials.password);

		$http.post('/login', data2, {
        headers : {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        xsrfHeaderName: 'X-XSRF-TOKEN'
        }).success(function(data, status, headers, config){
//        	if ($rootScope.authenticated) {
        		$http({
        	        url: 'findUser',
        	        method: "GET",
        	    })
        	    .then(function(response) {
        	    	if (response.data){
        	    		$rootScope.authenticated = true;
        	    		$scope.error = false;
        	    		
        	    		$window.sessionStorage.role = response.data.authorities[0].authority;
        	    		console.log("response.data.authorities[0].authority " +response.data.authorities[0].authority)
        	    		$window.sessionStorage.user = response.data.name;
        	    		$rootScope.user = $window.sessionStorage.user;
        	    		console.log("response.data.name " + response.data.name);
        	    		$rootScope.authenticated = true;
                        $window.sessionStorage.authenticated = true;
                        
//                        if ($rootScope.role == "ROLE_ADMIN"){
//        					$rootScope.isAdmin = true; 
//        				}else if($rootScope.role == "ROLE_USER"){
//        					$rootScope.isUser = true;
//        				}else{
//        					$rootScope.isAdmin = false;
//        					$rootScope.isUser = false;
//        				};
                        
        	    		$location.path("/");
        	    	}else{
//        	    		console.log("porażka");
        	    		$scope.error = true;
        	    	}
        	            // success
        	    }, 
        	    function(response) { // optional
//        	    	$rootScope.authenticated = false;
        	            // failed
        	    });
                
                
//            } else {
//                console.log("Login failed with redirect");
//                $location.path("/login");
//                $scope.error = true;
//                $rootScope.authenticated = false;
//            }
        })
	}
});
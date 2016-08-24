/**
 * Created by Tomasz Dębski on 10.07.10.
 */
angular.module('app.controller.login', [])
.controller('loginController', function($scope,$http,$rootScope,$location,$route,$window) {
	console.log("jestem w loginie");
	var self = this;
	$scope.login = function() {
		var data2 = 'username=' + encodeURIComponent($scope.data.credentials.username) +
        '&password=' + encodeURIComponent($scope.data.credentials.password);

		$http.post('/login', data2, {
        headers : {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        xsrfHeaderName: 'X-XSRF-TOKEN'
        }).success(function(data, status, headers, config){
        		$http({
        	        url: 'findUser',
        	        method: "GET",
        	    })
        	    .then(function(response) {
        	    	if (response.data){
        	    		$rootScope.authenticated = true;
        	    		$scope.error = false;
        	    		
        	    		$window.sessionStorage.role = response.data.authorities[0].authority;
        	    		$window.sessionStorage.user = response.data.name;
        	    		$rootScope.user = $window.sessionStorage.user;
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
        	    		$scope.error = true;
        	    	}
        	    },
        	    function(response) {
        	    });
        })
	}
});
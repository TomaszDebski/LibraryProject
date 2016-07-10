/**
 * Created by Tomasz Dębski on 10.07.10.
 */
angular.module('app.run', [])
.run(function($rootScope, $http, $location, $route,$window){
	$rootScope.$on('$routeChangeStart', function(event, next, current) {
		$http({
	        url: 'findUser',
	        method: "GET",
	    })
	    .then(function(response) {
	    	if (response.data){
	    		if ($window.sessionStorage.user == ""){
	    			if (next.templateUrl != "createNewAccount.html"){
	    				$location.path( "/login" );
	    			}
	    		}else{
	    			$rootScope.user = $window.sessionStorage.user;
	    			$rootScope.authenticated = $window.sessionStorage.authenticated;
	    			if ($window.sessionStorage.role == "ROLE_ADMIN"){
	    				$rootScope.isAdmin = true; 
	    			}else if($window.sessionStorage.role == "ROLE_USER"){
	    				$rootScope.isUser = true;
	    			}else{
	    				$rootScope.isAdmin = false;
	    				$rootScope.isUser = false;
	    			};
	    		}
	    	
	    	}else{
	    		$rootScope.authenticated = false;
				$rootScope.user = "";
				$rootScope.role = "";
				$rootScope.isAdmin = false;
				$rootScope.isUser = false;
				$window.sessionStorage.user = "";
				$window.sessionStorage.authenticated = false;
				$window.sessionStorage.role = "";
				$location.path( "/login");
	    	}
		})
	})
});
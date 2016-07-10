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
	    	}
	})
	    
	
		
		
//			$http.get('findUser').then(function(response) {
//				if (response.data.name) {
////					console.log("authorities " , response.data.authorities[0].authority);
////					console.log("response.data.name " , response.data);
////					$rootScope.authenticated = true;
//					$window.sessionStorage.currentUser = response.data.name;
//					$window.sessionStorage.role=response.data.authorities[0].authority;
////					$rootScope.user = response.data.name;
////					$rootScope.role = response.data.authorities[0].authority;
////					console.log("znaleziono użytkownika z rolą " + response.data.authorities[0].authority);
////					$rootScope.authenticated = true;
//					$window.sessionStorage.authenticated = true;
//				} else {
//					$window.sessionStorage.authenticated = false;
////					$rootScope.authenticated = false;
//				}
//			}, function() {
//				$window.sessionStorage.authenticated = false;
////				$rootScope.authenticated = false;
//			});
//			console.log("$window.sessionStorage.authenticated " + $window.sessionStorage.authenticated);
//			if ($window.sessionStorage.authenticated) {
//				
//				console.log("zalogowany");
//				if ($rootScope.role == "ROLE_ADMIN"){
//					$rootScope.isAdmin = true; 
//				}else if($rootScope.role == "ROLE_USER"){
//					$rootScope.isUser = true;
//				}else{
//					$rootScope.isAdmin = false;
//					$rootScope.isUser = false;
//				};
//				console.log("jestem w home authenticated " + $rootScope.role + " isAdmin " + $rootScope.isAdmin);
//			}else{
//	//			console.log("nie zalogowany");
//				$rootScope.isAdmin = false;
//				if (next.templateUrl != "createNewAccount.html"){
//					$location.path( "/login" );
//	//				console.log("$route.current " , next.templateUrl);
//				}
//			}
//		}
		
	})
});
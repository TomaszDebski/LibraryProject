/**
 * Created by Tomasz Dębski on 10.07.10.
 */
angular.module('app.controller.logout', []).controller(
		'logoutController',
		function($scope, $http, $rootScope, $location, $window) {
			console.log("jestem w logout");
			$http.post("/logout").success(
					function(data, status, headers, config) {
//						console.log("udało się wylogować")
					}).error(function(data, status, headers, config) {
//				console.log("nie wylogowano");
			})
			$rootScope.authenticated = false;
			$rootScope.user = "";
			$rootScope.role = "";
			$rootScope.isAdmin = false;
			$rootScope.isUser = false;
			$window.sessionStorage.user = "";
			$window.sessionStorage.authenticated = false;
			$window.sessionStorage.role = "";
			$location.path("/");
		});
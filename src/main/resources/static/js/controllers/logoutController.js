/**
 * Created by Tomasz Dębski on 10.07.10.
 */
angular.module('app.controller.logout', []).controller(
		'logoutController',
		function($scope, $http, $rootScope, $location, $window) {
			$http.post("/logout").success(
					function(data, status, headers, config) {
					}).error(function(data, status, headers, config) {
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
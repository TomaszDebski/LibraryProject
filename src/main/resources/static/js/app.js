/**
 * Created by Tomasz Dębski on 10.07.10.
 */
angular.module('app',
		[ 
		  'ngRoute',
		  'ngResource',
		  'app.config',
		  'app.run',
		  'app.controller.navigation',
		  // 'app.controller.home',
		  'app.controller.book',
		  'app.controller.bookReader',
		  'app.controller.assignBook',
		  'app.controller.oneBookReader',
		  'app.controller.returnBook',
		  'app.controller.login',
		  'app.controller.logout',
		  'app.controller.createAccount',
		  'app.service.book',
		  'app.service.bookReader',
		  'app.service.returnBook',
		  'app.service.controller',
		  'app.directive.usernameAvailable'
		  ]);
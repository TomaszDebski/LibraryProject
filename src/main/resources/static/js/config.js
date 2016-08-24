/**
 * Created by Tomasz Dębski on 10.07.10.
 */
angular.module('app.config', [])
.config(function($routeProvider, $httpProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'home.html',
		controller : 'navigationController',
		controllerAs: 'controller'
	})
	.when('/login', {
		templateUrl : 'login.html',
		controller : 'loginController',
		controllerAs: 'controller'
	})
	.when('/logout', {
		templateUrl : 'logout.html',
		controller : 'logoutController',
		controllerAs: 'controller'
	})
	.when('/createAccount', {
		templateUrl : 'createNewAccount.html',
		controller : 'createAccountController',
		controllerAs: 'controller'
	})
	.when('/showAllBooks', {
		templateUrl : 'books.html',
		controller : 'booksController',
		controllerAs: 'controller'
	})
	.when('/showBookReader', {
		templateUrl : 'bookReaders.html',
		controller : 'booksReaderController',
		controllerAs: 'controller'
	}) 
	.when('/assignBooksPage', {
		templateUrl : 'assingBooks.html',
		controller : 'assignBooksController',
		controllerAs: 'controller'
	})
	.when('/oneBookReader', {
		templateUrl : 'bookReaderSite.html',
		controller : 'oneBookReaderController',
		controllerAs: 'controller'
	})
	.when('/oneReturnBook', {
		templateUrl : 'returnBook.html',
		controller : 'returnBookController',
		controllerAs: 'controller'
	})
	.otherwise('/');

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

})
angular.module('bizmonApp', [ 'bizmonApp.services', 'bizmonApp.directives' ])
		.config([ '$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
			$routeProvider.when('/projects/:projectId', {
				templateUrl : 'template/project-detail.jsp',
				controller : ProjectCtrl
			});
			$routeProvider.otherwise({
				templateUrl : 'template/default-detail.jsp'
			});
//			$locationProvider.html5Mode(true);
		} ]);
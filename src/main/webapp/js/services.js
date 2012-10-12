angular.module('bizmonApp.services', [ 'ngResource' ]).factory(
		'projectService', function($resource) {
			var service = $resource('rest/projects/:projectId', {}, {});
			return service;
		}).factory('scopeService', function($resource) {
			var service = $resource('rest/projects/:projectId/scopes/:scopeId', {}, {});
			return service;			
		});
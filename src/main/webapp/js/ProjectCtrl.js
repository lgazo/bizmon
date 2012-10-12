function ProjectCtrl($scope, projectService, scopeService, $routeParams) {
	$scope.project = projectService.get({projectId: $routeParams.projectId});
	$scope.filter = {
		mergeScopes: true
	};
	$scope.scopePeriods = [
		{id:0, name: 'last day'},
		{id:1, name: 'last week'}
	];
	
	$scope.projectScopeViews = {};
	$scope.activeIssueState = {};
	
//	function getNewIndex
	
	$scope.reloadScopes = function() {
		$scope.projectScopes = scopeService.query({projectId: $routeParams.projectId, merge: $scope.filter.mergeScopes});	
	};
	
	$scope.planNewScope = function(prjScope) {
		var newScope = prjScope ? prjScope: {
				id: -1,
				issueStates: [],
				scopeClassification: 'initialPlan',
				version: 1,
		};
		$scope.projectScopes.push(newScope);
		$scope.editScope(newScope.id);
	};
	
	$scope.editScope = function(scopeId) {
		if(!$scope.projectScopeViews[scopeId]) {
			$scope.projectScopeViews[scopeId] = {};
		}
		$scope.projectScopeViews[scopeId].edit = true;
	};
	
	$scope.duplicateScope = function(scope) {
		var dup = angular.copy(scope);
		dup.id = -1;
		dup.version = 1;
		$scope.planNewScope(dup);
	};
	
	$scope.deleteScope = function(scope) {
		delete $scope.projectScopeViews[scope.id];
		for(var i = 0; i < $scope.projectScopes.length; i++) {
			var origScope = $scope.projectScopes[i];
			if(origScope.id == scope.id) {
				$scope.projectScopes.splice(i, 1);
				break;
			}
		}
	};
	
	$scope.closeScope = function(scope) {
		$scope.projectScopeViews[scope.id].edit = false;
		$scope.activeIssueState.edit = false;
	};
	
	$scope.toggleOperation = function(issueState) {
		if('INCLUDE' == issueState.operation) {
			issueState.operation = 'EXCLUDE';
		} else {
			issueState.operation = 'INCLUDE';
		}
	};
	
	$scope.deleteIssue = function(prjScope, issueState) {
		for(var i = 0; i < prjScope.issueStates.length; i++) {
			var state = prjScope.issueStates[i];
			if(state.uuid == issueState.uuid) {
				prjScope.issueStates.splice(i, 1);
				break;
			}
		}
	};
	
	$scope.addIssue = function(scope) {
		$scope.activeIssueState = {operation: 'INCLUDE'};
		scope.issueStates.push($scope.activeIssueState);
		$scope.activeIssueState.edit = true;
	};
	
	$scope.editIssue = function(issueState) {
		$scope.activeIssueState = issueState;
		$scope.activeIssueState.edit = true;
	};
	
	$scope.closeIssueState = function() {
		$scope.activeIssueState.edit = false;
	};
	
	$scope.reloadScopes();
}
ProjectCtrl.$inject = ['$scope', 'projectService', 'scopeService', '$routeParams'];
function BizmonCtrl($scope, projectService) {
	$scope.projects = projectService.query();
}
BizmonCtrl.$inject = ["$scope", "projectService"];
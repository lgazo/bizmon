<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="row-fluid">
	<div class="hero-unit span9">
		<h1>Project {{project.name}}</h1>
	</div>
	<div class="span3">
		<h2>Filter</h2>
		<p>
			<input type="checkbox" name="mergeScopes" 
				ng-model="filter.mergeScopes"
				ng-change="reloadScopes()">Merge scopes</input>
			<select ng-model="filter.scopeForPeriod" ng-options="period.name for period in scopePeriods">
				<option value="">select scope for last period</option>
			</select>
		</p>
	</div>
</div>

<div class="row-fluid">
	<a class="btn btn-primary" ng-click="planNewScope()">Plan new scope</a>
	<a class="btn" ng-click="saveProject()">Save project</a>
</div>
<div class="row-fluid">
	<table class="table table-striped span9">
		<tbody>
			<tr ng-repeat="prjScope in projectScopes">
				<td>
					<table class="table table-condensed" ng-class="'scope-level-' + prjScope.version">
						<tbody>
							<tr>
								<td class="project-scope">
									<span ng-hide="projectScopeViews[prjScope.id].edit">
										<a ng-click="editScope(prjScope.id)">Scope <strong>{{prjScope.name}}</strong></a>
										<span>( {{prjScope.accepted | date:'medium'}} )</span>
										<span>, {{prjScope.classification.name}}</span>
									</span>
									<span ng-show="projectScopeViews[prjScope.id].edit">
										<input type="text" ng-model="prjScope.name" placeholder="scope name"></input>
									</span>
								</td>
							</tr>
							<tr ng-repeat="issueState in prjScope.issueStates">
								<td ng-class="'operation-' + issueState.operation"><a ng-click="editIssue(issueState)">{{issueState.uuid}}</a></td>
								<td>{{issueState.reason}}</td>
								<td>
									<span class="btn-group" ng-show="projectScopeViews[prjScope.id].edit">
										<a class="btn btn-primary" ng-click="toggleOperation(issueState)"><span ng-bind="issueState.operation"></span></a>
										<a class="btn btn-danger" ng-click="deleteIssue(prjScope, issueState)">Delete</a>
									</span>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="btn-group" ng-show="projectScopeViews[prjScope.id].edit">
						<a class="btn" ng-click="addIssue(prjScope)">Add issue</a>
						<a class="btn" ng-click="duplicateScope(prjScope)">Duplicate</a>
						<a class="btn" ng-click="addToOffer(prjScope)">Add to offer</a>
						<a class="btn btn-danger" ng-click="deleteScope(prjScope)">Delete</a>
						<a class="btn btn-primary" ng-click="closeScope(prjScope)">Close</a>
					</div>
					
				</td>
			</tr>
		</tbody>		
	</table>
	<div class="span3" ng-show="activeIssueState.edit">
		<h2>Issue state</h2>
		<table class="table table-striped">
			<tbody>
				<tr>
					<td>uuid</td>
					<td><input type="text" ng-model="activeIssueState.uuid" placeholder="enter uuid"/></td>
				</tr>
				<tr>
					<td>reason</td>
					<td><input type="textarea" ng-model="activeIssueState.reason" placeholder="optional reason why you are creating the issue" size="4"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="btn-group">
							<a ng-click="closeIssueState()" class="btn">Close</a>
						</div>
					</td>
				</tr>			
			</tbody>
		</table>
	</div>
</div>

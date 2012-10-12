/**
 * 
 */
package sk.seges.bizmon.server.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;

import sk.seges.bizmon.shared.domain.IssueState;
import sk.seges.bizmon.shared.domain.Scope;
import sk.seges.bizmon.shared.domain.ScopeOperation;


/**
 * @author eldzi
 */
public class ScopeResource {
	
	private String projectId;
	
	public ScopeResource(String projectId) {
		this.projectId = projectId;
	}

	@GET
	public Collection<Scope> scopes(@QueryParam("toDate") Date date, @QueryParam("merge") @DefaultValue("true") Boolean merge) {
		List<Scope> scopes = new ArrayList<Scope>();
		Set<IssueState> states;
		IssueState state;
		
		Scope scope;
		scope = new Scope();
		scope.setClassification(ResourceConstants.classifications.get("planned"));
		scope.setId(projectId + "-scope-1");
		scope.setAccepted(new Date());
		scope.setName("1.0.0");
		scope.setVersion(1);
		
		scope.setIssueStates(states = new HashSet<IssueState>());
		for(int i = 0; i < 3; i++) {
			state = new IssueState();
			state.setOperation(ScopeOperation.INCLUDE);
			state.setUuid(projectId + "-mantis-issue-" + i);
			states.add(state);
		}
		scope.setIssueStates(states);
		scopes.add(scope);
		
		scope = new Scope();
		scope.setClassification(ResourceConstants.classifications.get("changedInProgress"));
		scope.setId(projectId + "-scope-1.1");
		scope.setAccepted(new Date());
		scope.setName("1.0.0");
		scope.setVersion(2);
		
		scope.setIssueStates(states = new HashSet<IssueState>());
		for(int i = 0; i < 2; i++) {
			state = new IssueState();
			state.setOperation(ScopeOperation.EXCLUDE);
			state.setUuid(projectId + "-mantis-issue-" + i);
			states.add(state);
		}
		scope.setIssueStates(states);
		scopes.add(scope);

		if(merge) {
			return mergeScopes(scopes);
		}
		
		return scopes;
	}

	private Collection<Scope> mergeScopes(List<Scope> scopes) {
		Map<String, Scope> groups = new HashMap<String, Scope>();

		for(Scope scope : scopes) {
			Scope aggregated = groups.get(scope.getName());
			Set<IssueState> states;
			if(aggregated == null) {
				aggregated = new Scope();
				aggregated.setName(scope.getName());
				
				states = new LinkedHashSet<IssueState>();
				aggregated.setIssueStates(states);
				groups.put(scope.getName(), aggregated);
			} else {
				states = aggregated.getIssueStates();
			}
			
			scope.getIssueStates().addAll(states);
			aggregated.setIssueStates(scope.getIssueStates());
		}
		
		return groups.values();
	}
}

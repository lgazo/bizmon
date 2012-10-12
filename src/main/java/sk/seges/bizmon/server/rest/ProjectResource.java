/**
 * 
 */
package sk.seges.bizmon.server.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sk.seges.bizmon.shared.domain.IssueState;
import sk.seges.bizmon.shared.domain.Project;
import sk.seges.bizmon.shared.domain.Scope;
import sk.seges.bizmon.shared.domain.ScopeOperation;

/**
 * @author ladislav.gazo
 */
@Path("/projects")
public class ProjectResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Project> getProjects() {
		List<Project> projects = new ArrayList<Project>();
		projects.add(get("1"));
		projects.add(get("2"));
		return projects;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Project get(@PathParam("id") String id) {
		Project project = new Project();
		project.setId(id);
		project.setName("project " + id);

		List<Scope> scopes = new ArrayList<Scope>();
		Scope scope;
		scope = new Scope();
		scope.setClassification(ResourceConstants.classifications.get("planned"));
		scope.setId(id + "-scope-1");
		scope.setAccepted(new Date());
		scope.setName("1.0.0");
		scope.setVersion(1);

		Set<IssueState> issueStates = new HashSet<IssueState>();
		IssueState issueState;
		for (int i = 0; i < 5; i++) {
			issueState = new IssueState();
			issueState.setUuid(id + "-mantis-issue-" + i);
			issueState.setOperation(ScopeOperation.INCLUDE);
			issueStates.add(issueState);
		}
		scope.setIssueStates(issueStates);
		scopes.add(scope);
		project.setScopes(scopes);

		return project;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Project create(Project newProject) {
		newProject.setName(newProject.getName() + "aaa");
		System.out.println(newProject);
		return newProject;
	}

	@Path("{projectId}/scopes")
	public ScopeResource scopes(@PathParam("projectId") String projectId) {
		return new ScopeResource(projectId);
	}
}

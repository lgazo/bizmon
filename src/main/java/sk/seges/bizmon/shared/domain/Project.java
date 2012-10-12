package sk.seges.bizmon.shared.domain;

import java.util.List;

public class Project {
	private String id;
	private String name;
	private List<Scope> scopes;
	private EntityState state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Scope> getScopes() {
		return scopes;
	}

	public void setScopes(List<Scope> scopes) {
		this.scopes = scopes;
	}

	public EntityState getState() {
		return state;
	}

	public void setState(EntityState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", scopes=" + scopes
				+ ", state=" + state + "]";
	}

}

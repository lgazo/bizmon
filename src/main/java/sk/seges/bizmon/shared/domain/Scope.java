/**
 * 
 */
package sk.seges.bizmon.shared.domain;

import java.util.Date;
import java.util.Set;

/**
 * @author eldzi
 */
public class Scope {
	private String id;
	private String name;
	private Date accepted;
	private Set<IssueState> issueStates;
	private ScopeClassification classification;
	private Integer version;

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

	public Date getAccepted() {
		return accepted;
	}

	public void setAccepted(Date accepted) {
		this.accepted = accepted;
	}

	public Set<IssueState> getIssueStates() {
		return issueStates;
	}

	public void setIssueStates(Set<IssueState> issueStates) {
		this.issueStates = issueStates;
	}

	public ScopeClassification getClassification() {
		return classification;
	}

	public void setClassification(ScopeClassification classification) {
		this.classification = classification;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Scope [id=" + id + ", name=" + name + ", accepted=" + accepted
				+ ", issueStates=" + issueStates + ", classification=" + classification
				+ ", version=" + version + "]";
	}

}

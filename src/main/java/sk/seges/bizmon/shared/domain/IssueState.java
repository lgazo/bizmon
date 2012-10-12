/**
 * 
 */
package sk.seges.bizmon.shared.domain;

import java.util.Set;

/**
 * @author eldzi
 * 
 */
public class IssueState {
	private String uuid;
	private ScopeOperation operation;
	/** optional reason why the operation happened */
	private String reason;

	private Set<TrackerIssue> issues;

	private String summary;
	private Double amount;
	private Double price;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public ScopeOperation getOperation() {
		return operation;
	}

	public void setOperation(ScopeOperation operation) {
		this.operation = operation;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Set<TrackerIssue> getIssues() {
		return issues;
	}

	public void setIssues(Set<TrackerIssue> issues) {
		this.issues = issues;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IssueState other = (IssueState) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IssueState [uuid=" + uuid + ", operation=" + operation
				+ ", reason=" + reason + ", issues=" + issues + ", summary="
				+ summary + ", amount=" + amount + ", price=" + price + "]";
	}

}

/**
 * 
 */
package sk.seges.bizmon.shared.domain;

/**
 * @author eldzi
 */
public class TrackerIssue {
	private String id;

	/** e.g. manual, mantis, jira,... */
	private String trackerType;
	private String trackerId;

	private Double estimation;
	private Double duration;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrackerType() {
		return trackerType;
	}

	public void setTrackerType(String trackerType) {
		this.trackerType = trackerType;
	}

	public String getTrackerId() {
		return trackerId;
	}

	public void setTrackerId(String trackerId) {
		this.trackerId = trackerId;
	}

	public Double getEstimation() {
		return estimation;
	}

	public void setEstimation(Double estimation) {
		this.estimation = estimation;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "TrackerIssue [id=" + id + ", trackerType=" + trackerType
				+ ", trackerId=" + trackerId + ", estimation=" + estimation
				+ ", duration=" + duration + "]";
	}

}

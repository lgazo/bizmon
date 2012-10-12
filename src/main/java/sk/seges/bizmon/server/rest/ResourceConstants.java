/**
 * 
 */
package sk.seges.bizmon.server.rest;

import java.util.HashMap;
import java.util.Map;

import sk.seges.bizmon.shared.domain.ScopeClassification;

/**
 * @author eldzi
 *
 */
public class ResourceConstants {
	public static Map<String, ScopeClassification> classifications = new HashMap<String, ScopeClassification>();

	public static String TRACKER_MANUAL = "manual";
	public static String TRACKER_MANTIS = "mantis";
	public static String TRACKER_JIRA = "jira";
	
	static {
		classifications.put("planned", new ScopeClassification("planned",
				"Planned with customer"));
		classifications.put("changedInProgress", new ScopeClassification(
				"changedInProgress",
				"Customer did a change while version was in progress"));
		classifications
				.put("invoiced",
						new ScopeClassification(
								"invoiced",
								"Used when merging of scopes does not lead to a desirable state for invoicing to the customer"));
	}

}

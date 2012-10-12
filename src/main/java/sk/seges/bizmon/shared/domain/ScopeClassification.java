/**
 * 
 */
package sk.seges.bizmon.shared.domain;

/**
 * @author eldzi
 */
public class ScopeClassification {
	private String id;
	private String name;

	public ScopeClassification() {
	}
	
	public ScopeClassification(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "ScopeClassification [id=" + id + ", name=" + name + "]";
	}

}

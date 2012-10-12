/**
 * 
 */
package sk.seges.bizmon.shared.domain;

/**
 * @author eldzi
 */
public class EntityState {
	private String id;
	private String name;

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
		return "EntityState [id=" + id + ", name=" + name + "]";
	}

}

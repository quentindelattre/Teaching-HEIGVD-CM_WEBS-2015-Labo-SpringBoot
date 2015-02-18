package ch.heigvd.ptl.sc.to;

import java.util.List;

public class IssueTypeTO {
	private String id;
	private String name;
	private String description;
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}

package com.example.springthymeredis.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

// FYI: @RedisHash marks Objects as aggregate roots to be stored in a Redis hash
@RedisHash("project")
public class Project implements Serializable{
	// FYI: @Id is Spring Data JPA. It indicates the field below is the PK
	@Id
	private String 	projectSymbol;
	private String 	projectName;  // TODO: @Id 2, or getBySecondId
	private int 	projectDecimals;
	private int 	projectTotalSupply;
	
	// id, pk
	// projectSymbol
	public String getProjectSymbol() {
		return projectSymbol;
	}
	public void setProjectSymbol(String projectSymbol) {
		this.projectSymbol = projectSymbol;
	}
	// projectName
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	// projectDecimals
	public float getProjectDecimals() {
		return projectDecimals;
	}
	public void setProjectDecimals(int projectDecimals) {
		this.projectDecimals = projectDecimals;
	}
	// projectTotalSupply
	public int getProjectTotalSupply() {
		return projectTotalSupply;
	}
	public void setProjectTotalSupply(int projectTotalSupply) {
		this.projectTotalSupply = projectTotalSupply;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("projectSymbol=").
				append(projectSymbol).
				append(", projectName=").
				append(projectName).
				append(", projectDecimals=").
				append(projectDecimals).
				append(", projectTotalSupply=").
				append(projectTotalSupply).
				append("]");
		return builder.toString();
	}
}

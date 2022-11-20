package com.example.springthymeredis.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("project")
public class Project implements Serializable{
	@Id
	private String 	projectId;
	private String 	projectName;
	private String 	projectSymbol;
	private float 	projectDecimals;
	private int 	projectTotalSupply;

	// id
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	// projectName
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	// projectSymbol
	public String getProjectSymbol() {
		return projectSymbol;
	}
	public void setProjectSymbol(String projectSymbol) {
		this.projectSymbol = projectSymbol;
	}
	// projectDecimals
	public float getProjectDecimals() {
		return projectDecimals;
	}
	public void setProjectDecimals(float projectDecimals) {
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
		builder.append("Project [projectId=").
				append(projectId).
				append(", projectName=").
				append(projectName).
				append(", projectSymbol=").
				append(projectSymbol).
				append(", projectDecimals=").
				append(projectDecimals).
				append(", projectTotalSupply=").
				append(projectTotalSupply).
				append("]");
		return builder.toString();
	}
}
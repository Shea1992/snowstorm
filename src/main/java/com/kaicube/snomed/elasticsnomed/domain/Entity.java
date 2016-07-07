package com.kaicube.snomed.elasticsnomed.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kaicube.snomed.elasticsnomed.services.PathUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

public class Entity {

	@Id
	@Field(index = FieldIndex.not_analyzed)
	private String internalId;

	@Field(type = FieldType.Date, index = FieldIndex.not_analyzed)
	private Date commit;

	@Field(type = FieldType.String, index = FieldIndex.not_analyzed)
	private String path;

	public String getInternalId() {
		return internalId;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}

	public Date getCommit() {
		return commit;
	}

	public void setCommit(Date commit) {
		this.commit = commit;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = PathUtil.flaten(path);
	}

	@JsonIgnore
	public String getFatPath() {
		return PathUtil.fatten(path);
	}
}
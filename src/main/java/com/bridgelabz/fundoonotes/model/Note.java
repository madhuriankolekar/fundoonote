package com.bridgelabz.fundoonotes.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
@Entity
@Table(name="notes")
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isTrashed;
	
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isPinned;
	
	@Column
	private String color;
	
	@Column
	private LocalDateTime remaindMe;
	
	@Column
	private LocalDateTime createdStamp;
	
	@Column
	private LocalDateTime updatedStamp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isTrashed() {
		return isTrashed;
	}

	public void setTrashed(boolean isTrashed) {
		this.isTrashed = isTrashed;
	}

	public boolean isPinned() {
		return isPinned;
	}

	public void setPinned(boolean isPinned) {
		this.isPinned = isPinned;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public LocalDateTime getRemaindMe() {
		return remaindMe;
	}

	public void setRemaindMe(LocalDateTime remaindMe) {
		this.remaindMe = remaindMe;
	}

	public LocalDateTime getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(LocalDateTime createdStamp) {
		this.createdStamp = createdStamp;
	}

	public LocalDateTime getUpdatedStamp() {
		return updatedStamp;
	}

	public void setUpdatedStamp(LocalDateTime updatedStamp) {
		this.updatedStamp = updatedStamp;
	}


}

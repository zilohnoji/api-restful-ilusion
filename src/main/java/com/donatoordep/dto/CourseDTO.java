package com.donatoordep.dto;

import com.donatoordep.entities.Course;

public class CourseDTO {
	private String name;
	private String id;
	private String description;
	private String urlImage;

	public CourseDTO() {
	}

	public CourseDTO(Course course) {
		this.name = course.getName();
		this.description = course.getDescription();
		this.urlImage = course.getUrlImage();
		this.id = course.getId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

}

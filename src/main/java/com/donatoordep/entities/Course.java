package com.donatoordep.entities;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	String id;
	String name;
	String description;
	String UrlImage;

	public Course() {
	}

	public Course(String id, String name, String description, String urlImage) {
		this.id = id;
		this.name = name;
		this.description = description;
		UrlImage = urlImage;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImage() {
		return UrlImage;
	}

	public void setUrlImage(String urlImage) {
		UrlImage = urlImage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(UrlImage, description, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(UrlImage, other.UrlImage) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

}

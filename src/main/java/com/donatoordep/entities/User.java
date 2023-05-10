package com.donatoordep.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

@Document(collection = "Users")
public class User implements Serializable {

	@Id
	private String id;
	private String name;
	@Indexed(unique = true)
	private String email;
	@Nullable
	@Indexed(unique = true)
	private String cellphone;
	@DBRef(lazy = true)
	private List<Course> courses;
	private LocalDateTime dateRegister;

	private static final long serialVersionUID = 1L;

	public User() {
	}

	public List<Course> getCourses() {
		return courses;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void setDateRegister(LocalDateTime dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDateRegister() {
		return dateRegister;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cellphone, courses, dateRegister, email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cellphone, other.cellphone) && Objects.equals(courses, other.courses)
				&& Objects.equals(dateRegister, other.dateRegister) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

}

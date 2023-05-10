package com.donatoordep.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.donatoordep.entities.Course;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "dateRegister", "name", "email", "cellphone", "courses" })
public class UserDTO extends RepresentationModel<UserDTO> implements Serializable {

	private String id;
	private String name;
	private String email;
	private String cellphone;
	private List<Course> courses;
	private LocalDateTime dateRegister = LocalDateTime.now();

	private static final long serialVersionUID = 1L;

	public UserDTO() {
	}

	public UserDTO(String name, String email, String cellphone) {
		this.name = name;
		this.email = email;
		this.cellphone = cellphone;
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cellphone, courses, dateRegister, email, id, name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(cellphone, other.cellphone) && Objects.equals(courses, other.courses)
				&& Objects.equals(dateRegister, other.dateRegister) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

}

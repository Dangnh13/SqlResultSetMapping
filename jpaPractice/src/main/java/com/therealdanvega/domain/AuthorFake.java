package com.therealdanvega.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.therealdanvega.util.NativeQueryResultColumn;
import com.therealdanvega.util.NativeQueryResultEntity;

@NativeQueryResultEntity
public class AuthorFake implements Serializable {

	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private Long id;

	@NativeQueryResultColumn(index = 1)
	private String firstName;

	@NativeQueryResultColumn(index = 3)
	private String lastName;

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public AuthorFake(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AuthorFake() {
	}

	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
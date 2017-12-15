package com.therealdanvega.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Transient;

@Entity
@SqlResultSetMapping(
        name = "AuthorDTOMappe2r",
        classes = 
           @ConstructorResult(targetClass=Author2.class, columns = { 
        		   @ColumnResult(name="first_name", type=String.class),
        		   @ColumnResult(name="last_name", type=String.class),
        		   @ColumnResult(name="teaser", type=String.class)
})  
)
@NamedNativeQuery(
        name = "nativeSQL2",
        query = "select  a.first_name, a.last_name, p.teaser from author a inner join post p on a.id=p.author_id",
        resultSetMapping = "AuthorDTOMappe2r"
)
public class Author2 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String firstName;

	private String lastName;

	private String teaser;

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public Author2() {
	}

	public Author2(String firstName, String lastName, String teaser) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.teaser = teaser;
	}

	public Author2(Long id, String firstName, String lastName, String teaser) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.teaser = teaser;
	}

	public Author2(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author2(Long id) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
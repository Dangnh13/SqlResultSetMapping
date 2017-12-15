package com.therealdanvega.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@Entity(name = "author")
@SqlResultSetMapping(
        name = "AuthorDTOMapper",
        classes = 
           @ConstructorResult(targetClass=AuthorDto.class, columns = { 
        		   @ColumnResult(name="id", type=Long.class),
        		   @ColumnResult(name="first_name", type=String.class),
        		   @ColumnResult(name="last_name", type=String.class),
        		   @ColumnResult(name="teaser", type=String.class)
})  
)
@NamedNativeQuery(
        name = "nativeSQL",
        query = "select a.id, a.first_name, a.last_name, p.teaser from author a inner join post p on a.id=p.author_id",
        resultSetMapping = "AuthorDTOMapper"
)
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
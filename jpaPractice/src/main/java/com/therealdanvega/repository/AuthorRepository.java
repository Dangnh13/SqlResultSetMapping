package com.therealdanvega.repository;

import java.util.List;

import javax.persistence.SqlResultSetMapping;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import com.therealdanvega.domain.Author;
import com.therealdanvega.domain.AuthorDto;
import com.therealdanvega.domain.AuthorFake;


public interface AuthorRepository extends CrudRepository<Author, Long> {

	@Query(value = "select a.* from author a where a.last_name  = ?1", nativeQuery = true)
	public Iterable<Author> findByLastName(String sdfsdf);

	public Iterable<Author> findByLastNameOrFirstName(String lastName, String firstName);

	@Query("SELECT new com.therealdanvega.domain.AuthorFake(u.id, u.firstName, u.lastName) FROM author u ")
	List<AuthorFake> retrieveUsernameAsDTO();

	Page<Author> findAll(Pageable  pageable);
}

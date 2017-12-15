package com.therealdanvega.repository;

import java.util.List;

import javax.persistence.SqlResultSetMapping;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import com.therealdanvega.domain.Author;
import com.therealdanvega.domain.Author2;
import com.therealdanvega.domain.AuthorDto;
import com.therealdanvega.domain.AuthorFake;


public interface Author2Repository  {

	public List<Author2> getAllByNativeSql2();

}

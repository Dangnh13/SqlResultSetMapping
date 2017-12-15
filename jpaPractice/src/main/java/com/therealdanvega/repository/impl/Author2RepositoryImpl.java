package com.therealdanvega.repository.impl;

import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;

import org.springframework.stereotype.Repository;

import com.therealdanvega.domain.Author2;
import com.therealdanvega.domain.AuthorDto;
import com.therealdanvega.domain.AuthorFake;
import com.therealdanvega.repository.Author2Repository;
import com.therealdanvega.repository.IR001Repository;
import com.therealdanvega.util.NativeQueryResultsMapper;

@Repository
public class Author2RepositoryImpl implements Author2Repository {

	@PersistenceContext
	public EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Author2> getAllByNativeSql2() {
		 return em.createNamedQuery("nativeSQL2").setFirstResult(0).setMaxResults(2).getResultList();
	}
}

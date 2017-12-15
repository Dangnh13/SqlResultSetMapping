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

import com.therealdanvega.domain.AuthorDto;
import com.therealdanvega.domain.AuthorFake;
import com.therealdanvega.repository.IR001Repository;
import com.therealdanvega.util.NativeQueryResultsMapper;

@Repository
/*@SqlResultSetMapping(
        name = "mapeamentoDeQuadrantes",
        classes = 
           @ConstructorResult(targetClass=AuthorDto.class, columns = { 
        		   @ColumnResult(name="id"),
        		   
        		   @ColumnResult(name="first_name"),
        		   @ColumnResult(name="last_name")
})  
)*/
/*@NamedNativeQuery(
        name = "haidang",
        query = "select id, first_name, last_name from author",
        resultSetMapping = "mapeamentoDeQuadrantes"
)*/
public class IR001RepositoryImpl implements IR001Repository {

	@PersistenceContext
	public EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<AuthorFake> getAllByNativeSql() {
		String sql = "select id, first_name, last_name from author";
		Query q = em.createNamedQuery(sql.toString());
		List<AuthorFake> results = NativeQueryResultsMapper.map(q.getResultList(), AuthorFake.class);
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<AuthorDto> getAllByNativeSql2() {
		/*String sql = "select a.id, a.first_name, a.last_name, p.teaser from author a inner join post p on a.id=p.author_id";
		Query q = em.createNativeQuery(sql, "mapeamentoDeQuadrantes");
		List<AuthorDto> results = q.getResultList();
		return results;*/
		 return em.createNamedQuery("nativeSQL").getResultList();
	}
}

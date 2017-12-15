package com.therealdanvega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.therealdanvega.domain.Author;
import com.therealdanvega.domain.Author2;
import com.therealdanvega.domain.AuthorDto;
import com.therealdanvega.domain.AuthorFake;
import com.therealdanvega.repository.Author2Repository;
import com.therealdanvega.repository.AuthorRepository;
import com.therealdanvega.repository.IR001Repository;

@Service
public class AuthorService {

	@Autowired
	private IR001Repository iR001Repository;
	

	@Autowired
	private Author2Repository author2Repository;
	
	@Autowired
	private AuthorRepository authorRepository;

	public Iterable<Author> list() {
		
		return authorRepository.findAll();
	}

	public Author findById(Long id) {
		return authorRepository.findOne(id);
	}

	public Iterable<Author> findByIds(List<Long> ids) {
		return authorRepository.findAll(ids);
	}

	public Author saveEntity(Author author) {
		return authorRepository.save(author);
	}

	public Iterable<Author> findByLastName(String lastName) {
		return authorRepository.findByLastName(lastName);
	}

	public Iterable<Author> findByLastnameOrFirstname(String lastName, String firstName) {
		return authorRepository.findByLastNameOrFirstName(lastName, firstName);
	}

	public List<AuthorFake> getAuthorFake() {
		return authorRepository.retrieveUsernameAsDTO();
	}

	public List<AuthorFake> customNativeQuery() {
		return iR001Repository.getAllByNativeSql();
	}
	public List<AuthorDto> retrieveUsernameAsDTO2() {
		return iR001Repository.getAllByNativeSql2();
	}
	
	public List<Author2> author2() {
		return author2Repository.getAllByNativeSql2();
	}
	
	public Page<Author> findAllPaging() {
		return authorRepository.findAll(new PageRequest(0, 2));
	}
}

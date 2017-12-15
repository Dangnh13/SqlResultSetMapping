package com.therealdanvega.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.therealdanvega.domain.Author;
import com.therealdanvega.domain.Author2;
import com.therealdanvega.domain.AuthorDto;
import com.therealdanvega.domain.AuthorFake;
import com.therealdanvega.repository.IR001Repository;
import com.therealdanvega.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = "/")
	public Iterable<Author> list() {
		return authorService.list();
	}

	@RequestMapping(value = "/paging")
	public Page<Author> paging() {
		return authorService.findAllPaging();
	}
	
	@RequestMapping(value = "/{id}")
	public Author list(@PathVariable Long id) {
		return authorService.findById(id);
	}

	@RequestMapping(value = "/findByLastName")
	public Iterable<Author> findByLastName() {
		return authorService.findByLastName("lastname");
	}

	@RequestMapping(value = "/getAuthorFake")
	public List<AuthorFake> getAuthorFake() {
		return authorService.getAuthorFake();
	}

	@RequestMapping(value = "/findByCollectionId")
	public Iterable<Author> findByCollectionId() {
		Long[] ids = { 1l, 2l };
		return authorService.findByIds(Arrays.asList(ids));
	}

	@RequestMapping(value = "/save")
	public Author save() {
		// Author author = authorService.findById(1l);
		// author.setFirstName("Ngo hai dang");
		// author.setId(0l);
		Author author = new Author();
		author.setId(4l);
		author.setEmail("a@gmail.com");
		author.setFirstName("a");
		author.setLastName("lastname");
		return authorService.saveEntity(author);
	}

	@RequestMapping(value = "/findByLastnameOrFirstname")
	public Iterable<Author> findByLastnameOrFirstname() {
		Long[] ids = { 1l, 2l };
		return authorService.findByLastnameOrFirstname("aaa", "bbb");
	}

	@RequestMapping(value = "/customNativeQuery")
	public List<AuthorFake> customNativeQuery() {
		return authorService.customNativeQuery();
	}
	@RequestMapping(value = "/retrieveUsernameAsDTO2")
	public List<AuthorDto> retrieveUsernameAsDTO2() {
		return authorService.retrieveUsernameAsDTO2();
	}
	
	@RequestMapping(value = "/author2")
	public List<Author2> author2() {
		return authorService.author2();
	}
}

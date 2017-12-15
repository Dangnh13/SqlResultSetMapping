package com.therealdanvega.repository;

import java.util.List;

import com.therealdanvega.domain.AuthorDto;
import com.therealdanvega.domain.AuthorFake;

public interface IR001Repository {
	List<AuthorFake> getAllByNativeSql();
	public List<AuthorDto> getAllByNativeSql2();
}

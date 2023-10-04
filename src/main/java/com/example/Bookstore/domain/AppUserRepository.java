package com.example.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

import com.example.Bookstore.domain.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	AppUser findByUsername(String username);
}
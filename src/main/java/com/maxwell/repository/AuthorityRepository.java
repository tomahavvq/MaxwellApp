package com.maxwell.repository;

import com.maxwell.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String>, QueryDslPredicateExecutor<Authority> {
}

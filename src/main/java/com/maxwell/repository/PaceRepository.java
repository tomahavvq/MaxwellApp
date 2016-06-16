package com.maxwell.repository;

import com.maxwell.domain.Pace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;


/**
 * Created by tomahavvq on 14.05.16.
 */
@Repository
public interface PaceRepository extends JpaRepository<Pace, Long>, QueryDslPredicateExecutor<Pace> {
}

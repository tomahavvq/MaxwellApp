package com.maxwell.repository;

import com.maxwell.domain.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by matexo on 21.05.16.
 */
@Repository
public interface TrainingRepository extends JpaRepository<Training, Long>, QueryDslPredicateExecutor<Training> {
}

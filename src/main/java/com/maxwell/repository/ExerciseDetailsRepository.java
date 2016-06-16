package com.maxwell.repository;

import com.maxwell.domain.ExerciseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by matexo on 21.05.16.
 */
public interface ExerciseDetailsRepository extends JpaRepository<ExerciseDetails, Long>, QueryDslPredicateExecutor<ExerciseDetails> {
}

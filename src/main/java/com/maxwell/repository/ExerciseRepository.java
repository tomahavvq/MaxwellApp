package com.maxwell.repository;

import com.maxwell.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by matexo on 21.05.16.
 */
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>, QueryDslPredicateExecutor<Exercise> {
}

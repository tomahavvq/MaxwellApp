package com.maxwell.repository;

import com.maxwell.domain.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by matexo on 21.05.16.
 */
@Repository
public interface TrainingRepository extends JpaRepository<Training, Long>, QueryDslPredicateExecutor<Training> {

    @Query("select training from Training training where training.user.login = ?#{principal.username}")
    Page<Training> findByUserIsCurrentUser(Pageable pageable);
}

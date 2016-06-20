package com.maxwell.repository;

import com.maxwell.domain.Run;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tomahavvq on 14.05.16.
 */
@Repository
public interface RunRepository extends JpaRepository<Run, Long>, QueryDslPredicateExecutor<Run> {

    @Query("select run from Run run where run.user.login = ?#{principal.username}")
    Page<Run> findByUserIsCurrentUser(Pageable pegeable);

}

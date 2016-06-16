package com.maxwell.repository;

import com.maxwell.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by tomahavvq on 13.05.16.
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>, QueryDslPredicateExecutor<UserInfo> {
}

package com.events.center.events_center.repository;


import com.events.center.events_center.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);

    @Query("SELECT u FROM User u WHERE u.status = 1")
    List<User> findAllUsersWithStatusOne();


    @Query("SELECT u FROM User u WHERE u.status IN (0, 1)")
    List<User> findAllUsersWithStatusZeroOrOne();
}

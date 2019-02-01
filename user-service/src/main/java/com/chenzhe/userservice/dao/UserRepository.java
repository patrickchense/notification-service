package com.chenzhe.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.chenzhe.userservice.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "from User where subscribedNewsletter = 'true'")
    List<User> findAllSubscribedNews();
    
}

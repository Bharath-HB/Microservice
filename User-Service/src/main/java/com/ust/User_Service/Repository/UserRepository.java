package com.ust.User_Service.Repository;

import com.ust.User_Service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
   // User findByUserId(String userId);
}

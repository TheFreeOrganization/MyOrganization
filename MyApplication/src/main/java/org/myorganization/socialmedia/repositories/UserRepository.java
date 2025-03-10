package org.myorganization.socialmedia.repositories;

import org.myorganization.socialmedia.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    void deleteById(int id);
    User findByEmail(String email);
    
}
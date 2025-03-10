package org.myorganization.socialmedia.repositories;

import org.myorganization.socialmedia.data.User;
import org.myorganization.socialmedia.data.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserImageRepository extends JpaRepository<UserImage, Integer> {
    Optional<UserImage> findByUser_Id(int userId);
}
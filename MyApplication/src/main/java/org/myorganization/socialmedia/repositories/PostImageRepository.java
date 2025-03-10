package org.myorganization.socialmedia.repositories;

import org.myorganization.socialmedia.data.Post;
import org.myorganization.socialmedia.data.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostImageRepository extends JpaRepository<PostImage, Integer> {
    Optional<PostImage> findPostImageByPost_Id(int postId);
}
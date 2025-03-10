package org.myorganization.socialmedia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.myorganization.socialmedia.dao.requests.PostAddRequest;
import org.myorganization.socialmedia.dao.responses.post.PostGetResponse;
import org.myorganization.socialmedia.data.Post;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "user.id",target = "userId")
    @Mapping(source = "user.lastName",target = "userLastName")
    @Mapping(source = "user.name",target = "userName")
    PostGetResponse postToGetResponse(Post post);

    @Mapping(source = "userId",target = "user.id")
    Post postAddRequestToPost(PostAddRequest postAddRequest);
    List<PostGetResponse> postsToGetResponses(List<Post> posts);
}

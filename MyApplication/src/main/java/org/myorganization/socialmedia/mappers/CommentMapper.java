package org.myorganization.socialmedia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.myorganization.socialmedia.dao.requests.CommentAddRequest;
import org.myorganization.socialmedia.dao.responses.comment.CommentGetResponse;
import org.myorganization.socialmedia.data.Comment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "user.id",target = "userId")
    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "user.name",target = "userName")
    @Mapping(source = "user.lastName",target = "userLastName")
    CommentGetResponse commentToResponse(Comment comment);
    List<CommentGetResponse> commentsToResponses(List<Comment> comments);
    @Mapping(source = "userId",target = "user.id")
    @Mapping(source = "postId",target = "post.id")
    Comment addRequestToComment(CommentAddRequest commentAddRequest);
}

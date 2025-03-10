package org.myorganization.socialmedia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.myorganization.socialmedia.dao.responses.userImage.UserImageResponse;
import org.myorganization.socialmedia.data.UserImage;

@Mapper(componentModel = "spring")
public interface UserImageMapper {

    @Mapping(source = "user.id",target = "userId")
    UserImageResponse userImageToResponse(UserImage userImage);

}

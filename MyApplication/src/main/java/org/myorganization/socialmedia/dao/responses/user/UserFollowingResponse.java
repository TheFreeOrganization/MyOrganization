package org.myorganization.socialmedia.dao.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowingResponse {
    private int userId;
    private String name;
    private String lastName;
}

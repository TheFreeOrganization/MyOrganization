package org.myorganization.socialmedia.dao.responses.like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeResponse {
    private int id;
    private int userId;
    private String name;
    private String lastName;
}

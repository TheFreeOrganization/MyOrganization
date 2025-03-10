package org.myorganization.socialmedia.dao.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostAddRequest {
    private int userId;
    private String Description;
}

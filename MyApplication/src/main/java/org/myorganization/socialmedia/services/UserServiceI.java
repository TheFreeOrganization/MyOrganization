package org.myorganization.socialmedia.services;

import org.myorganization.socialmedia.dao.requests.UserAddRequest;
import org.myorganization.socialmedia.data.User;

public interface UserServiceI {

	User add(UserAddRequest userAddRequest) ;
	
}

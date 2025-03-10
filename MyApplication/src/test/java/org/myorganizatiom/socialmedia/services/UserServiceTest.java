package org.myorganizatiom.socialmedia.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.myorganization.socialmedia.dao.requests.UserAddRequest;
import org.myorganization.socialmedia.data.User;
import org.myorganization.socialmedia.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

//	@InjectMocks
//	UserServiceImpl service ;
	
	@Mock
	UserRepository repository ;
	
	@Test
	void test() {
		
//		User user = Mockito.when( service.add( Mockito.any(UserAddRequest.class)) ).getMock();
//		assertNotNull( user ) ;
		
	}
}

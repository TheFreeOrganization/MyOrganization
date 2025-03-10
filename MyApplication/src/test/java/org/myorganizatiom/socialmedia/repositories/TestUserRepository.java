package org.myorganizatiom.socialmedia.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.myorganization.socialmedia.data.User;
import org.myorganization.socialmedia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class TestUserRepository {

	@Autowired
	TestEntityManager testEntityManager ;
	
	@Autowired
	UserRepository userRepository ;
	@Test
	void testfindByEmail() {
		String email = "toto@gmail.com" ;
		User user = new User() ;
		user.setName( "Greg" ) ;
		user.setLastName( "Yon" ) ;
		user.setEmail( email ) ;
		user.setPassword( "12345678" ) ;
		testEntityManager.persistAndFlush( user ) ;
		
		User expectedUser = userRepository.findByEmail(email) ;	
		assertEquals( user.getEmail(), expectedUser.getEmail() ) ;
	}
}

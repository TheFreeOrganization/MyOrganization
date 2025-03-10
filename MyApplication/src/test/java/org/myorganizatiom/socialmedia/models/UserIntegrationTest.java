package org.myorganizatiom.socialmedia.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.myorganization.socialmedia.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UserIntegrationTest {

	@Autowired
	TestEntityManager testEntityManager ;;
	
	@Test
	void testUser() {
		User user = new User() ;
		user.setName( "Greg" ) ;
		user.setLastName( "Yon" ) ;
		user.setEmail( "toto@gmail.com" ) ;
		user.setPassword( "12345678" ) ;
		
		User persistedUser = testEntityManager.persistAndFlush( user ) ;
		assertTrue( persistedUser.getId() > 0 ) ;
		assertEquals( user.getName(),     persistedUser.getName() ) ;
		assertEquals( user.getLastName(), persistedUser.getLastName() ) ;
		assertEquals( user.getEmail(),    persistedUser.getEmail() ) ;
		assertEquals( user.getPassword(), persistedUser.getPassword() ) ;
	}
}

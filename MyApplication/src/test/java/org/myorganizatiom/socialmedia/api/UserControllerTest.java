package org.myorganizatiom.socialmedia.api;

import static org.assertj.core.api.Assertions.contentOf;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.myorganization.socialmedia.api.UsersController;
import org.myorganization.socialmedia.dao.requests.UserAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;


//@MockBean( UserService.class ) 
@WebMvcTest(controllers=UsersController.class, 
			excludeAutoConfiguration= {SecurityAutoConfiguration.class})
//@AutoConfigureMockMvc( addFilters=false )
public class UserControllerTest {

	
	@Autowired
	private MockMvc mockMvc ;
	
//	@MockBean
//	UserService userService ;
	
	//@Autowired
	//UserMapper userMapper ;
	
	@Test
	@DisplayName( "User can be created" )
	void testCreateUser() throws Exception {
		
		UserAddRequest userRequest = new UserAddRequest() ;
		userRequest.setEmail( "toto@gmail.com" ) ;
		userRequest.setLastName( "Yon") ; 
		userRequest.setName( "Greg" ) ;
		userRequest.setPassword( "12345678" ) ;
		
		
		//User user = userMapper.requestToUser(userRequest) ;
		
		//when( userService.add( any( UserAddRequest.class ) ) ).thenReturn( user ) ;
		
		RequestBuilder builder = MockMvcRequestBuilders.post( "/api/users" )
												.contentType( MediaType.APPLICATION_JSON )
												.accept( MediaType.APPLICATION_JSON )
												.content( new ObjectMapper().writeValueAsString( userRequest) ) ;
	
		MvcResult mvcResult = mockMvc.perform( builder ).andReturn() ;
		String responseBody = mvcResult.getResponse().getContentAsString() ;
		ResponseEntity<?> response = new ObjectMapper().readValue( responseBody, ResponseEntity.class ) ;
		
	
		Assertions.assertTrue( response.getStatusCode().equals(HttpStatus.CREATED) ) ;
	}
}

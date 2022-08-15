package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.servicelayer.Servicelayer;



@RunWith(SpringRunner.class)
@SpringBootTest
class DemoProjectApplicationTests {

    
    @Autowired
    private Servicelayer service;
    
    @MockBean
    private UserRepository userrepository;
    
	@Test
	void contextLoads() 
	{
	    
	}
           @Test
	      public void testUpdateUser()
	      {
	         User user=new User(1, "1234", "pankaj", "maske", "pankajmas@gmail.com", "abhi@1234");
	         userrepository.save(user);
	      }
           @Test
           public void getUserTest()
           {
               
              when(userrepository.findAll()).thenReturn(Stream.of(new User(10, "1234", "panka", "maske", "pankajmas@gmail.com", "abhi@1234")).collect(Collectors.toList()));
              assertEquals(1,service.retieveAll().size());
           }
	}
	
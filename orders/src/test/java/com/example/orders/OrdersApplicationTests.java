package com.example.orders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.orders.Entities.Validation.User;
import com.example.orders.Repositories.UserRepository;
import com.example.orders.Services.UserService;

@SpringBootTest
class OrdersApplicationTests {

	private UserService userService;
    private UserRepository userRepository; 

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService();
    }

    @Test
    void testGetAllClients() {
        User client1 = new User();
        User client2 = new User();
        
        when(userRepository.findAll()).thenReturn(Arrays.asList(client1, client2));

        List<User> clients = userService.getAllUsers();
        assertEquals(2, clients.size());
        // другие проверки
    }

}

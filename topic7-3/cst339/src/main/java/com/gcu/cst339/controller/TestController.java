package com.gcu.cst339.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.ResourceAccessException;

import com.gcu.cst339.model.UserModel;
import com.gcu.cst339.model.OrderModel;

@Controller
@RequestMapping("/app")
public class TestController {

    @GetMapping("/")
    public String home(Model model) {
        // Display the home page
        model.addAttribute("title", "Demo Microservices Application");
        return "home";
    }

    @GetMapping("/getusers")
    public String getUsers(Model model) {
        String hostname = "localhost";
        int port = 8081;
        String url = "http://" + hostname + ":" + port + "/service/users";
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<List<UserModel>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<UserModel>>() {}
            );
            List<UserModel> users = response.getBody();
            model.addAttribute("title", "List of Users");
            model.addAttribute("users", users);
        } catch (ResourceAccessException e) {
            model.addAttribute("error", "Could not connect to the service at " + url + ". Please ensure the service is running and reachable.");
            return "error";
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred: " + e.getMessage());
            return "error";
        }
        return "users";
    }
    

    @GetMapping("/getorders")
    public String getOrders(Model model) {
        String hostname = "localhost";
        int port = 8082;
        String url = "http://" + hostname + ":" + port + "/service/orders";
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<List<OrderModel>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<OrderModel>>() {}
            );
            List<OrderModel> orders = response.getBody();
            model.addAttribute("title", "List of Orders");
            model.addAttribute("orders", orders);
        } catch (ResourceAccessException e) {
            model.addAttribute("error", "Could not connect to the service at " + url);
            return "error";
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred: " + e.getMessage());
            return "error";
        }
        return "orders";
    }
}

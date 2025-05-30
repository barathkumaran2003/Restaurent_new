package com.example.Restaurent.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Restaurent.entity.Book_table;
import com.example.Restaurent.entity.Cart;
import com.example.Restaurent.entity.Signin;
import com.example.Restaurent.Service.Cart_Service;
import com.example.Restaurent.Service.Signin_Service;
import com.example.Restaurent.Service.Table_service;

import jakarta.servlet.http.HttpSession;

@Controller
public class Signin_Controller 
{
    @Autowired
    private Signin_Service sServ;
    
    @Autowired
    private Cart_Service cServ;
    
    @Autowired
    private Table_service table_service;
    
    @GetMapping("/")
    public String home() {
        return "page";  // returns page.html
    }
      
    @PostMapping("/singin")
    public String addUser(@ModelAttribute Signin s, Model model) {
        // Check if email already exists
        if (sServ.getUserByEmail(s.getEmail()) != null) {
            model.addAttribute("error", "Email already registered!");
            return "page"; // Reload page.html with error message
        }
        sServ.save(s);
        model.addAttribute("success", "Signup successful! You can now log in.");
        return "page";  // Reload page.html with success message
    }

    // Handle Login
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, @ModelAttribute Signin s, Model model, HttpSession session) {
        if (sServ.authenticateUser(email, password)) {
            Signin user = sServ.getUserByEmail(email); // Get user by email
            session.setAttribute("name", user);
            model.addAttribute("success", "Hii " + user.getFirstname());  
            model.addAttribute("successe", user.getFirstname());
            model.addAttribute("acname", user.getEmail());
            model.addAttribute("acemail", user.getEmail());     
            model.addAttribute("account", user.getFirstname());
            return "home";  // returns home.html
        }
        model.addAttribute("error", "Invalid Email or Password!");
        return "page";  // returns page.html with error
    }
    
    @GetMapping("/account")
    public String account(HttpSession session, Model model) {
        Signin user = (Signin) session.getAttribute("name");
        if (user == null) {
            return "redirect:/login"; // Redirect to login page if not authenticated
        }
        model.addAttribute("successe", user.getFirstname());
        model.addAttribute("acname", user.getFirstname());
        model.addAttribute("acemail", user.getEmail());
        model.addAttribute("lasten", user.getLastname());
        return "account";  // returns account.html
    }
    
    @GetMapping("/order")
    public String order(HttpSession session, Model model, @RequestParam String email) {
        Signin user1 = (Signin) session.getAttribute("name");
        if (user1 == null) {
            return "redirect:/login"; // Redirect if not authenticated
        }
        model.addAttribute("successe", user1.getFirstname());
        model.addAttribute("acname", user1.getFirstname());
        model.addAttribute("acemail", user1.getEmail());
        model.addAttribute("lasten", user1.getLastname());
        return "account";  // returns account.html
    }
    
    @PostMapping("/add")
    public String add(HttpSession session, Model model, @ModelAttribute Cart b) {
        Signin user1 = (Signin) session.getAttribute("name");
        if (user1 == null) {
            return "redirect:/login"; // Redirect if not authenticated
        }
        model.addAttribute("successe", user1.getFirstname());
        model.addAttribute("acname", user1.getFirstname());
        model.addAttribute("acemail", user1.getEmail());
        model.addAttribute("lasten", user1.getLastname());
        
        cServ.save(b);
        List<Cart> users1 = cServ.getAllUsers();
        model.addAttribute("users1", users1);
        List<Book_table> users = table_service.getAllUsers();
        model.addAttribute("users", users);
        return "accountc";  // returns accountc.html
    }
    
    @PostMapping("/table")
    public String change(@RequestParam LocalDate dob, HttpSession session, Model model, @ModelAttribute Book_table book_table) {
        Signin user1 = (Signin) session.getAttribute("name");
        if (user1 == null) {
            return "redirect:/login"; // Redirect if not authenticated
        }
        model.addAttribute("successe", user1.getFirstname());
        model.addAttribute("acname", user1.getFirstname());
        model.addAttribute("acemail", user1.getEmail());
        model.addAttribute("lasten", user1.getLastname());
        
        if (table_service.isTableBooked(dob)) {
            model.addAttribute("errorMessage", "Table already booked on this date!");
            return "home";  // returns home.html with error
        }
        
        table_service.save(book_table);
        List<Book_table> users = table_service.getAllUsers();
        model.addAttribute("users", users);
        List<Cart> users1 = cServ.getAllUsers();
        model.addAttribute("users1", users1);
        
        return "account1";  // returns account1.html
    }
    
    @GetMapping("/home")
    public String give() {
        return "home";  // returns home.html
    }
    
    @GetMapping("/page")
    public String logout() {
        return "page";  // returns page.html
    }
}

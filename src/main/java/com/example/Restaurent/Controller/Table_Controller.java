package com.example.Restaurent.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Restaurent.Service.Cart_Service;
import com.example.Restaurent.Service.Table_service;
import com.example.Restaurent.entity.Book_table;
import com.example.Restaurent.entity.Cart;

@Controller
public class Table_Controller {

    @Autowired
    private Table_service table_service;

    @Autowired
    private Cart_Service cServ;

    @GetMapping("/delete/{id}")  
    public String deleteBook(@PathVariable long id, Model model, @ModelAttribute Book_table book_table) {  
        table_service.deleteById(id);  

        List<Book_table> users = table_service.getAllUsers();
        model.addAttribute("users", users);

        List<Cart> users1 = cServ.getAllUsers();
        model.addAttribute("users1", users1);

        return "account1";  // return the view account1.html
    }

    // You can uncomment and adapt your /table POST handler here as needed.
}

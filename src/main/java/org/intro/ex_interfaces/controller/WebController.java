package org.intro.ex_interfaces.controller;

import org.intro.ex_interfaces.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class WebController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String greeting(Model model) {
        var products = productRepository.findAll();
        model.addAttribute("title", "Listado de Productos");
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product/{id}")
    public String product(Model model, @PathVariable String id) {
        var item = productRepository.findById(id);
        if (item.isEmpty()) {
            return "redirect:/api/error";
        }
        model.addAttribute("title", item.get().getTitle());
        model.addAttribute("product", item.get());
        return "detail";
    }
}

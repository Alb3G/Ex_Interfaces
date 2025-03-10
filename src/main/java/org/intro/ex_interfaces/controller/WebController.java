package org.intro.ex_interfaces.controller;

import org.intro.ex_interfaces.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * WebController que gestiona las diferentes vistas para los usuarios
 * @author albertoguzman
 */
@Controller
@RequestMapping("/api")
public class WebController {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Método que devuelve la vista principal con el listado de productos
     * @param model modelo que se enviara a la vista con los datos
     * @return vista principal
     */
    @GetMapping("/products")
    public String greeting(Model model) {
        var products = productRepository.findAll();
        model.addAttribute("title", "Listado de Productos");
        model.addAttribute("products", products);
        return "index";
    }

    /**
     * Método que devuelve la vista de detalle de un producto
     * @param model modelo que se enviara a la vista con los datos
     * @param id identificador del producto
     * @return vista de detalle
     */
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

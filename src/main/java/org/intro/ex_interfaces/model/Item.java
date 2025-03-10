package org.intro.ex_interfaces.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Clase que representa un producto
 * @author albertoguzman
 */
@Data
@Document(collection = "Items")
public class Item implements Serializable {
    @Id
    private String _id;
    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Float rate;
    private Integer count;
}
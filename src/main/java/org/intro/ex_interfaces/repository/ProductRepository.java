package org.intro.ex_interfaces.repository;

import org.intro.ex_interfaces.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Item, String> {}

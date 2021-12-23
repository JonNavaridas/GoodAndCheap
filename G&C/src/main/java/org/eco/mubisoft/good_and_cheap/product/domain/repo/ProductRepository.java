package org.eco.mubisoft.good_and_cheap.product.domain.repo;

import org.eco.mubisoft.good_and_cheap.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

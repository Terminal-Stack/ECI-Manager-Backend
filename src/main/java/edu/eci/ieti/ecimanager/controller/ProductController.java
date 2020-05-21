package edu.eci.ieti.ecimanager.controller;

import edu.eci.ieti.ecimanager.assembler.ProductRepresentationModelAssembler;
import edu.eci.ieti.ecimanager.exception.ProductNotFoundException;
import edu.eci.ieti.ecimanager.exception.StudentNotFoundException;
import edu.eci.ieti.ecimanager.model.Product;
import edu.eci.ieti.ecimanager.model.Student;
import edu.eci.ieti.ecimanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductRepresentationModelAssembler productRepresentationModelAssembler;

    @GetMapping
    public CollectionModel<EntityModel<Product>> all() {
        List<EntityModel<Product>> products = productRepository.findAll().stream()
                .map(productRepresentationModelAssembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(products, linkTo(ProductController.class).withSelfRel());
    }

    @GetMapping("{name}")
    public EntityModel<Product> findByName(@PathVariable String name) {
        Product product = productRepository.findById(name).orElseThrow(() -> new ProductNotFoundException(name));

        return productRepresentationModelAssembler.toModel(product);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Product newProduct) throws URISyntaxException {
        EntityModel<Product> entityModel = productRepresentationModelAssembler
                .toModel(productRepository.insert(newProduct));

        return ResponseEntity.created(new URI(entityModel.getRequiredLink("self").expand().getHref()))
                .body(entityModel);
    }

    @PutMapping("{name}")
    public ResponseEntity<?> update(@PathVariable String name, @RequestBody Product newProduct) throws URISyntaxException {
        Product updatedProduct = productRepository.findById(name).map(product -> {
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
            return productRepository.save(product);
        }).orElseGet(() -> {
            newProduct.setName(name);
            EntityModel<Product> entityModel = productRepresentationModelAssembler.toModel(newProduct);
            return productRepository.save(newProduct);
        });
        EntityModel<Product> entityModel = productRepresentationModelAssembler.toModel(updatedProduct);
        return ResponseEntity.created(new URI(entityModel.getRequiredLink("self").expand().getHref()))
                .body(entityModel);
    }

}

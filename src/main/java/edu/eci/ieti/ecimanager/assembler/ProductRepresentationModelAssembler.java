package edu.eci.ieti.ecimanager.assembler;

import edu.eci.ieti.ecimanager.controller.ProductController;
import edu.eci.ieti.ecimanager.model.Product;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class ProductRepresentationModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {

    @Override
    public EntityModel<Product> toModel(Product product) {
        return new EntityModel<Product>(product,
                linkTo(ProductController.class).slash(product.getName()).withSelfRel(),
                linkTo(ProductController.class).withRel("products"));
    }

}

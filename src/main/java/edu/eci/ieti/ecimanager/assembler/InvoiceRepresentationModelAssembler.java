package edu.eci.ieti.ecimanager.assembler;

import edu.eci.ieti.ecimanager.controller.InvoiceController;
import edu.eci.ieti.ecimanager.model.Invoice;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * @author Daniel Vela
 */
@Component
public class InvoiceRepresentationModelAssembler implements RepresentationModelAssembler<Invoice, EntityModel<Invoice>> {

    @Override
    public EntityModel<Invoice> toModel(Invoice invoice) {
        return new EntityModel<Invoice>(invoice,
                linkTo(InvoiceController.class).slash(invoice.getId()).withSelfRel(),
                linkTo(InvoiceController.class).withRel("invoices"));
    }

}

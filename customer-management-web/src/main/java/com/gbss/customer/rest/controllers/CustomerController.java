package com.gbss.customer.rest.controllers;

import com.gbss.customer.api.service.CustomerManagementService;
import com.gbss.customer.rest.constants.RestUris;
import com.gbss.customer.rest.converters.CustomerConverter;
import com.gbss.customer.rest.json.request.Customer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Rest APIs for customer management.
 *
 * Acceptance Criteria:
 * In a case of a new customer, create RESTful APIs for:
 * i. Creating a customer.
 * ii. Getting customer’s info using an ID you choose for your customers that can be identified with that.
 * iii. Updating customer’s info using the ID.
 * iv. Listing all customers.
 */
@Slf4j
@RestController
@RequestMapping(RestUris.CUSTOMER_BASE_URI)
@Api(value = "Customer Controller", description = "Customer Management REST Endpoints.")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController {

    private final CustomerManagementService customerManagementService;

    private final CustomerConverter customerConverter;

    @Autowired
    public CustomerController(CustomerManagementService customerManagementService,
                              CustomerConverter customerConverter) {
        this.customerManagementService = customerManagementService;
        this.customerConverter = customerConverter;
    }

    @ApiOperation(value = "Creating a customer.")
    @PostMapping("/customer")
    public ResponseEntity<com.gbss.customer.api.model.Customer> createCustomer(
            @Valid @RequestBody Customer request) {
        log.trace("createCustomer started with request: ", request);
        final com.gbss.customer.api.model.Customer customer = this.customerConverter.apply(request);
        final com.gbss.customer.api.model.Customer persisted =
                this.customerManagementService.createCustomer(customer);
        return ResponseEntity
                .created(URI.create(RestUris.CUSTOMER_URI + "/" + persisted.getId()))
                .body(persisted);
    }

    @ApiOperation(value = "Getting customer’s info using an ID.")
    @GetMapping(value="/customer/{id}")
    public ResponseEntity<com.gbss.customer.api.model.Customer> getCustomerById(
            @PathVariable("id") String id,
            @RequestParam(required = false) List<String> fields) {
        log.trace("getCustomerById started with id: ", id);
        return ResponseEntity.ok(this.customerManagementService.getCustomerById(id, fields));
    }

    @ApiOperation(value = "Updating customer’s info using the ID.")
    @PatchMapping(value="/customer/{id}")
    public ResponseEntity<com.gbss.customer.api.model.Customer> updateCustomer(@PathVariable("id") String id,
                                                   @Valid @RequestBody Customer request) {
        log.trace("updateCustomer started with request: ", request);
        final com.gbss.customer.api.model.Customer customer = this.customerConverter.apply(request);
        customer.setId(id);
        return ResponseEntity.ok(this.customerManagementService.updateCustomer(customer));
    }

    @ApiOperation(value = "Listing all customers.")
    @GetMapping("/customer")
    public ResponseEntity<List<com.gbss.customer.api.model.Customer>> getCustomers(
             @RequestParam(required = false) List<String> fields) {
        log.trace("getCustomers started with fields: ", fields);
        return ResponseEntity.ok(this.customerManagementService.getCustomers(fields));
    }
}

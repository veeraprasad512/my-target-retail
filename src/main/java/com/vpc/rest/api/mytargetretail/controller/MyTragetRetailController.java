package com.vpc.rest.api.mytargetretail.controller;

import com.vpc.rest.api.mytargetretail.exception.ApiException;
import com.vpc.rest.api.mytargetretail.model.ProductDetailsResponse;
import com.vpc.rest.api.mytargetretail.service.RetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class MyTragetRetailController {

    @Autowired
    private RetailService retailService;

    @GetMapping(value="/productdetails/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDetailsResponse> retrieveProductData (@PathVariable String productId) {

        return ResponseEntity.ok(retailService.getProductDetails(productId));
    }
}

package com.vpc.rest.api.mytargetretail.controller;

import com.vpc.rest.api.mytargetretail.exception.ApiException;
import com.vpc.rest.api.mytargetretail.model.PriceData;
import com.vpc.rest.api.mytargetretail.model.ProductDetailsResponse;
import com.vpc.rest.api.mytargetretail.service.RetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class MyTragetRetailController {

    @Autowired
    private RetailService retailService;

    @GetMapping(value="/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDetailsResponse> retrieveProductData (@PathVariable String id) {

        return ResponseEntity.ok(retailService.getProductDetails(id));
    }

    @PutMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceData> updateProductDetails(@PathVariable String id, @RequestBody ProductDetailsResponse productDetailsResponse) {

        ResponseEntity<PriceData> priceData = null;
        try {
            ProductDetailsResponse productDetailsApiResponse = retailService.getProductDetails(id);
            if (productDetailsApiResponse != null) {
                return ResponseEntity.ok(retailService.updateProductPrice(productDetailsResponse));
            }
        } catch (Exception ex) {
            throw new ApiException(ex.getMessage());
        }
        return priceData;
    }
}

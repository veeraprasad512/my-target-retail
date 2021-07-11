package com.vpc.rest.api.mytargetretail.service;

import com.vpc.rest.api.mytargetretail.model.ProductDetailsResponse;

public interface RetailService {

    ProductDetailsResponse getProductDetails(String Id);

    ProductDetailsResponse updateProductPrice(ProductDetailsResponse productDetailsResponse);

}

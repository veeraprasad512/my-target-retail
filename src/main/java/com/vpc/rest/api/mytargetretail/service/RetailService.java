package com.vpc.rest.api.mytargetretail.service;

import com.vpc.rest.api.mytargetretail.model.PriceData;
import com.vpc.rest.api.mytargetretail.model.ProductDetailsResponse;

public interface RetailService {

    ProductDetailsResponse getProductDetails(String Id);

    PriceData updateProductPrice(ProductDetailsResponse productDetailsResponse);

}

package com.vpc.rest.api.mytargetretail.service;

import com.vpc.rest.api.mytargetretail.model.PriceData;
import com.vpc.rest.api.mytargetretail.model.ProductDetailsResponse;
import com.vpc.rest.api.mytargetretail.repository.PriceRepository;
import com.vpc.rest.api.mytargetretail.restclient.ProductDataRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetailServiceImpl implements RetailService{

    @Autowired
    private ProductDataRestClient productDataRestClient;

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public ProductDetailsResponse getProductDetails(String Id) {

        ProductDetailsResponse productDetailsResponse = null;

        String productName = productDataRestClient.getProductDataServiceResponse(Id);
        if(productName != null && !productName.isEmpty()) {
            PriceData priceData = priceRepository.getPriceData(Id);
            productDetailsResponse = new ProductDetailsResponse(Id, productName, priceData.getCurrentPrice());
        }
        return  productDetailsResponse;
    }

    @Override
    public ProductDetailsResponse updateProductPrice(ProductDetailsResponse productDetailsResponse) {
        return null;
    }
}

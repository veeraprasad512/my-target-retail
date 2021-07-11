package com.vpc.rest.api.mytargetretail.service;

import com.vpc.rest.api.mytargetretail.exception.ApiException;
import com.vpc.rest.api.mytargetretail.model.CurrentPrice;
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

        try {
            String productName = productDataRestClient.getProductDataServiceResponse(Id);
            if (productName != null && !productName.isEmpty()) {
                PriceData priceData = priceRepository.getPriceData(Id);
                productDetailsResponse = new ProductDetailsResponse(Id, productName, priceData.getCurrentPrice());
            }
        } catch (Exception ex) {
            throw new ApiException(ex.getMessage());
        }
        return  productDetailsResponse;
    }

    @Override
    public PriceData updateProductPrice(ProductDetailsResponse productDetailsResponse) {
        PriceData modifiedPriceData;

        PriceData priceData = priceRepository.getPriceData(productDetailsResponse.getProductId());
        if (priceData != null) {
            CurrentPrice currentPrice = new CurrentPrice(productDetailsResponse.getCurrentPrice().getValue(),
                    productDetailsResponse.getCurrentPrice().getCurrencyCode());
            modifiedPriceData = new PriceData(productDetailsResponse.getProductId(), currentPrice);

            PriceData updatedPriceData = priceRepository.updatePriceData(modifiedPriceData);
        } else {
            throw new ApiException("PriceData is not found in the DB for productID : " + productDetailsResponse.getProductId());
        }

        return modifiedPriceData;

    }
}

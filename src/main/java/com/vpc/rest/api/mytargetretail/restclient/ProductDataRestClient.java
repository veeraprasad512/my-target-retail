package com.vpc.rest.api.mytargetretail.restclient;

import com.vpc.rest.api.mytargetretail.exception.ApiException;
import com.vpc.rest.api.mytargetretail.model.ProductData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductDataRestClient {

    private static final Logger log = LoggerFactory.getLogger(ProductDataRestClient.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${productdataservice.uri:http://localhost:8080/}")
    private String productDataServiceUri;

    @Value("${productdataservice.endpoint:api/productdata/}")
    private String productDataServiceEndpoint;

    public String getProductDataServiceResponse(String productId) throws ApiException {

        String name;
        ProductData productData;
        ResponseEntity<ProductData> responseEntity = null;

        String finalUrl = new StringBuilder(productDataServiceUri).append(productDataServiceEndpoint).append(productId).toString();

        try {
            log.info("Url is : {}", finalUrl);
            responseEntity = restTemplate.getForEntity(finalUrl, ProductData.class);
            productData = responseEntity.getBody();
            name = productData.getName();
        } catch (RestClientException e) {
            throw new ApiException("Exception occured while invoking product-data service : " + e.getMessage());
        } catch (Exception e) {
            throw new ApiException("Exception from product-data service : " + e.getMessage());
        }
        return name;
    }
}

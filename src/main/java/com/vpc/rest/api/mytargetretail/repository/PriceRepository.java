package com.vpc.rest.api.mytargetretail.repository;

import com.vpc.rest.api.mytargetretail.model.PriceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PriceRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public PriceData getPriceData(String Id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(Id));
        return mongoTemplate.findOne(query, PriceData.class);
    }

    /*public PriceData updatePriceData(ProductData productData) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productData.getProductId()));
        return mongoTemplate.update(PriceData.class);
    }*/
}

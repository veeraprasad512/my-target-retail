package com.vpc.rest.api.mytargetretail.repository;

import com.vpc.rest.api.mytargetretail.model.CurrentPrice;
import com.vpc.rest.api.mytargetretail.model.PriceData;
import com.vpc.rest.api.mytargetretail.model.ProductDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PriceRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public PriceData getPriceData(String Id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(Id));
        return mongoTemplate.findOne(query, PriceData.class);
    }

    public PriceData updatePriceData(PriceData priceData) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(priceData.getProductId()));
        Update update = new Update();
        update.set("currentPrice",priceData.getCurrentPrice());
        return mongoTemplate.findAndModify(query, update, PriceData.class);
    }
}

package com.vpc.rest.api.mytargetretail.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "PriceData")
public class PriceData {

    private String productId;
    private CurrentPrice currentPrice;
}

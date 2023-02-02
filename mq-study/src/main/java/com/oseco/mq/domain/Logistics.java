package com.oseco.mq.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author panguanghua
 */
@Data
@Builder
public class Logistics implements Serializable {
    private String orderNo;
    private BigDecimal weight;
    private String deliveryVendor;
    private BigDecimal deliveryAmount;
}

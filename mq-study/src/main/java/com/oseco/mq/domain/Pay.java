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
public class Pay implements Serializable {
    private String orderNo;
    private String channel;
    private BigDecimal payAmount;
}

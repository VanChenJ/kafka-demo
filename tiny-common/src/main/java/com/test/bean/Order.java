package com.test.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author van0512
 */
@Data
public class Order implements Serializable {

    private String orderId;

    private Integer commodityId;

    private Integer amount;
}

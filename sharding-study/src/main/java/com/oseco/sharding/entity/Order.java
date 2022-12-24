package com.oseco.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author panguanghua
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("t_order")
public class Order extends Model<Order> {

    @TableId
    private Integer id;

    @TableField("store_no")
    private int storeNo;

    @TableField("order_id")
    private int orderId;

    @TableField("create_time")
    private Date createTime;
    private int userId;

    @TableField("order_amount")
    private BigDecimal orderAmount;
}

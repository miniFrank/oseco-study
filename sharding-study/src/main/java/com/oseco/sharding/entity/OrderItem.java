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

/**
 * @author panguanghua
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("t_order_item")
public class OrderItem extends Model<OrderItem> {
    @TableId
    private Integer id;

    @TableField("order_id")
    private int orderId;

    @TableField("goods_name")
    private String goodsName;

    @TableField("goods_qty")
    private int goodsQty;

    @TableField("goods_amount")
    private BigDecimal goodsAmount;

    @TableField("store_no")
    private int storeNo;
}

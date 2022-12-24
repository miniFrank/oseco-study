package com.oseco.sharding;

import com.oseco.sharding.entity.Order;
import com.oseco.sharding.entity.OrderItem;
import com.oseco.sharding.service.OrderService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void testCreate() {
        BigDecimal amount = BigDecimal.valueOf(50L);
        Order order = Order.builder()
                .storeNo(1)
                .userId(1)
                .createTime(new Date())
                .orderAmount(amount)
                .build();
        OrderItem orderItem = OrderItem.builder()
                .storeNo(1)
                .goodsName("test-goods")
                .goodsQty(2)
                .goodsAmount(amount)
                .build();
        orderService.create(order, Lists.newArrayList(orderItem));

        order = Order.builder()
                .storeNo(2)
                .userId(2)
                .createTime(new Date())
                .orderAmount(amount)
                .build();
        orderItem = OrderItem.builder()
                .storeNo(2)
                .goodsName("test-goods-2")
                .goodsQty(5)
                .goodsAmount(amount)
                .build();
        orderService.create(order, Lists.newArrayList(orderItem));
    }

    @Test
    public void testFindAll() {
        List<Order> orderList = orderService.findAll();
        System.out.println(orderList);
    }

    /**
     * 2022-12-22 20:33:14.432  INFO 40861 --- [           main] ShardingSphere-SQL                       : Logic SQL: SELECT  id,store_no,order_id,create_time,user_id,order_amount  FROM t_order
     * <p>
     * WHERE (user_id IN (?,?))
     * 2022-12-22 20:33:14.433  INFO 40861 --- [           main] ShardingSphere-SQL                       : SQLStatement: SelectStatementContext(super=CommonSQLStatementContext(sqlStatement=org.apache.shardingsphere.sql.parser.sql.statement.dml.SelectStatement@8d52313, tablesContext=org.apache.shardingsphere.sql.parser.binder.segment.table.TablesContext@64f49b3), tablesContext=org.apache.shardingsphere.sql.parser.binder.segment.table.TablesContext@64f49b3, projectionsContext=ProjectionsContext(startIndex=8, stopIndex=60, distinctRow=false, projections=[ColumnProjection(owner=null, name=id, alias=Optional.empty), ColumnProjection(owner=null, name=store_no, alias=Optional.empty), ColumnProjection(owner=null, name=order_id, alias=Optional.empty), ColumnProjection(owner=null, name=create_time, alias=Optional.empty), ColumnProjection(owner=null, name=user_id, alias=Optional.empty), ColumnProjection(owner=null, name=order_amount, alias=Optional.empty)]), groupByContext=org.apache.shardingsphere.sql.parser.binder.segment.select.groupby.GroupByContext@23e3a27f, orderByContext=org.apache.shardingsphere.sql.parser.binder.segment.select.orderby.OrderByContext@70869678, paginationContext=org.apache.shardingsphere.sql.parser.binder.segment.select.pagination.PaginationContext@51eafec0, containsSubquery=false)
     * 2022-12-22 20:33:14.433  INFO 40861 --- [           main] ShardingSphere-SQL                       : Actual SQL: ds0 ::: SELECT  id,store_no,order_id,create_time,user_id,order_amount  FROM t_order_0
     * <p>
     * WHERE (user_id IN (?,?)) ::: [1, 2]
     * 2022-12-22 20:33:14.433  INFO 40861 --- [           main] ShardingSphere-SQL                       : Actual SQL: ds0 ::: SELECT  id,store_no,order_id,create_time,user_id,order_amount  FROM t_order_1
     * <p>
     * WHERE (user_id IN (?,?)) ::: [1, 2]
     * 2022-12-22 20:33:14.434  INFO 40861 --- [           main] ShardingSphere-SQL                       : Actual SQL: ds1 ::: SELECT  id,store_no,order_id,create_time,user_id,order_amount  FROM t_order_0
     * <p>
     * WHERE (user_id IN (?,?)) ::: [1, 2]
     * 2022-12-22 20:33:14.434  INFO 40861 --- [           main] ShardingSphere-SQL                       : Actual SQL: ds1 ::: SELECT  id,store_no,order_id,create_time,user_id,order_amount  FROM t_order_1
     * <p>
     * WHERE (user_id IN (?,?)) ::: [1, 2]
     *  todo: 虽然会做轮询，但性能太差
     */
    @Test
    public void testFindAllByUserId() {
        List<Order> orderList = orderService.findAllByUserId();
        System.out.println(orderList);
    }

    /**
     * 2022-12-22 20:37:40.506  INFO 41054 --- [           main] ShardingSphere-SQL                       : Logic SQL: SELECT  id,store_no,order_id,create_time,user_id,order_amount  FROM t_order
     * <p>
     * WHERE (store_no = ? AND user_id = ?)
     * 2022-12-22 20:37:40.506  INFO 41054 --- [           main] ShardingSphere-SQL                       : SQLStatement: SelectStatementContext(super=CommonSQLStatementContext(sqlStatement=org.apache.shardingsphere.sql.parser.sql.statement.dml.SelectStatement@3dc4ed6f, tablesContext=org.apache.shardingsphere.sql.parser.binder.segment.table.TablesContext@2823b7c5), tablesContext=org.apache.shardingsphere.sql.parser.binder.segment.table.TablesContext@2823b7c5, projectionsContext=ProjectionsContext(startIndex=8, stopIndex=60, distinctRow=false, projections=[ColumnProjection(owner=null, name=id, alias=Optional.empty), ColumnProjection(owner=null, name=store_no, alias=Optional.empty), ColumnProjection(owner=null, name=order_id, alias=Optional.empty), ColumnProjection(owner=null, name=create_time, alias=Optional.empty), ColumnProjection(owner=null, name=user_id, alias=Optional.empty), ColumnProjection(owner=null, name=order_amount, alias=Optional.empty)]), groupByContext=org.apache.shardingsphere.sql.parser.binder.segment.select.groupby.GroupByContext@2ce3d95a, orderByContext=org.apache.shardingsphere.sql.parser.binder.segment.select.orderby.OrderByContext@6f6c6c70, paginationContext=org.apache.shardingsphere.sql.parser.binder.segment.select.pagination.PaginationContext@75d95b67, containsSubquery=false)
     * 2022-12-22 20:37:40.507  INFO 41054 --- [           main] ShardingSphere-SQL                       : Actual SQL: ds1 ::: SELECT  id,store_no,order_id,create_time,user_id,order_amount  FROM t_order_1
     * <p>
     * WHERE (store_no = ? AND user_id = ?) ::: [1, 1]
     */
    @Test
    public void testFindAllByStoreNoAndUserId() {
        List<Order> orderList = orderService.findAllByStoreNoAndUserId();
        System.out.println(orderList);
    }

}

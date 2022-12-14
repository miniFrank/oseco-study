package com.oseco.spring.aop.mode.creation.af;

import com.oseco.spring.aop.mode.domain.Apple;
import com.oseco.spring.aop.mode.domain.Fruit;
import com.oseco.spring.aop.mode.domain.Request;

/**
 * 抽象工厂设计模式
 * <p>
 * 参考DefaultAopProxyFactory
 *
 * @author panguanghua
 */
public class DefaultFruitFactory implements FruitFactory {
    @Override
    public Fruit createFruit(Request request) {
        if (request.equals("apple")) {
            return new Apple();
        }
        return null;
    }
}

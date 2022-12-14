package com.oseco.spring.aop.mode.creation.af;

import com.oseco.spring.aop.mode.domain.Fruit;
import com.oseco.spring.aop.mode.domain.Request;

public interface FruitFactory {
    Fruit createFruit(Request request);
}

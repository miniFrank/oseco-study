package com.oseco.spring.aop.mode.creation.builder;

import com.oseco.spring.aop.mode.domain.Fruit;
import lombok.Data;

/**
 * 设计模式：构建器模式（Builder）实现
 * 参考AOP类：BeanFactoryAspectJAdvisorsBuilder
 *
 * @author panguanghua
 */
@Data
public class FruitBuilder {
    private String color;
    private String weight;

    public Fruit build() {
        Fruit fruit = new Fruit();
        fruit.setColor(this.color);
        fruit.setWeight(this.weight);
        return fruit;
    }

    public FruitBuilder color(String color) {
        this.setColor("red");
        return this;
    }

    public FruitBuilder weight(String weight) {
        this.setWeight(weight);
        return this;
    }
}

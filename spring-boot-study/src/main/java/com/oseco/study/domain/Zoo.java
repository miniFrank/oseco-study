package com.oseco.study.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Zoo implements Serializable {
    private int id;
    private String name;
    private String position;
}

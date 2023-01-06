package com.atlantisl.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User1 {
    private String name;
    private int age;
}

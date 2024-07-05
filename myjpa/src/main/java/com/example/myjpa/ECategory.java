package com.example.myjpa;

import java.util.Objects;

public enum ECategory {
    Friends(0),
    Families(1),
    Schools(2),
    Jobs(3),
    Hobbies(4);

    private final Integer value;

    ECategory(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    private static final ECategory[] ECategoryArray = ECategory.values();

    public static ECategory integerOf(Integer val) {
        for (ECategory item : ECategoryArray) {
            if (val.equals(item.getValue())) {
                return item;
            }
        }
        throw new IllegalArgumentException("ECategory value : " + val);
    }
}

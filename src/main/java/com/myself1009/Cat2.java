package com.myself1009;

import java.util.Objects;

/**
 * @Author cuihaiyan
 * @Create_Time 2019-10-09 09:37
 */

public class Cat2 {
    public Cat2(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat2 cat2 = (Cat2) o;
        return Objects.equals(name, cat2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}



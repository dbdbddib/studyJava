package com.example.myjpa.category;
import java.io.Serializable;

// Serializable
// 객체의 상태를 바이트 스트림으로 변환하여 데이터베이스에 저장


public interface ICategory extends Serializable {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    default void copyFields(ICategory from) {
        if (from == null) {
            return;
        }
        if (from.getId() != null) {
            this.setId(from.getId());
        }
        if (from.getName() != null && !from.getName().isEmpty()) {
            this.setName(from.getName());
        }
    }
}

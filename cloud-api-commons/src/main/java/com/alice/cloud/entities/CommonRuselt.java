package com.alice.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonRuselt<T> {
    private long code;
    private String message;
    private T data;

    public CommonRuselt(long code, String message) {
        this.code = code;
        this.message = message;
    }
}

package com.uek.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VO 值对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountForm {
    private String name;
    private double balance;
}

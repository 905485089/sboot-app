package com.uek.boot.entity;


import lombok.*;

import java.io.Serializable;

/**
 * 使用lombok框架自动生成class
 * java ‘有能力操作字节码’
 * 反射是你只有获取class文件中的能力，但是没有修改class的能力
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
public class Account implements Serializable {
    private int id;
    @NonNull
    private String name;
    @NonNull
    private double balance;

    public Account(AccountForm actForm) {
        this.name = actForm.getName();
        this.balance = actForm.getBalance();
    }
}

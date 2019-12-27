package com.uek.boot.Util;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class JsonResult {
    private String status;
    private String data;

    /**
     * 把用户获得的数据对象转化为JSON字符串
     *
     * @param o
     */
    public void setData(Object o) {
        this.data = JSON.toJSONString(o);
    }
}

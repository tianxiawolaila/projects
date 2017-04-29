package com.example.pojo;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
public class BasePojo {
    private LocalDateTime CreateAt;

    private LocalDateTime UpdateAt;

    public LocalDateTime getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        CreateAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        UpdateAt = updateAt;
    }
}

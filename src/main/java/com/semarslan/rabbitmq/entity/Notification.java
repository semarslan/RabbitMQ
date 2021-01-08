package com.semarslan.rabbitmq.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data //getter setter with Lombok
@ToString //toString method with Lombok
public class Notification implements Serializable {

    private String id;

    private Date createdAt;

    private Boolean seen;

    private String content;

}

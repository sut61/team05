package com.okta.developer.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

public class Package {
    @Id @GeneratedValue
    private long id;
    private Timestamp regDate;


}

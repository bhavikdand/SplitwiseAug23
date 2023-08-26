package com.scaler.splitwiseaug23.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User extends BaseModel{

    private String name;
    private String phoneNumber;
    private String password;

}

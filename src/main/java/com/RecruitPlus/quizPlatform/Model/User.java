package com.RecruitPlus.quizPlatform.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "user")
@Data
public class User {
    @Id
    private String user_id;
    @Field("user_name")
    private String user_name;
    @Field("email")
    private String email;
    @Field("college")
    private String college;
    @Field("degree")
    private String degree;
    @Field("year")
    private String year;
    @Field("branch")
    private String branch;
    @Field("role")
    private String role;

}

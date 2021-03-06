package com.cowan0141.springbootvue;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Todo {

    @Id @GeneratedValue
    private Long Id;

    @NonNull
    private String title;

    private Boolean completed = false;
    
}
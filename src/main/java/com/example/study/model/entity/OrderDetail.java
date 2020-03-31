package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"user", "item"}) // 연관관계 설정 변수에 대해서는 @Data를 통한 toString() overriding 제외를 시켜줘야 한다.
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    // N : 1
    @ManyToOne
    private User user; // Hibernate를 통한 연관관계 설정 시 반드시 객체를 지정해줘야 한다. 객체를 지정하면 Hibernate에서 알아서 해당 객체의 id를 찾아간다.

    // N : 1
    @ManyToOne
    private Item item;

}

package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // == table
//@Table(name = "user") // 클래스 이름이 테이블 이름과 동일하면 자동으로 mapping 된다.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "account") // 필드의 이름과 테이블 컬럼의 이름이 동일하면 자동으로 mapping 된다.
    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // 1 : N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // mappedBy는 OrderDetail에서 지정한 변수명을 사용한다.
    private List<OrderDetail> orderDetailList;

}

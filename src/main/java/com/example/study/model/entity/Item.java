package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private String content;

    // 1 : N
    /*
        fetch type
          - LAZY = 지연 로딩
            - select * from item where id = ?
            - 연관 관계가 설정된 테이블에 대해 SELECT 를 하지 않겠다.
            - LAZY type은 여러 가지 데이터가 로딩될 수 있을 때 사용하길 추천한다.

          - EAGER = 즉시 로딩
            - JOIN
            - item_id = order_detail.item_id and user_id = order_detail.user_id where item.id = ?
            - 연관 관계가 설정된 모든 테이블에 대해 JOIN이 발생한다.
            - 성능 저하 발생 가능성이 있다.
            - EAGER type은 한 건만 존재할 때(ex. 1:1, N:1 등) 사용하길 추천한다.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;

}

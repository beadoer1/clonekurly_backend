package com.sparta.clonekurly.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private Long no;// 상품 번호 - str
    @Column(nullable = false)
    private String name;  // 제목 - str
    @Column
    private String short_description; // 상품설명(제목 아래 있는거) - str
    @Column
    private String long_description;// 상품설명(상세) - img list?
    @Column
    private String tags; // 매대에 tag 붙일 때 사용 ex) {names: ["Kurly Only"], types: [{type: "kurlyonly", names: ["Kurly Only"]}]} - dict
    @Column
    private Boolean is_shown;  // 보여줄지 말지?? - boolean
    @Column
    private Long sales_unit; // 판매 단위 - int
    @Column
    private String unit_text;// 판매단위 text
    @Column
    private String weight; // 무게 표시 - str
    @Column
    private String origin; // 원산지 - str
    @Column
    private String contactant; // 알레르기 유발 물질 - str
    @Column
    private String expiration_date;// 유통기한 text - str
    @Column
    private String extended_infos; // 늘어난 정보들?-_-;; - list
    @Column
    private String guides;// 무슨 가이드인지 모르겠음 - list
    @Column
    private Boolean is_expected_point; // 예상 적립 포인트가 있는지?, login 하면 바뀜 - boolean
    @Column
    private Long expected_point; // 예상 포인트, login 하면 바뀜
    @Column
    private Long expected_point_ratio; // 예상 포인트 율, login 하면 바뀜
    @Column
    private String delivery_time_type_text; // 배송 시간 ex) 샛별배송/택배배송 text - str
    @Column
    private String packing_type_text; // 포장 방법 text - str
    @Column
    private Long delivery_type; // 배송 방법 type - int
    @Column
    private Long delivery_price; // 배송 요금 - int
    @Column
    private String delivery_price_text; // 배송 요금 text - str
    @Column
    private Long buyable_kind; // 살 수 있는 종류 ?? - int
    @Column
    private Long original_price; // 실제 가격 - int
    @Column
    private Long discounted_price; // 할인가 - int
    @Column
    private Long discount_percent; // 할인율 - int
    @Column
    private Boolean is_sold_out; // 품절 여부 - boolean
    @Column
    private String sold_out_text; // 품절 text - str
    @Column
    private String original_image_url; // 상세 페이지에 사용되는 img - url
    @Column
    private String main_image_url; // 카드 페이지에 사용되는 img - url
    @Column
    private Boolean is_package; // 패키지인지 - boolean
    @Column
    private Long package_type; // 패키지 타입 - int
    @Column
    private String package_products; // 패키지 상품 - list
}

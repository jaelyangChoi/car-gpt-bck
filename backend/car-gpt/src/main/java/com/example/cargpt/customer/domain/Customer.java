package com.example.cargpt.customer.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity //실제 DB의 테이블과 1:1로 매핑되는 클래스
@Table(name = "CRMC_CSMR_M")
public class Customer {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 알아서 생성해주는 전략
    @Column(name = "CSMR_MGMT_NO")
    String csmrMgmtNo;                /*고객관리번호*/
    @Column(name = "CSMR_NM")
    String csmrNm;                    /*고객명*/
    @Column(name = "SMS_RCPM_YN")
    String csmrTymdNo;                /*SMS수신동의여부*/
    @Column(name = "EML_RCPM_YN")
    String telNum;                    /*이메일수신동의여부*/
    @Column(name = "TLM_RCPM_YN")
    String tnUsblScnCd;               /*전화수신동의여부*/
    @Column(name = "INP_EENO")
    String inpEeno;                   /*입력자사원번호*/
    @Column(name = "INP_DTM")
    String inpDtm;                    /*입력일시*/
    @Column(name = "CHGR_EENO")
    String chgrEeno;                  /*변경자사원번호*/
    @Column(name = "ALTR_DTM")
    String altrDtm;                   /*변경일시*/

}

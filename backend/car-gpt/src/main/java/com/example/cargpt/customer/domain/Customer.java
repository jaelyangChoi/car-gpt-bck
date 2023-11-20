package com.example.cargpt.customer.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity //실제 DB의 테이블과 1:1로 매핑되는 클래스
@Table(name = "CRMC_PSN_CSMR_I")
public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 알아서 생성해주는 전략
    @Column(name = "CSMR_MGMT_NO")
    String csmrMgmtNo;                /*고객관리번호*/
    @Column(name = "SEX_CD")
    String sexCd;                /*성별코드*/
    @Column(name = "CSMR_TYMD_NO")
    String csmrTymdNo;                /*생년월일*/
    @Column(name = "TEL_NUM")
    String telNum;                    /*휴대폰번호*/
    @Column(name = "TN_USBL_SCN_CD")
    String tnUsblScnCd;                /*휴대폰번호가용여부*/
    @Column(name = "EML_ADR")
    String emlAdr;                    /*이메일주소*/
    @Column(name = "EML_USBL_SCN_CD")
    String emlUsblScnCd;            /*이메일주소가용여부*/
    @Column(name = "RDNM_ADR")
    String rdnmAdr;                    /*주소*/
    @Column(name = "RDNM_USBL_SCN_CD")
    String rdnmUsblScnCd;            /*주소가용여부*/
    @Column(name = "WKPL_NM")
    String wkplNm;                    /*직장명*/
    @Column(name = "OPS_NM")
    String opsNm;                    /*부서명*/
    @Column(name = "POA_NM")
    String poaNm;                    /*직위명*/
    @Column(name = "FAM_TYP_CD")
    String famTypCd;                /*가족유형코드*/
    @Column(name = "MARI_YN")
    String mariYn;                    /*결혼여부*/
    @Column(name = "CSMR_CHT_CPSN")
    String csmrChtSpsn;                /*자녀수*/
    @Column(name = "CSMR_PRE_CAR_CD")
    String csmrPreCarCd;            /*이전차량코드*/
    @Column(name = "CAR_HLDG_CNT")
    String carHldgCnt;                /*차량보유대수*/
    @Column(name = "CAR_CHNG_PRD")
    String carChngPrd;                /*차량교체주기(일)*/
    @Column(name = "EXRS_EE_EENO")
    String exrsEeEeno;                /*전담사원번호*/
    @Column(name = "IPE_EENO")
    String ipeEeno;                    /*입력자사원번호*/
    @Column(name = "INP_DTM")
    String inpDtm;                    /*입력일시*/
    @Column(name = "CHGR_EENO")
    String chgrEeno;                /*변경자사원번호*/
    @Column(name = "ALTR_DTM")
    String altrDtm;                    /*변경일시*/
}



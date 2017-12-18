package entity;

import java.util.Date;

/**
 * Ecrparts entity. @author MyEclipse Persistence Tools
 */

public class Ecrparts implements java.io.Serializable {

	// Fields

	private Long id;
	private String xinghao;
	private String fruid;
	private String gongchang;
	private Double chuchangprice;
	private Date chuchangdate;
	private String jingxiao;
	private Date fapiaodate;
	private Double fapiaoprice;
	private Date baoxiudate;
	private String fulu;

	// Constructors

	/** default constructor */
	public Ecrparts() {
	}

	/** full constructor */
	public Ecrparts(Long id, String xinghao, String fruid, String gongchang,
			Double chuchangprice, Date chuchangdate, String jingxiao,
			Date fapiaodate, Double fapiaoprice, Date baoxiudate, String fulu) {
		this.id = id;
		this.xinghao = xinghao;
		this.fruid = fruid;
		this.gongchang = gongchang;
		this.chuchangprice = chuchangprice;
		this.chuchangdate = chuchangdate;
		this.jingxiao = jingxiao;
		this.fapiaodate = fapiaodate;
		this.fapiaoprice = fapiaoprice;
		this.baoxiudate = baoxiudate;
		this.fulu = fulu;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getXinghao() {
		return this.xinghao;
	}

	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}

	public String getFruid() {
		return this.fruid;
	}

	public void setFruid(String fruid) {
		this.fruid = fruid;
	}

	public String getGongchang() {
		return this.gongchang;
	}

	public void setGongchang(String gongchang) {
		this.gongchang = gongchang;
	}

	public Double getChuchangprice() {
		return this.chuchangprice;
	}

	public void setChuchangprice(Double chuchangprice) {
		this.chuchangprice = chuchangprice;
	}

	public Date getChuchangdate() {
		return this.chuchangdate;
	}

	public void setChuchangdate(Date chuchangdate) {
		this.chuchangdate = chuchangdate;
	}

	public String getJingxiao() {
		return this.jingxiao;
	}

	public void setJingxiao(String jingxiao) {
		this.jingxiao = jingxiao;
	}

	public Date getFapiaodate() {
		return this.fapiaodate;
	}

	public void setFapiaodate(Date fapiaodate) {
		this.fapiaodate = fapiaodate;
	}

	public Double getFapiaoprice() {
		return this.fapiaoprice;
	}

	public void setFapiaoprice(Double fapiaoprice) {
		this.fapiaoprice = fapiaoprice;
	}

	public Date getBaoxiudate() {
		return this.baoxiudate;
	}

	public void setBaoxiudate(Date baoxiudate) {
		this.baoxiudate = baoxiudate;
	}

	public String getFulu() {
		return this.fulu;
	}

	public void setFulu(String fulu) {
		this.fulu = fulu;
	}

}
package com.warrior.eem.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.warrior.eem.annotation.FieldChecker;
import com.warrior.eem.entity.constant.PowerConsts;

/**
 * 电量创建vo
 * 
 * @author seangan
 *
 */
public class PowerDataVo implements Serializable {

	private static final long serialVersionUID = -5716740087717124317L;
	
	private Long id;

	@FieldChecker(name = "电力用户id", minVal = 1, maxVal = Long.MAX_VALUE)
	private Long customerId;

	@FieldChecker(name = "用户户号", minLen = 1, maxLen = 30)
	private String customerNo;

	@FieldChecker(name = "电表编号", minLen = 1, maxLen = 20)
	private String emNo;

	@FieldChecker(name = "月份", minLen = 1, maxLen = 6)
	private String month;

	@FieldChecker(name = "电压", minLen = 1, maxLen = 10)
	private String voltageType;

	@FieldChecker(name = "高峰用电量", minVal = 0.0001, maxVal = PowerConsts.MAX_POWER_VALUE)
	private BigDecimal peakKwh;

	@FieldChecker(name = "平段用电量", minVal = 0.0001, maxVal = PowerConsts.MAX_POWER_VALUE)
	private BigDecimal flatKwh;

	@FieldChecker(name = "低谷用电量", minVal = 0.0001, maxVal = PowerConsts.MAX_POWER_VALUE)
	private BigDecimal troughKwh;

	@FieldChecker(name = "无功电量", minVal = 0, maxVal = PowerConsts.MAX_POWER_VALUE)
	private BigDecimal idleKwh;

	@FieldChecker(name = "交易品种", minLen = 1, maxLen = 10)
	private String tradeType;

	public PowerDataVo() {

	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public String getEmNo() {
		return emNo;
	}

	public String getMonth() {
		return month;
	}

	public String getVoltageType() {
		return voltageType;
	}

	public BigDecimal getPeakKwh() {
		return peakKwh;
	}

	public BigDecimal getFlatKwh() {
		return flatKwh;
	}

	public BigDecimal getTroughKwh() {
		return troughKwh;
	}

	public BigDecimal getIdleKwh() {
		return idleKwh;
	}

	public String getTradeType() {
		return tradeType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public void setEmNo(String emNo) {
		this.emNo = emNo;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setVoltageType(String voltageType) {
		this.voltageType = voltageType;
	}

	public void setPeakKwh(BigDecimal peakKwh) {
		this.peakKwh = peakKwh;
	}

	public void setFlatKwh(BigDecimal flatKwh) {
		this.flatKwh = flatKwh;
	}

	public void setTroughKwh(BigDecimal troughKwh) {
		this.troughKwh = troughKwh;
	}

	public void setIdleKwh(BigDecimal idleKwh) {
		this.idleKwh = idleKwh;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

}

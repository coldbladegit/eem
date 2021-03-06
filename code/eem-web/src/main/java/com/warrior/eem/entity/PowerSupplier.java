package com.warrior.eem.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.warrior.eem.annotation.EntityUniqueConstraint;

/**
 * 电力供应商
 * 
 * @author seangan
 *
 */
@Entity
@Table(name = "power_supplier")
@EntityUniqueConstraint(columns = { "name" }, errorMessage = "名称不能重复")
public class PowerSupplier extends AbstractEntity {

	private static final long serialVersionUID = 8531812174486012714L;

	@Column(name = "name")
	private String name;

	@Column(name = "nick_name")
	private String nickName;

	@Column(name = "power_type")
	private int powerType;

	@Column(name = "capacity")
	private BigDecimal capacity;

	@Column(name = "province")
	private String province;

	@Column(name = "city")
	private String city;

	@Column(name = "address")
	private String address;

	@Column(name = "nature_type")
	private int natureType;

	@Column(name = "contact_name")
	private String contactName;

	@Column(name = "contact_phone")
	private String contactPhone;

	@Column(name = "contact_position")
	private String contactPosition;

	@Column(name = "contact_email")
	private String contactEmail;

	@Column(name = "fax")
	private String fax;

	@Column(name = "create_time")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User creator;

	public PowerSupplier() {

	}

	public String getName() {
		return name;
	}

	public String getNickName() {
		return nickName;
	}

	public int getPowerType() {
		return powerType;
	}

	public BigDecimal getCapacity() {
		return capacity;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public int getNatureType() {
		return natureType;
	}

	public String getContactName() {
		return contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public String getContactPosition() {
		return contactPosition;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public String getFax() {
		return fax;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public User getCreator() {
		return creator;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setPowerType(int powerType) {
		this.powerType = powerType;
	}

	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNatureType(int natureType) {
		this.natureType = natureType;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public void setContactPosition(String contactPosition) {
		this.contactPosition = contactPosition;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
}

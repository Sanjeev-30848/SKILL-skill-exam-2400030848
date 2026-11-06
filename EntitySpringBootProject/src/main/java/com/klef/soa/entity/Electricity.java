package com.klef.soa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "electricity_table")
public class Electricity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ebid")
	private Long electricityBillId;
	
	@Column(name = "ebholdername", length = 100, nullable = false)
	private String holderName;
	
	@Column(name = "ebtype", nullable = false)
	private String type;
	
	@Column(name = "ebstatus",nullable = false)
	private String status;
	
	@Column(name = "eblocation", nullable = false)
	private String location;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	public Long getElectricityBillId() 
	{
		return electricityBillId;
	}
	public void setElectricityBillId(Long electricityBillId) {
		this.electricityBillId = electricityBillId;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "Electricity [electricityBillId=" + electricityBillId + ", holderName=" + holderName + ", type=" + type
				+ ", status=" + status + ", location=" + location + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
}

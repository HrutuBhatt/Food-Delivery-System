package com.javaproject.FoodDelivery.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "delivery_man")
public class DeliveryMan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="delivery_man_id")
    private Integer deliveryManId;
    @Column(name="name")
    private String name;
    @Column(name="phone")
    private String phone;
	public Integer getDeliveryManId() {
		return deliveryManId;
	}
	public void setDeliveryManId(Integer deliveryManId) {
		this.deliveryManId = deliveryManId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public DeliveryMan() {
		
	}
	public DeliveryMan(Integer deliveryManId, String name, String phone) {
		this.deliveryManId = deliveryManId;
		this.name = name;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "DeliveryMan [deliveryManId=" + deliveryManId + ", name=" + name + ", phone=" + phone + "]";
	}
}
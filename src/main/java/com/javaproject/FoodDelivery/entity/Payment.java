package com.javaproject.FoodDelivery.entity;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;

    private String paymentMethod;
    private Integer amount;
    private Timestamp paymentDate;
    
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Payment(Integer paymentId, Order order, String paymentMethod, Integer amount, Timestamp paymentDate) {
		super();
		this.paymentId = paymentId;
		this.order = order;
		this.paymentMethod = paymentMethod;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	public Payment() {
		
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", order=" + order + ", paymentMethod=" + paymentMethod + ", amount="
				+ amount + ", paymentDate=" + paymentDate + "]";
	}

   
}
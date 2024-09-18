package com.javaproject.FoodDelivery.entity;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

	private Timestamp orderDate;
    private Integer totalAmount;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "deliveryManId")
    private DeliveryMan deliveryMan;

    @OneToMany(mappedBy="order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<OrderItem> orderItems;
    
    public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
//		this.totalAmount = totalAmount;
	}

	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

	public Order(Integer orderId, User user, Timestamp orderDate, Integer totalAmount, DeliveryMan deliveryMan) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.deliveryMan = deliveryMan;
	}
	
	public List<OrderItem> getOrderItems() {
        return orderItems;
    }
	
	public Order() {
		
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + ", deliveryMan=" + deliveryMan + ", orderItems=" + orderItems+ "]";
	}
	
    
}
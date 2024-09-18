package com.javaproject.FoodDelivery.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "Items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Integer itemId;
    @Column(name="itemName")
    private String itemName;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private Integer price;
    @Column(name="available")
    private boolean available;
    
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId2) {
		this.itemId = itemId2;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Item(Integer itemId, String itemName, String description, Integer price, boolean available) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.available = available;
	}
	public Item() {
		
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", description=" + description + ", price=" + price
				+ ", available=" + available + "]";
	}

    
}
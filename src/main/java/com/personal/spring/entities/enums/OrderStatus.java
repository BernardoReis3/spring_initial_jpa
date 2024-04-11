package com.personal.spring.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELLEED(5);
	
	private int statusId;
	
	private OrderStatus(int id) {
		this.statusId = id;
	}
	
	public int getStatusId() {
		return statusId;
	}
	
	public static OrderStatus convertToStatus(int id) {
		for (OrderStatus os : OrderStatus.values()) {
			if(os.getStatusId() == id)
				return os;
		}
		throw new IllegalArgumentException("The status id provided is not valid");
	}

}

package service;

import java.util.List;

import dao.entity.OrderBase;

public interface OrderBaseService {
	List<OrderBase> getAllOrder();
	String add(String ordersn,Integer bid,Integer count);
	String deleteOrderBase(OrderBase orderBase);
}

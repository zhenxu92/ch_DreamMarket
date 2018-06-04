package service;

import java.util.List;

import dao.entity.OrderDetail;

public interface OrderdetailService {
	String add(String ordersn,String []gno,Integer []shoppingnumList);
	List<OrderDetail> selectOrderdetails(Integer bid);
}

package dao;

import java.sql.SQLException;
import java.util.List;

import dao.entity.OrderBase;
public interface OrderBaseDAO {
	List<OrderBase> select() throws SQLException;
	int insert(String ordersn,Integer bid,Integer count)throws SQLException;
	int deleteOrder(OrderBase orderBase) throws  SQLException;
}

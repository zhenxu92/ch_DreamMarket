package dao;
import java.sql.SQLException;
import java.util.List;
import dao.entity.OrderDetail;
public interface OrderdetailDAO {
	int insert(String ordersn,String []gnoList,Integer []shoppingnumList) throws SQLException;
	List<OrderDetail> select(Integer bid) throws SQLException;
}

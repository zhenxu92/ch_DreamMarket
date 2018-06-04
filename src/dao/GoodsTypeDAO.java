package dao;

import java.sql.SQLException;
import java.util.List;
import dao.entity.GoodsType;
public interface GoodsTypeDAO {
	List<GoodsType> select() throws SQLException;
}

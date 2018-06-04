package dao;
import java.sql.SQLException;
import java.util.List;

import dao.entity.Buser;
public interface BuserDAO {
	List<Buser> select() throws SQLException;
	boolean select(Buser buser) throws SQLException;
	int deleteBuser(Buser buser) throws  SQLException;
	int insertBuser(Buser buser) throws SQLException;
}

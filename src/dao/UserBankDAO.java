package dao;
import java.sql.SQLException;

import dao.entity.UserBank;
public interface UserBankDAO {
	boolean select(UserBank userBank) throws SQLException;
}

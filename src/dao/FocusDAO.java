package dao;

import java.sql.SQLException;
import java.util.List;

import dao.entity.Focus;

public interface FocusDAO {
	List<Focus> selectFocusGood(String bemail) throws SQLException;
	int addFocusGood(Integer bid,String gno) throws SQLException;
}

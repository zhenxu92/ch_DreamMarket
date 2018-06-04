package dao;

import java.sql.SQLException;

import dao.entity.Auser;

public interface AuserDAO {
	boolean select(Auser auser) throws SQLException;

}

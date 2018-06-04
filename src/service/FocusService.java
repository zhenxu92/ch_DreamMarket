package service;

import java.util.List;



import dao.entity.Focus;

public interface FocusService {
	List<Focus> getFocusGood(String bemail);
	String add(Integer bid,String gno);
}

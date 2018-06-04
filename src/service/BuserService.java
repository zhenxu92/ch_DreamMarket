package service;
import java.util.List;

import dao.entity.Buser;
public interface BuserService {
	List<Buser> getBusers();
	String login(Buser buser);
	String deleteBuser(Buser buser);
	String addBuser(Buser buser);
}

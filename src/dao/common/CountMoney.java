package dao.common;

public class CountMoney {
	public static Integer countmoney(Integer shoppingnum,Integer amount){
		if(shoppingnum == null||amount==null){
			return null;
		}
		return amount*shoppingnum;
	}
	
}

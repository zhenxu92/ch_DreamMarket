package service;

import java.util.List;

import dao.entity.Goods;

public interface GoodsPageService {
	List<Goods> PagingSelect(int startIndex, int endIndex);
	int GoodsCountingSelect();
	List<Goods> PagingSelectByGnameOrType(int startIndex, int endIndex,String gname,Integer typeid);
	int GoodsCountSelectByGnameOrType(String gname,Integer typeid);
}

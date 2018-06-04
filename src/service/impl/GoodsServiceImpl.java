package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import service.GoodsService;
import dao.GoodsDAO;
import dao.common.DBUtil;
import dao.entity.Goods;
import dao.impl.DAOFactory;

class GoodsServiceImpl implements service.GoodsService {
	
	public String add(Goods goods) {
		Connection connection = DBUtil.getConnection();
		GoodsDAO goodsDAO = DAOFactory.getGoodsDAO(connection);
		int result = 0;
		String message= null;
		try {
			result = goodsDAO.insert(goods);
			if (result == 0) {
				message = "添加失败，请稍后再试！";
			}else if(result == 2){
				message = "商品编号已存在，请选择其他编号";
			}else if(result == 3){
				message = "商品折扣价不能大于商品价格";
			}
			
		} catch (SQLException e) {
			message = "系统繁忙，请稍后重试";
			e.printStackTrace();
		}
		return message;
	}
	public List<Goods> selectGoods() {
		List<Goods> selectGoods = null;
		Connection connection = DBUtil.getConnection();
		GoodsDAO goodsDAO = DAOFactory.getGoodsDAO(connection);
		try {
			selectGoods = goodsDAO.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return selectGoods;
	}
	
	public List<Goods> selectChoisedGoods(Goods goods) {
		List<Goods> selectChoisedGoods = null;
		Connection connection = DBUtil.getConnection();
		GoodsDAO goodsDAO = DAOFactory.getGoodsDAO(connection);
		try {
			selectChoisedGoods = goodsDAO.selectChoisedGoods(goods);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return selectChoisedGoods;
	}

	public Goods selectGoodsDetails(String gno) {
		Goods goods = new Goods();
		Connection connection = DBUtil.getConnection();
		GoodsDAO goodsDAO = DAOFactory.getGoodsDAO(connection);
		try {
			goods = goodsDAO.selectGoodsDetails(gno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}
	public int update(Goods goods) {
		Connection connection = DBUtil.getConnection();
		GoodsDAO goodsDAO = DAOFactory.getGoodsDAO(connection);
		int result = 0;
		try {
			result = goodsDAO.update(goods);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	public List<Goods> vagueGetGoods(String gname,Integer typeid) {
		List<Goods> selectGoods = null;
		Connection connection = DBUtil.getConnection();
		GoodsDAO goodsDAO = DAOFactory.getGoodsDAO(connection);
		try {
			selectGoods = goodsDAO.select2(gname,typeid);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(connection);
		}
		return selectGoods;
	}
	public String deleteGoods(Goods goods) {
		Connection connection = DBUtil.getConnection();
		GoodsDAO goodsDAO = DAOFactory.getGoodsDAO(connection);
		String message = null;
		
		try {
			int result = goodsDAO.deleteGoods(goods);
			if(result == 0){
				message="商品删除失败";
			}
			if(result == 2){
				message="无法删除已经存在用户购物车中的商品";
			}
			if(result == 3){
				message="无法删除用户已下单还未派送的商品";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return message;
		
	}
	public String selectGno(String gno) {
		Connection connection = DBUtil.getConnection();
		GoodsDAO goodsDAO = DAOFactory.getGoodsDAO(connection);
		String message = "商品编号不存在，可以添加。";
		try {
			boolean exists = goodsDAO.selectGno(gno);
			if(exists == true){
				message = "您添加的商品编号已存在";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
	
	public static void main(String[] args) {
		GoodsService goodsService = new GoodsServiceImpl();
		Goods goods = new Goods();
		
		
		goods = goodsService.selectGoodsDetails("#05880101");
		System.out.println(goods.getGname()+" "+goods.getGoprice());
	}
	public String updateGstore(String gno, Integer shoppingnum) {
		Connection connection = DBUtil.getConnection();
		GoodsDAO goodsDAO = DAOFactory.getGoodsDAO(connection);
		String message= null;
		try {
			goodsDAO.updateGstore(gno, shoppingnum);
		} catch (SQLException e) {
			message = "系统繁忙，请稍后重试";
			e.printStackTrace();
		}
		return message;
	}
	
	
}

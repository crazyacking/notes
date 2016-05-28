package com.ht.gwc;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;
/**
 * 具体的购物车
 * @author ZERO
 */
public class Gwc {
	Hashtable<Integer, GwcItem> gwcItems = new Hashtable<Integer, GwcItem>();
	
	/**
	 * 得到购物车中所有商品集合
	 * @return
	 */
	public Collection<GwcItem> getItems() {
		return gwcItems.values();
	}
	
	/**
	 * 往购物车中添加一种商品,两种情况,第一:购物车中还没有这种商品,直接添加  第二种,有了,数量加一
	 * @param item
	 */
	public void addBook(GwcItem item) {
		//返回所有键的集合,也就是购物车中所有商品编号的集合
		Set<Integer> ids = (Set<Integer>) gwcItems.keySet();
		//得到要新增商品的编号
		Integer itemId = item.getBookId();
		//查看此编号是否在原有编号集合中
		if(ids.contains(itemId)) {
			GwcItem oldGwcItem = gwcItems.get(itemId); //得到原始商品
			oldGwcItem.setNum(oldGwcItem.getNum() + 1); //数量加一
			gwcItems.put(itemId, oldGwcItem);			//把老商品覆盖
		} else {//没有,直接放
			gwcItems.put(itemId, item);
		}
	}
	
	/**
	 * 修改购物车中某种商品的数量
	 * @param id 要修改的商品编号
	 * @param num 具体数量
	 */
	public void updateNum(int id, int num) {
		GwcItem oldGwcItem = gwcItems.get(id);
		oldGwcItem.setNum(num);
		gwcItems.put(id, oldGwcItem);
	}
	
	/**
	 * 删除购物车中某种商品
	 * @param id
	 */
	public void delete(int id) {
		gwcItems.remove(id);
	}
	
	/**
	 * 清空购物车
	 */
	public void clear() {
		gwcItems.clear();
	}
	
	
	/**
	 * 数组下标0中 放置原始价格   
	 * 数组下标1中 放置特价
	 * @return
	 */
	public double[] getSumPrice() {
		double[] prices = new double[]{0 , 0};
		Collection<GwcItem> items = gwcItems.values();
		for(GwcItem gwcItem : items) {
			 prices[0] += gwcItem.getPrice() * gwcItem.getNum();
			 prices[1] += gwcItem.getSpecialPrice() * gwcItem.getNum();
		}
		return prices;
	}
	public int getNum() {
		int num = 0;
		Collection<GwcItem> items = gwcItems.values();
		for(GwcItem gwcItem :items) {
			num += gwcItem.getNum();
		}
		return num;
	}
}

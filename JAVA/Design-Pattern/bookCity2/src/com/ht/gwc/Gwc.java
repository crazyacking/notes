package com.ht.gwc;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;
/**
 * ����Ĺ��ﳵ
 * @author ZERO
 */
public class Gwc {
	Hashtable<Integer, GwcItem> gwcItems = new Hashtable<Integer, GwcItem>();
	
	/**
	 * �õ����ﳵ��������Ʒ����
	 * @return
	 */
	public Collection<GwcItem> getItems() {
		return gwcItems.values();
	}
	
	/**
	 * �����ﳵ�����һ����Ʒ,�������,��һ:���ﳵ�л�û��������Ʒ,ֱ�����  �ڶ���,����,������һ
	 * @param item
	 */
	public void addBook(GwcItem item) {
		//�������м��ļ���,Ҳ���ǹ��ﳵ��������Ʒ��ŵļ���
		Set<Integer> ids = (Set<Integer>) gwcItems.keySet();
		//�õ�Ҫ������Ʒ�ı��
		Integer itemId = item.getBookId();
		//�鿴�˱���Ƿ���ԭ�б�ż�����
		if(ids.contains(itemId)) {
			GwcItem oldGwcItem = gwcItems.get(itemId); //�õ�ԭʼ��Ʒ
			oldGwcItem.setNum(oldGwcItem.getNum() + 1); //������һ
			gwcItems.put(itemId, oldGwcItem);			//������Ʒ����
		} else {//û��,ֱ�ӷ�
			gwcItems.put(itemId, item);
		}
	}
	
	/**
	 * �޸Ĺ��ﳵ��ĳ����Ʒ������
	 * @param id Ҫ�޸ĵ���Ʒ���
	 * @param num ��������
	 */
	public void updateNum(int id, int num) {
		GwcItem oldGwcItem = gwcItems.get(id);
		oldGwcItem.setNum(num);
		gwcItems.put(id, oldGwcItem);
	}
	
	/**
	 * ɾ�����ﳵ��ĳ����Ʒ
	 * @param id
	 */
	public void delete(int id) {
		gwcItems.remove(id);
	}
	
	/**
	 * ��չ��ﳵ
	 */
	public void clear() {
		gwcItems.clear();
	}
	
	
	/**
	 * �����±�0�� ����ԭʼ�۸�   
	 * �����±�1�� �����ؼ�
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

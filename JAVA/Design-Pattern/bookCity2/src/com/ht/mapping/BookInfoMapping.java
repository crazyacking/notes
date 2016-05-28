package com.ht.mapping;
import java.sql.ResultSet;
import com.ht.db.IResutlSetMapping;
import com.ht.entity.BookInfo;

public class BookInfoMapping implements IResutlSetMapping {
	/**
	 * 将数据库中的 一条图书信息的结果集转化为对象返回
	 */
	@Override
	public BookInfo mapping(ResultSet rs) throws Exception {
		int i = 1;
		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookId(rs.getInt(i++));
		bookInfo.setBookName(rs.getString(i++));
		bookInfo.setBookTypeId(rs.getInt(i++));
		bookInfo.setPublishName(rs.getString(i++));
		bookInfo.setAuthor(rs.getString(i++));
		bookInfo.setContext(rs.getString(i++));
		bookInfo.setSmallImg(rs.getString(i++));
		bookInfo.setBigImg(rs.getString(i++));
		bookInfo.setPrice(rs.getFloat(i++));
		bookInfo.setPublishDate(rs.getDate(i++));
		bookInfo.setBookStates(rs.getInt(i++));
		bookInfo.setSpecialPrice(rs.getFloat(i++));
		return bookInfo;
	}
}

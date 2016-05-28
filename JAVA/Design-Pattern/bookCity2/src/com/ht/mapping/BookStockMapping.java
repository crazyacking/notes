package com.ht.mapping;

import java.sql.ResultSet;

import com.ht.db.IResutlSetMapping;
import com.ht.entity.BookStock;

public class BookStockMapping implements IResutlSetMapping {

	@Override
	public Object mapping(ResultSet rs) throws Exception {
		int i = 1;
		BookStock bookStock = new BookStock(rs.getInt(i++), rs.getInt(i++), rs.getInt(i++), rs.getInt(i++));
		return bookStock;
	}

}

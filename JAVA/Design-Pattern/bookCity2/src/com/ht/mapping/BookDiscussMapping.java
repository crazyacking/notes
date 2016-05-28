package com.ht.mapping;

import java.sql.ResultSet;

import com.ht.db.IResutlSetMapping;
import com.ht.entity.BookDiscuss;

public class BookDiscussMapping implements IResutlSetMapping {

	@Override
	public Object mapping(ResultSet rs) throws Exception {
		int i = 1;
		BookDiscuss bookDicuss = new BookDiscuss(rs.getInt(i++), rs.getInt(i++), rs.getInt(i++), rs.getString(i++), rs.getDate(i++), rs.getInt(i++));
		return bookDicuss;
	}
	
}

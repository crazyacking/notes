package com.ht.mapping;

import java.sql.ResultSet;

import com.ht.db.IResutlSetMapping;
import com.ht.entity.BookType;

public class BookTypeMapping implements IResutlSetMapping {

	public BookType mapping(ResultSet rs) throws Exception {
		BookType bookType = new BookType();
		bookType.setBookTypeId(rs.getInt("bookTypeId"));
		bookType.setParentId(rs.getInt("ParentId"));
		bookType.setBookTypeName(rs.getString("bookTypeName"));
		bookType.setIsDelete(rs.getInt("isDelete"));
		bookType.setContext(rs.getString("context"));
		return bookType;
	}

}

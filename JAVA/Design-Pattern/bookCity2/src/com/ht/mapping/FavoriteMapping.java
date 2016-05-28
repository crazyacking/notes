package com.ht.mapping;

import java.sql.ResultSet;

import com.ht.db.IResutlSetMapping;
import com.ht.entity.Favorite;

public class FavoriteMapping implements IResutlSetMapping {
	@Override
	public Object mapping(ResultSet rs) throws Exception {
		int i = 1;
		Favorite favorite = new Favorite(rs.getInt(i++), rs.getInt(i++), rs.getInt(i++), rs.getDate(i++));
		return favorite;
	}
}

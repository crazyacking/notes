package com.ht.dao;

import java.util.List;

import com.ht.dao.base.GenericDAO;
import com.ht.entity.Favorite;

public interface FavoriteDAO extends GenericDAO<Favorite> {
	List<Favorite> findByCustomerId(int customerId);
	Favorite findByBookId(int bookId, int customerId);
	boolean delete(String ids);
}

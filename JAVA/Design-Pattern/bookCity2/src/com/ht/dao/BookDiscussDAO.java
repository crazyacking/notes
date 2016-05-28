package com.ht.dao;

import java.util.List;

import com.ht.dao.base.GenericDAO;
import com.ht.entity.BookDiscuss;

public interface BookDiscussDAO extends GenericDAO<BookDiscuss>{
	List<BookDiscuss> findDiscussByBookId(int bookId);
}

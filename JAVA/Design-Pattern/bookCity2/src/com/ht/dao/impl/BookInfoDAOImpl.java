package com.ht.dao.impl;
import java.util.List;

import com.ht.dao.BookInfoDAO;
import com.ht.entity.BookInfo;
import com.ht.mapping.BookInfoMapping;
import com.ht.util.Tool;

public class BookInfoDAOImpl implements BookInfoDAO {

	/**
	 * 图书信息的新增
	 */
	public boolean save(BookInfo bookInfo) {
		int row = 0;
		String sql = "insert into bookInfo " +
					 "	   (bookName, " +
					 "		bookTypeId," +
					 "	    publishName, " +
					 "		author, " +
					 "		context, " +
					 "		smallImg, " +
					 "		bigImg, " +
					 "		price," +
					 "		publishDate, " +
					 "		bookStates, " +
					 "		specialPrice) " +
					 "values" +
					 "		(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] values = new Object[] {
				bookInfo.getBookName(),
				bookInfo.getBookTypeId(),
				bookInfo.getPublishName(),
				bookInfo.getAuthor(),
				bookInfo.getContext(),
				bookInfo.getSmallImg(),
				bookInfo.getBigImg(),
				bookInfo.getPrice(),
				Tool.convertDateToString(bookInfo.getPublishDate()),
				bookInfo.getBookStates(),
				bookInfo.getSpecialPrice()};
		try {
			row = jdbcTemplate.update(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row == 1;
	}

	/**
	 * 根据ID物理删除图书信息
	 */
	@Override
	public boolean delete(int id) {
		return false;
	}

	/**
	 * 查询所有图书信息
	 */
	@Override
	public List<BookInfo> findAll() {
		String sql = "select " +
					 "		bookId, " +
					 "		bookName," +
					 "		bookTypeId," +
					 "		publishName," +
					 "		author," +
					 "		context," +
					 "		smallImg," +
					 "		bigImg," +
					 "		price," +
					 "		publishDate," +
					 "		bookStates," +
					 "		specialPrice " +
					 "from " +
					 "		bookInfo ";
		List<BookInfo> bookInfos = null;
		try {
			bookInfos = jdbcTemplate.query(sql, new BookInfoMapping());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookInfos;
	}
	
	/**
	 * 根据图书信息的ID号查询该图书信息
	 */
	@Override
	public BookInfo findById(int id) {
		String sql = "select " +
					 "		bookId, " +
					 "		bookName," +
					 "		bookTypeId," +
					 "		publishName," +
					 "		author," +
					 "		context," +
					 "		smallImg," +
					 "		bigImg," +
					 "		price," +
					 "		publishDate," +
					 "		bookStates," +
					 "		specialPrice " +
					 "from " +
					 "		bookInfo " +
					 "where " +
					 "		bookId=" + id;
		List<BookInfo> bookInfos = null;
		try {
			bookInfos = jdbcTemplate.query(sql, new BookInfoMapping());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookInfos.get(0);
	}

		
	/**
	 * 修改图书的状态 
	 * 1表示可用 
	 * 2表示上架 
	 * 3表示不可用
	 * 相当于删除(逻辑删除)
	 */
	@Override
	public boolean updateStates(int states, int id) {
		String sql = "update bookInfo set bookStates = ? where bookId = ?";
		int rows = 0;
		try {
			rows = jdbcTemplate.update(sql, states, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows == 1;
	}

	/**
	 * 图书信息的修改
	 */
	@Override
	public boolean update(BookInfo bookInfo) {
		String sql = "update " +
					 "		bookInfo " +
					 "set " +
					 "		bookName = ?," +
					 "		bookTypeId = ?," +
					 "		publishName = ?," +
					 "		author = ?,	" +
					 "		context = ?," +
					 "		smallImg = ?," +
					 "		bigImg = ?," +
					 "		price = ?," +
					 "		publishDate = ?," +
					 "		bookStates = ?," +
					 "		specialPrice = ?  " +
					 "where" +
					 "		bookId = ?";
		
		Object[] values = new Object[] {
				bookInfo.getBookName(),
				bookInfo.getBookTypeId(),
				bookInfo.getPublishName(),
				bookInfo.getAuthor(),
				bookInfo.getContext(),
				bookInfo.getSmallImg(),
				bookInfo.getBigImg(),
				bookInfo.getPrice(),
				Tool.convertDateToString(bookInfo.getPublishDate()),
				bookInfo.getBookStates(),
				bookInfo.getSpecialPrice(),
				bookInfo.getBookId()};
			int row = 0;
			try {
				row = jdbcTemplate.update(sql, values);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return row == 1;
	}
	
	/**
	 * 获取分页的数目
	 */
	public int getPageCount(int pageSize, int states, int type) {
		int pageCount = 0;
		StringBuffer where = new StringBuffer(" where bookStates ");
		switch (states) {
			case 4:
				where.append(" <> 3 ");break;
			case 5:
				where.append(" <> 4 ");break;
			default:
				where.append(" = " + states);
		}
		
		StringBuffer types = new StringBuffer(" and bookTypeId ");
		
		if(type == 0) {
			types.append(" <> 0 ");
		} else {
			types.append(" = " + type);
		}
		
		String sql = "select count(*) " +
					 "from " +
					 "		bookInfo " + where + types;
		try {
			int rowCount = jdbcTemplate.query(sql.toString());
			pageCount = rowCount / pageSize;
			if(rowCount % pageSize != 0) {
				pageCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageCount;
	}
	
	/**
	 * 重载方法根据图书的状态查询相应的图书
	 */
	@Override
	public List<BookInfo> findAll(int states) {
				StringBuffer where = new StringBuffer(" where bookStates ");
						switch (states) {
							case 4:
								where.append(" <> 3 ");break;
							case 5:
								where.append(" <> 4 ");break;
							default:
								where.append(" = " + states);
						}
						
						String sql = "select " +
						 "		bookId, " +
						 "		bookName," +
						 "		bookTypeId," +
						 "		publishName," +
						 "		author," +
						 "		context," +
						 "		smallImg," +
						 "		bigImg," +
						 "		price," +
						 "		publishDate," +
						 "		bookStates," +
						 "		specialPrice " +
						 "from " +
						 "		bookInfo " + where;
							
						List<BookInfo> bookInfos = null;
						try {
							bookInfos = jdbcTemplate.query(sql.toString(), new BookInfoMapping());
						} catch (Exception e) {
							e.printStackTrace();
						}
						return bookInfos;
	}
	
	public List<BookInfo> getNowPageData(int nowPage, int pageSize, int states, int type) {
		StringBuffer where = new StringBuffer(" where bookStates ");
						switch (states) {
							case 4:
								where.append(" <> 3 ");break;
							case 5:
								where.append(" <> 4 ");break;
							default:
								where.append(" = " + states);
						}	
						
						StringBuffer types = new StringBuffer(" and bookTypeId ");
						if(type == 0) {
							types.append(" <> 0");
						} else {
							types.append(" = " + type);
						}
						
						String sql = "select " +
						 "		top (" + pageSize +
						 ")		bookId, " +
						 "		bookName," +
						 "		bookTypeId," +
						 "		publishName," +
						 "		author," +
						 "		context," +
						 "		smallImg," +
						 "		bigImg," +
						 "		price," +
						 "		publishDate," +
						 "		bookStates," +
						 "		specialPrice " +
						 "from " +
						 "		bookInfo " + where + types +
						 "and " +
						 "		bookId not in" + 
						 "			(select top(" + (nowPage - 1) * pageSize + ") bookId from bookInfo" + where + types + 
						 "			)";
					List<BookInfo> bookInfos = null;
					try {
						bookInfos  = jdbcTemplate.query(sql.toString(), new BookInfoMapping());
					} catch(Exception e) {
						e.printStackTrace();
					}
					return bookInfos;
	}

	/**
	 * 根据图书类别查询属于该类别的图书
	 */
	@Override
	public List<BookInfo> findByTypeId(int id) {
		String sql = "select * from  bookInfo where bookTypeId = " + id;
		List<BookInfo> list = null;
		try {
			list = jdbcTemplate.query(sql, new BookInfoMapping());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	/**
	 * 取得数据库中图书信息的总数
	 */
	@Override
	public int getRowCount(int states, int type) {
		StringBuffer where = new StringBuffer(" where bookStates ");
		switch (states) {
		case 5:
			where.append("<> 4");break;
		default:
			where.append(" = " + states);
		}
		
		StringBuffer types = new StringBuffer(" and bookTypeId ");
		if(type == 0) {
			types.append(" <> 0");
		} else {
			types.append(" = " + type);
		}
		String sql = "select count(*) from bookInfo" + where + types;
		int rowCount = 0;
		try {
			rowCount = jdbcTemplate.query(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	
	/**
	 * 模糊查询出来的数据的总页数
	 */
	@Override
	public int getPageCountByIndex(String bookName, String author, int pageSize, int bookStates) {
		int pageCount = 0;
		int row = 0;
		StringBuffer where = new StringBuffer(" where 1 = 1 and bookStates = " + bookStates);
		if(bookName.length() != 0) {
			where.append(" and bookName like '%" + bookName + "%'");
		}
		if(author.length() != 0) {
			where.append(" and author like '%" + author + "%'");
		}
		
		String sql = "select count(*) from bookInfo" + where;
		try {
			row = jdbcTemplate.query(sql);
			pageCount = row / pageSize;
			if(row % pageSize != 0) {
				pageCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageCount;
	}

	@Override
	public List<BookInfo> getNowPageByAuthorBookName(String bookName, String author, int nowPage, int pageSize, int bookStates) {
		List<BookInfo> bookInfos = null;
		StringBuffer where = new StringBuffer(" where bookStates = " + bookStates);
		if(bookName.length() != 0) {
			where.append(" and bookName like '%" + bookName + "%'");
		}
		if(author.length() != 0) {
			where.append(" and author like '%"+ author + "%'");
		}
		
					String sql = "select " +
					 "		top (" + pageSize +
					 ")		bookId, " +
					 "		bookName," +
					 "		bookTypeId," +
					 "		publishName," +
					 "		author," +
					 "		context," +
					 "		smallImg," +
					 "		bigImg," +
					 "		price," +
					 "		publishDate," +
					 "		bookStates," +
					 "		specialPrice " +
					 "from " +
					 "		bookInfo " + where + 
					 "and " +
					 "		bookId not in" + 
					 "			(select top(" + (nowPage - 1) * pageSize + ") bookId from bookInfo" + where +  
					 "			)";
		
		try {
			 bookInfos = jdbcTemplate.query(sql, new BookInfoMapping());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookInfos;
	}

	@Override
	public List<BookInfo> getPageSizeByAuthorBookName(String bookName, String author, int bookStates) {
		List<BookInfo> bookInfos = null;
		StringBuffer where = new StringBuffer(" where 1 = 1 and bookStates = " + bookStates);
		
		if(bookName.length() != 0) {
			where.append(" and bookName like '%" + bookName + "%'");
		}
		if(author.length() != 0) {
			where.append(" and author like '%" + author + "%'");
		}
		
		String sql = "select * from bookInfo" + where;
		try {
			bookInfos = jdbcTemplate.query(sql, new BookInfoMapping());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookInfos;
	}
}

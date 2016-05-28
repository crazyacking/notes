package com.ht.dao.impl;

import java.util.List;

import com.ht.dao.BookTypeDAO;
import com.ht.entity.BookType;
import com.ht.mapping.BookTypeMapping;

public class BookTypeDAOImpl implements BookTypeDAO {
	
	/**
	 *保存图书类别信息
	 * 
	 */
	public boolean save(BookType bookType) {
		String sql = "insert into bookType (parentId, bookTypeName, isDelete, context) values (?, ?, ?, ?)";
		Object[] values = new Object[] {
				bookType.getParentId(),
				bookType.getBookTypeName(),
				bookType.getIsDelete(),
				bookType.getContext() };
		try {
			return jdbcTemplate.update(sql, values) == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 物理删除图书类别信息
	 */
	public boolean delete(int id) {
		String sql = "delete from bookType where bookTypeId =" + id;
		try {
			return jdbcTemplate.update(sql) == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 逻辑删除图书类别信息  
	 * 1表示图书类别可以用
	 * 2表示图书类别不可用
	 */
	public boolean updateStates(int id) {
		String sql = "update bookType set isDelete = 2 where bookTypeId =" + id;
		try {
			return jdbcTemplate.update(sql) == 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改图书类别信息
	 */
	public boolean update(BookType bookType) {
		
		String sql = "update " +
					 "		bookType " +
					 "set" +
					 "		 parentId = ?, " +
					 "		bookTypeName = ?, " +
					 "		isDelete = ?, " +
					 "		context = ? " +
					 "where " +
					 "		bookTypeId = ?";
		
		Object[] values = new Object[] {
			bookType.getParentId(),
			bookType.getBookTypeName(),
			bookType.getIsDelete(),
			bookType.getContext(),
			bookType.getBookTypeId()};
		
		int row = 0;
		try {
			 row = jdbcTemplate.update(sql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1 == row;
	}

	
	/**
	 * 查询所有图书类别信息
	 */
	public List<BookType> findAll() {
		String sql = "select bookTypeId, parentId, bookTypeName, isDelete, context  from bookType";
		List<BookType> bookTypes = null;
		try {
			bookTypes = (List<BookType>) jdbcTemplate.query(sql, new BookTypeMapping());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookTypes;
	}

	
	/**
	 * 根据ID查询单个图书类别信息
	 */
	public BookType findById(int id) {
		BookType bookType = null;
		String sql = "select bookTypeId, parentId, bookTypeName, isDelete, context  from bookType where bookTypeId = ?";
		try {
			
			bookType = (BookType)jdbcTemplate.query(sql, new BookTypeMapping(), id).get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookType;
	}

	/**
	 * 查询属于该类别信息下的所有子类别信息
	 */
	@Override
	public List<BookType> findByParentId(int id) {
		String sql = "select bookTypeId, parentId, bookTypeName, isDelete, context from bookType where parentId =" + id;
		List<BookType> bookTypes = null;
		try {
			bookTypes = jdbcTemplate.query(sql, new BookTypeMapping());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookTypes;
	}

	
	@Override
	public List<BookType> getNowPageData(int nowPage, int pageSize, int states) {
		StringBuffer where = new StringBuffer(" where isDelete ");
		switch (states) {
		case 3:
			where.append(" <> 3");break;
		default:
			where.append(" = " + states);;
		}
		
		String sql = "select top (" + pageSize + ")" +
					 "		bookTypeId, " +
					 "		parentId, " +
					 "	 	bookTypeName, " +
					 "	 	isDelete, " +
					 "	 	context " +
					 "from " +
					 "		bookType " + where +
					 "and " +
					 "		bookTypeId not in " +
					 "			(select top("+ (nowPage - 1) * pageSize +") bookTypeId from bookType " + where +
					 "			)";
		
					List<BookType> bookTypes = null;
					
					try {
						bookTypes = jdbcTemplate.query(sql.toString(), new BookTypeMapping());
					} catch (Exception e) {
						e.printStackTrace();
					}
					return bookTypes;
	}

	@Override
	public int getPageCount(int pageSize, int states) {
		int pageCount = 0;
		
		StringBuffer where = new StringBuffer(" where isDelete ");
		switch (states) {
		case 3:
			where.append(" <> 3");break;
		default:
			where.append(" = " + states);;
		}
		
		String sql = "select count(*) from bookType" + where;
		int rowCount = 0;
		try {
			rowCount = jdbcTemplate.query(sql.toString());
			pageCount = rowCount / pageSize;
			if(rowCount % pageSize != 0) {
				pageCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageCount;
	}

	@Override
	public int getRowCount(int states) {
		
		StringBuffer where = new StringBuffer(" where isDelete ");
		
		switch (states) {
		case 3:
			where.append(" <> 3");break;
		default:
			where.append(" = " + states);;
		}
		
		String sql = "select count(*) from bookType" + where;
		int rowCount = 0;
		
		try {
			rowCount = jdbcTemplate.query(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public List<BookType> findChildBookType() {
		String sql = "select bookTypeId, parentId, bookTypeName, isDelete, context from bookType where parentId <> 0";
		List<BookType> bookTypes = null;
		try {
			bookTypes = jdbcTemplate.query(sql, new BookTypeMapping());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookTypes;
	}
}

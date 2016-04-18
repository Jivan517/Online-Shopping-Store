package cs544.project.onlineshoppingstore.dao;

import java.util.List;

import cs544.project.onlineshoppingstore.model.Book;

public interface BookDaoCustom {

	List<Book> findByFullTextSearch(String searchText);
}

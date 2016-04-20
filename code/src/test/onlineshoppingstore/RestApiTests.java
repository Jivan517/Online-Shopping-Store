package onlineshoppingstore;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.View;

import java.util.*;

import cs544.project.onlineshoppingstore.controller.BookController;
import cs544.project.onlineshoppingstore.dao.BookDao;
import cs544.project.onlineshoppingstore.dao.BookDaoImpl;
import cs544.project.onlineshoppingstore.model.Book;
import cs544.project.onlineshoppingstore.service.BookService;
import cs544.project.onlineshoppingstore.service.BookServiceImpl;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RestApiTests {

	public static final String SERVER_URI = "http://localhost:8080/onlineshoppingstore";

	@InjectMocks
	private BookServiceImpl bookService;

	@Mock
	private BookDao bookDao;
	
	@Mock
	View mockView;
	

	MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
//		mockMvc = standaloneSetup(bookController)
//				.setSingleView(mockView)
//				.build();
	}

	@Test
	public void getAllBooksTest() {

		// Arrange
////		RestTemplate restTemplate = new RestTemplate();
//		List<Book> expectedBooks = restTemplate.getForObject(SERVER_URI + "/api/books", List.class);
//
//		// Act
//		//List<Book> actualBooks = bookService.getAll();
//
//		// Assert
//		//assertEquals(expectedBooks.size(),actualBooks.size() );
//		verify(bookDao).findAll();

	}
}

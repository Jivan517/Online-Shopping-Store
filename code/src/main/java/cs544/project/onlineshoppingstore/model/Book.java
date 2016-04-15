package cs544.project.onlineshoppingstore.model;

public class Book {
	
	public enum TYPE {EBOOK,HARD}
	private String isbn;
	private String title;
	private String edition;
	private float price;
	private Byte[] cover;
	private String description;
	private TYPE booktype;
	

}

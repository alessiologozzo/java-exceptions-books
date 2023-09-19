package org.lessons.java.books;

public class Book {
	private String title, author, publisher;
	private int pageNumber;

	Book() {
		title = author = publisher = "";
		pageNumber = 0;
	}

	Book(String title, String author, String publisher, int pageNumber) throws Exception {
		setTitle(title);
		setAuthor(author);
		setPublisher(publisher);
		setPageNumber(pageNumber);
	}

	public void setTitle(String title) throws Exception {
		if (title.isBlank())
			throw new Exception("publisher can't be blank.");
		else
			this.title = title;
	}

	public void setAuthor(String author) throws Exception {
		if (author.isBlank())
			throw new Exception("publisher can't be blank.");
		else
			this.author = author;
	}

	public void setPublisher(String publisher) throws Exception {
		if (publisher.isBlank())
			throw new Exception("publisher can't be blank.");
		else
			this.publisher = publisher;
	}

	public void setPageNumber(int pageNumber) throws Exception {
		if (pageNumber < 0)
			throw new Exception("pageNumber can't be lower than 0.");
		else
			this.pageNumber = pageNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public String toString() {
		return "Titolo: " + title + "\nAutore: " + author + "\nEditore: " + publisher + "\nNumero di pagine: "
				+ pageNumber;
	}
}


public class Book {
	
	private int id;
	private String title;
	private String subtitle;
	private String  authorName;
	private String publisherName;
	private double price;
	public  int noOfCopy;
	
	public Book() {
		super();
	}
	public Book(int id, String title, String subtitle, String authorName, String publisherName, double price,
			int noOfCopy) {
		super();
		this.id = id;
		this.title = title;
		this.subtitle = subtitle;
		this.authorName = authorName;
		this.publisherName = publisherName;
		this.price = price;
		this.noOfCopy = noOfCopy;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNoOfCopy() {
		return noOfCopy;
	}
	public void setNoOfCopy(int noOfCopy) {
		this.noOfCopy = noOfCopy;
	}
	@Override
	public String toString() {
		return "Book Information : \nBook [id = "+ id +", title = "+title+", subtitle = "+subtitle+", authorName = " +authorName
			+", publisherName = "+publisherName+", price = "+price+", noOfCopy = "+noOfCopy+"]\n";
	}
}

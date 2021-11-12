package test3;

public class SampleDTO {

	private String id;
	private String name;
	private int price;

//	파라미터가 있는 생성자
	public SampleDTO(String id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	
//	Getter & Setter method
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	
}

package callcenter;

/**
 * Person who is calling
 * @author wish
 */
public class Caller {
	private String name;
	private String id;
	
	public Caller(String name, String id) {
		this.name = name;
		this.id = id;	
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getId() {
		return this.id;
	}
}

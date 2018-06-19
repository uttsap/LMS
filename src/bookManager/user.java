package bookManager;

public class user {
	static int PresentIndex = 0;
	private String name;
	private String libno;
	private int index;
	

	public user(String name, String libno) {
		this.name = name;
		this.libno = libno;
		this.index = PresentIndex;
		PresentIndex += 1;

	}

	public int getIndex() {
		return index;
	}
	public String getName() {
		return name;
	}
	
	public String getLibno() {
		return libno;
	}
	
	void printInfo() {
		System.out.printf("%s  %s", this.name,
				this.libno);
	}
}

package TestStream;

public class Trader {

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	private final  String name;
	 private final String city;

	 public Trader(String n,String c){
	 	this.name=n;
	 	this.city=c;
	 }

}

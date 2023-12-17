import java.util.Scanner;

public class Adresse{
	private String Country;
	private String City;
	private String Street;
	private String houseNumber;
	public Adresse(String country, String city, String street, String houseNumber) {
		Country = country;
		City = city;
		Street = street;
		this.houseNumber = houseNumber;
	}
	public Adresse() {}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	 public void setAdresse() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter Country:");
	        setCountry(scanner.nextLine());

	        System.out.println("Enter City:");
	        setCity(scanner.nextLine());

	        System.out.println("Enter Street:");
	        setStreet(scanner.nextLine());

	        System.out.println("Enter House Number:");
	        setHouseNumber(scanner.nextLine());

	        scanner.close();
	    }
	 public void displayInfo() {
	        System.out.println("Address Informations:");
	        System.out.println("Country: " + Country);
	        System.out.println("City: " + City);
	        System.out.println("Street: " + Street);
	        System.out.println("House Number: " + houseNumber);
	    
	 }
}

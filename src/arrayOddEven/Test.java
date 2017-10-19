package arrayOddEven;

public class Test {

	public static void main(String[] args) {

		String softwareVersion = "saos-06-15-00-0000";

		int a = softwareVersion.toLowerCase().compareTo("saos-06-15-00-0000");
		// prints the return value of the comparison
		if (softwareVersion.toLowerCase().compareTo("saos-06-15-00-0000") < 0) {
			System.out.println("less than");
		} else if(softwareVersion.toLowerCase().compareTo("saos-06-15-00-0000")  >= 0){
			System.out.println("equal ");
		} 
	}
}

import java.util.ArrayList;


public class ArrayListCompare {

	public static void main(String args[]){
		
		ArrayList aList = new ArrayList<>();
		
		aList.add("First");
		aList.add("Second");
		aList.add("Third");
		aList.add("Fourth");
		aList.add("Fifth");
		
		if(aList.contains("Third")){
			System.out.println("Yes! I have");
		}else{
			System.out.println("No! I haven't");
		}
	}
}

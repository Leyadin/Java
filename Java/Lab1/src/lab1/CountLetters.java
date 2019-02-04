package lab1;

public class CountLetters {
	
	public static int countLetters(String s) {
		int numLetters = 0;
		
		//Increments numLetters 1 if the first character in a string is a letter
		//Removes the first character each loop
		while (s.length() > 0) {
			if (Character.isLetter(s.charAt(0)) == true )
				numLetters++;
			s = s.substring(1);
		}
		
		return numLetters;
	}

	//Test function
	public static void main(String[] args) {
		String test1 = "Simple"; //Should return 6
		String test2 = "This should have 21 letters"; //Should return 21
		String test3 = "23a.2bcDe324FG9h2ijKl Mn.1@#oPq_34RS tuV./wXYz!?@"; //Should return 26 
		
		System.out.println("test1 has " + countLetters(test1) + " letters.");
		System.out.println("test2 has " + countLetters(test2) + " letters.");
		System.out.println("test3 has " + countLetters(test3) + " letters.");
	}
		
}
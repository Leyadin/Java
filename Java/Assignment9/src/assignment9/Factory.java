package assignment9;

class Factory {
	Factory() {};
	
	static ShowMessage getMessage(String lang) {
		if (lang.equals("E")) {
			return new English();
		} else if (lang.equals("F")) {
			return new French();
		} else if (lang.equals("S")) {
			return new Spanish();
		} else {
			System.out.println("Error - unrecognized langauge type");
			return null;
		}
	}
}

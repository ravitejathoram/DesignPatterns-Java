package DesignPrinciples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
//Single Responsibility principle	
class Journal {
	private final List<String> entries = new ArrayList<>();
	private static int count = 0;
	
	public void addEntry(String text) {
		entries.add(""+(++count)+": "+ text);
	}
	
	public void removeEntry(int index) {
		entries.remove(index);
	}
	
	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}
	
	//adding another methods related to persistence can violate the SRP
	//So for persistence create another class
}

class Persistence{
	public void saveToFile(Journal j, Boolean overwrite, String fileName) throws FileNotFoundException{
		if (overwrite || new File(fileName).exists()) {
			try(PrintStream out = new PrintStream(fileName)){
				out.println(j.toString());
			}
		}
	}
	
//	public load()
	
	
}

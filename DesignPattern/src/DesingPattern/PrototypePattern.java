package DesingPattern;

import java.io.Serializable;

class NewPerson implements Serializable{
	public String name;
	public int id;
	public NewPerson(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Person name:  " + name +"\n"+ "Person id : "+ id;
	}
}
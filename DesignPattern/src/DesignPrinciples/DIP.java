package DesignPrinciples;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.javatuples.Triplet;


//dependency inversion can be stated as:
//A. High-level modules should not depend on low-level modules. 
//Both should depend on abstractions.

//B. Abstractions should not depend on details. 
//Details should depend on abstractions.

enum Relationship{
	Parent,
	Child,
	Sibling
}

class Person{
	String name;

	public Person(String name) {
		super();
		this.name = name;
	}
	
}
interface RelationshipBrowser{
	List<Person> findAllChildren(String name);
}

class Relationships implements RelationshipBrowser{ //low level module something that interacts with DB
	List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
	
	public List<Triplet<Person, Relationship, Person>> getRelations() {
	    return relations;
	  }
	
	public void addParentAndChild(Person parent, Person child)
	  {
	    relations.add(new Triplet<>(parent, Relationship.Parent, child));
	    relations.add(new Triplet<>(child, Relationship.Child, parent));
	  }

	@Override
	public List<Person> findAllChildren(String name) {
		return relations.stream()
			      .filter(x -> Objects.equals(x.getValue0().name, name)
			              && x.getValue1() == Relationship.Parent)
			      .map(Triplet::getValue2)
			      .collect(Collectors.toList());
	}
}





class Reasearch{ //high level module like some user analyzing low level data
	
	//new way with abstraction layer and correcting dependency inversion
	public Reasearch(RelationshipBrowser b) {
		List<Person> children=  b.findAllChildren("John");
		for(Person child: children) {
			System.out.println("John has child " + child.name);
		}
	}
	
	//old way violation dependency inversion
//	public Reasearch(Relationships relationships) {
//	
//		List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
//		relations.stream()
//	      .filter(x -> x.getValue0().name.equals("John")
//	              && x.getValue1() == Relationship.Parent)
//	      .forEach(ch -> System.out.println("John has a child called " + ch.getValue2().name));
//	}
}
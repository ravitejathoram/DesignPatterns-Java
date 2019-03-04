package DesignPrinciples;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
//		Journal j = new Journal();
//		j.addEntry("Hi this is SRP!!!");
//		j.addEntry("I am about to learn Design Pattern");
//		System.out.println(j);
//		j.removeEntry(1);
//		System.out.println("After removing last entry");
//		System.out.println(j);
//		
//		Persistence p = new Persistence();
//		p.saveToFile(j, true, "/Users/teju/Documents/DesignPatterns-JAVA/DesignPattern/src/DesignPrinciples/newJournal.txt");
		
//		Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
//	    Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
//	    Product house = new Product("House", Color.BLUE, Size.LARGE);
//	    
//	    List<Product> products = List.of(apple, tree, house);
//	    ProductFilter pf = new ProductFilter();
//	    System.out.println("Green products (old):");
//	    pf.filterByColor(products, Color.GREEN)
//	      .forEach(p -> System.out.println(" - " + p.name + " is green"));
//	    
//	    
//	    BetterFilter bf = new BetterFilter();
//	    System.out.println("Green products (new):");
//	    bf.filterByCond(products, new ColorSpecification(Color.GREEN))
//	      .forEach(p -> System.out.println(" - " + p.name + " is green"));
//
//	    System.out.println("Large products:");
//	    bf.filterByCond(products, new SizeSpecification(Size.LARGE))
//	      .forEach(p -> System.out.println(" - " + p.name + " is large"));
//
//	    System.out.println("Large blue items:");
//	    bf.filterByCond(products,
//	      new AndSpecification<>(
//	        new ColorSpecification(Color.BLUE),
//	        new SizeSpecification(Size.LARGE)
//	      ))
//	      .forEach(p -> System.out.println(" - " + p.name + " is large and blue"));
		
//		Rectangle rc = new Rectangle(2, 3);
//		LSPDemo lsp = new LSPDemo();
//	    lsp.useIt(rc);
//
//	    Rectangle sq = new Square();
//	    sq.setHeight(5);
//	    lsp.useIt(sq);
		
		Person parent = new Person("John");
		Person child1 = new Person("Chris");
		Person child2 = new Person("Matt");
//
//	    // low-level module
		Relationships relationships = new Relationships();
		relationships.addParentAndChild(parent, child1);
		relationships.addParentAndChild(parent, child2);
	
		new Reasearch(relationships);
		


	}

}

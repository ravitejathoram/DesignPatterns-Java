package DesignPrinciples;

import java.util.List;
import java.util.stream.Stream;

//Open Close Principle
enum Color{
	RED, BLUE, GREEN
}

enum Size{
	SMALL, MEDIUM, LARGE, HUGE
}

class Product{
	public String name;
	public Color color;
	public Size size;
	public Product(String name, Color color, Size size) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
	}
	
}
//naive way of filtering products based on specification
class ProductFilter{
	public Stream<Product> filterByColor(List<Product> products, Color color){
		return products.stream().filter(p->p.color == color);
	}
	public Stream<Product> filterBySize(List<Product> products, Size size){
		return products.stream().filter(p->p.size == size);
	}
	public Stream<Product> filterByColorAndSize(List<Product> products, Color color, Size size){
		return products.stream().filter(p->p.color == color && p.size==size);
	}
}

interface Specification<T>{
	public boolean isSatisfied(T item);
}

interface FilterBy<T>{
	Stream<T> filterByCond(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product>{
	private Color color;

	public ColorSpecification(Color color) {
		super();
		this.color = color;
	}

	@Override
	public boolean isSatisfied(Product item) {
		
		return item.color == color;
	}
	
}

class SizeSpecification implements Specification<Product>{
	private Size size;

	public SizeSpecification(Size size) {
		super();
		this.size = size;
	}

	@Override
	public boolean isSatisfied(Product item) {
		
		return item.size == size;
	}
	
}

class AndSpecification<T> implements Specification<T>
{
  private Specification<T> first, second;

  public AndSpecification(Specification<T> first, Specification<T> second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean isSatisfied(T item) {
    return first.isSatisfied(item) && second.isSatisfied(item);
  }

}

class BetterFilter implements FilterBy<Product>
{
  @Override
  public Stream<Product> filterByCond(List<Product> items, Specification<Product> spec) {
    return items.stream().filter(p -> spec.isSatisfied(p));
  }
}

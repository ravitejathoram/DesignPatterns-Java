package DesignPrinciples;

//every square is rectangle
//that implies square is sub class of rectangle
class Rectangle{
	protected int width, height;
	public Rectangle() {
	  }
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getArea() { return width*height; }

	  @Override
	  public String toString() {
	    return "Rectangle{" +
	      "width=" + width +
	      ", height=" + height +
	      '}';
	  }
}

class Square extends Rectangle{

	public Square() {
		
	}
	public Square(int size) {
		width = height = size;
	}
	
	//setting both width and height
	//there by violating Liskov Substitution principle
	@Override
	  public void setWidth(int width) {
	    super.setWidth(width);
	    super.setHeight(width);
	  }

	  @Override
	  public void setHeight(int height) {
	    super.setHeight(height);
	    super.setWidth(height);
	  }
}

class LSPDemo
{
  // maybe conform to ++
  static void useIt(Rectangle r)
  {
    int width = r.getWidth();
    r.setHeight(10);
    System.out.println("Expected area of " + (width*10) + ", got " + r.getArea());
  }
  //output generated
  //  Expected area of 20, got 20
  //  Expected area of 50, got 100
  //to avoid this we can use Factory Pattern
}
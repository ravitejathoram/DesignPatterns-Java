package DesingPattern;

public class MainPattern {

	public static void main(String[] args) {
		// we want to build a simple HTML paragraph
//	    System.out.println("Testing");
//	    String hello = "hello";
//	    StringBuilder sb = new StringBuilder();
//	    sb.append("<p>")
//	      .append(hello)
//	      .append("</p>"); // a builder!
//	    System.out.println(sb);
//
//	    // now we want to build a list with 2 words
//	    String [] words = {"hello", "world"};
//	    sb.setLength(0); // clear it
//	    sb.append("<ul>\n");
//	    for (String word: words)
//	    {
//	      // indentation management, line breaks and other evils
//	      sb.append(String.format("  <li>%s</li>\n", word));
//	    }
//	    sb.append("</ul>");
//	    System.out.println(sb);
//	    
//	    HtmlBuilder builder = new HtmlBuilder("ul");
//	    builder.addChild("li", "hello").addChild("li", "world");
//	    System.out.println(builder);

		PersonBuilder pd = new PersonBuilder();
		Person p = pd.lives()
						.at("1130 E Orange Street")
						.in("Tempe")
						.withPostcode("85281")
					.works()
						.asA("Software Dev")
						.at("XYZ")
						.earning(70000)
					.build();
		System.out.println(p);
	}

}
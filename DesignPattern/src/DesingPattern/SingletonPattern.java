package DesingPattern;

import java.io.*;

//Serialization problem prevails with this way of implementing Singleton
//Enum way of Singleton implementation can be done instead


class BasicSingleton implements Serializable
{
  // cannot new this class, however
  // * instance can be created deliberately (reflection)
  // * instance can be created accidentally (serialization)
  private BasicSingleton() {
    System.out.println("Singleton is initializing");
  }

  private static final BasicSingleton INSTANCE = new BasicSingleton();

  private int value = 0;

  public int getValue()
  {
    return value;
  }
  public void setValue(int value)
  {
    this.value = value;
  }

  // required for correct serialization
  // readResolve is used for _replacing_ the object read from the stream

//  protected Object readResolve()
//  {
//    return INSTANCE;
//  }

  // generated getter
  public static BasicSingleton getInstance()
  {
    return INSTANCE;
  }
}

class Sample{
	static void saveToFile(BasicSingleton singleton, String filename)
		    throws Exception
		  {
		    try (FileOutputStream fileOut = new FileOutputStream(filename);
		         ObjectOutputStream out = new ObjectOutputStream(fileOut))
		    {
		      out.writeObject(singleton);
		    }
		  }

		  static BasicSingleton readFromFile(String filename)
		    throws Exception
		  {
		    try (FileInputStream fileIn = new FileInputStream(filename);
		         ObjectInputStream in = new ObjectInputStream(fileIn) )
		    {
		      return (BasicSingleton)in.readObject();
		    }
		  }
}


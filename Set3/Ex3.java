import java.util.*;
import java.lang.*;
import java.io.*;
public class Ex3
{
    public static void main (String[] args) throws java.lang.Exception
  {
    QueryStream qstream = new QueryStream(new Query[]{
      new Query("1", "why is the sky blue"),
      new Query("2", "what does ratchet mean"),
      new Query("3", "sometimes i like to lay on the floor and pretend im a carrot")
    });
 
    /*System.out.println("Old-style iteration");
    System.out.println("========================================");
    QueryStreamIterator iter = qstream.iterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }*/
 
    System.out.println("New-fangled iteration");
    System.out.println("========================================");
    // This secretly creates an iterator ans uses next()/hasNext()
    for (String word : qstream) {
      System.out.println(word);
    }
 
  //   System.out.println("Newer-fangled iteration");
  //   System.out.println("========================================");
  //   // This secretly creates an iterator ans uses next()/hasNext()
  //   qstream.forEach((word) -> System.out.println(word));
   }
}
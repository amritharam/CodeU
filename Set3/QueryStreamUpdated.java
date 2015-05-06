import java.util.*;
import java.lang.*;
import java.io.*;
 
class Query {
    private String timestamp;
    private String words;
    public Query(String timestamp, String words) {
        this.timestamp = timestamp;
        this.words = words;
    }
 
    public String getTimestamp() {
        return timestamp;
    }
 
    public String getWords() {
        return words;
    }
}
 
class QueryStream implements Iterable<String> {
    private Query[] stream;
    public QueryStream(Query[] querylist) {
        stream = querylist;
    }
 
 
    @Override
    public QueryStreamIterator iterator() {
        return new QueryStreamIterator(stream);
    }
 
}
 
class QueryStreamIterator implements Iterator<String> {
    private Query[] stream;
    private int index;
    private String[] currentStream;
    private int indexOfWords;
 
    public QueryStreamIterator(Query[] stream) {
        this.stream = stream;
        index = 0;
        currentStream = stream[0].getWords().split(" "); //the current string we are on
        indexOfWords = 0;
    }
 
    @Override
    public String next() {
      if (!hasNext()) {
        throw new NoSuchElementException("No more queries");
      } else {
        if (indexOfWords < currentStream.length) {
          return currentStream[indexOfWords++];
        } else if (indexOfWords == currentStream.length && index < stream.length) {
          currentStream = stream[index++].getWords().split(" "); //set the current string to that of the new query
          indexOfWords = 0;
          return "<NEWQUERY>";
        }
      }
      return "";
    }
 
    @Override
    public boolean hasNext() {
      if (indexOfWords < currentStream.length) { //if the current string has more words
        return true;
      } else if (indexOfWords == currentStream.length && index < stream.length) { //if we're done with the current query's words
        //if we have another query
        return true;
      }
      return false;
    }
}
 
/* Name of the class has to be "Main" only if the class is public. */
class Ex3
{
    public static void main (String[] args) throws java.lang.Exception
  {
    QueryStream qstream = new QueryStream(new Query[]{
      new Query("1", "why is the sky blue"),
      new Query("2", "what does ratchet mean"),
      new Query("3", "sometimes i like to lay on the floor and pretend im a carrot")
    });
 
    System.out.println("Old-style iteration");
    System.out.println("========================================");
    QueryStreamIterator iter = qstream.iterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
 
    System.out.println("New-fangled iteration");
    System.out.println("========================================");
    // This secretly creates an iterator ans uses next()/hasNext()
    for (String word : qstream) {
      System.out.println(word);
    }
 
    System.out.println("Newer-fangled iteration");
    System.out.println("========================================");
    // This secretly creates an iterator ans uses next()/hasNext()
    qstream.forEach((word) -> System.out.println(word));
  }
}
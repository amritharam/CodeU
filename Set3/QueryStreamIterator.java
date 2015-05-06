//import java.lang.NoSuchElementException;
import java.util.Iterator;
import java.util.*;

public class QueryStreamIterator implements Iterator<String> {
	private Query[] stream;
	private int index;
	private String[] currentStream;
	private int indexOfWords;

	public QueryStreamIterator(Query[] stream) {
		this.stream = stream;
		index = 0;
		currentStream = stream[index++].getWords().split(" "); //the current string we are on
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
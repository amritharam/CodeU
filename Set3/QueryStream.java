/*You are working on a system that uses a QueryStream class.  A QueryStream is basically a list of Query objects.  Each
Query contains a timestamp, some additional fields we don’t care about right now, and a single string that contains a
list of words separated by white space.  Write the definitions for QueryStream and Query.  Then, create an iterator for
the QueryStream class.  The iterator should implement hasNext() and next().  Each call to next() should return the next
word from the string of words in the current Query in the QueryStream (starting with the first) and advance to the next
Query when the current Query’s string is exhausted. Also, between the strings of two consecutive Queries, the iterator
should return the string “<NEWQUERY>”.  hasNext() should return true as long as there are words for next() to return.

*/

public class QueryStream implements Iterable<String> {
	private Query[] stream;
	public QueryStream(Query[] querylist) {
		stream = querylist;
	}


	@Override
	public QueryStreamIterator iterator() {
		return new QueryStreamIterator(stream);
	}

}
//Write a boolean function isInDictionary() that accepts a string parameter containing a word and returns true if the word is in the 
//dictionary.  The dictionary you are to use is packaged as a class named TrivialDictionary.  It has a single static function named 
//TrivialDictionary.wordAt(). This function has a single input, an integer index, and it returns the word at that index as a string, or 
//null if the index is out of range.
//For extra points:  Modify isInDictionary() to keep information from prior calls and use it to speed up the function (i.e., reduce the 
//number of calls you have to make to TrivialDictionary.wordAt()).

//Least efficient way
	public boolean isInDictionary(String s) {
		TrivialDictionary dictionary = new TrivialDictionary();
		int i = 0;
		while(dictionary.wordAt(i) != null) {
			if (s.equals(dictionary.wordAt(i))) {
				return true;
			}
			i++;
		} 
		return false;
	}

//Question: How do I refer to the dictionary object? Is it already created for me?
//Hopefully more efficient
TrivialDictionary dictionary = new TrivialDictionary();
Set<String> priorCalls= new HashSet<String>();
public boolean isInDictionary(String s) {
	if (priorCalls.contains(s)) {
		return true;
	}
		int i = 0;
		while(dictionary.wordAt(i) != null) {
			if (s.equals(dictionary.wordAt(i))) {
				priorCalls.add(s);
				return true;
			}
			i++;
		} 
		return false;
}
//Or perform binary search ; find the length of the dictionary (or approx length by powers of 2)
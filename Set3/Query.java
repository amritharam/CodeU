public class Query {
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
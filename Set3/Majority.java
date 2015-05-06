//Majority

private boolean hasMajority(ArrayList<Integer> numbers) {
	Collections.sort(numbers);
	int majority = 1;
	int len = numbers.size();

	for(int i = 1; i < len; i++) {
		if ((float)majority/len > 0.5) {
			return true;
		}
		if (numbers.get(i) == numbers.get(i-1)) {
			majority++;
		} else {
			majority = 1;
		}
	}
	return false;
}
public class HashTable { 
	
	private static final double LOAD_FACTOR = 0.75;
	private int maxSize = 10;
	private int currentSize;
	private Entry[] entries;
	
	public HashTable() {
		entries = new Entry[maxSize];
		this.currentSize = 0;
	}
	
	public void add(Entry e) {
		if ((currentSize / (double)maxSize) > LOAD_FACTOR) {
			this.resize();
		}
		int index = e.hashCode() % maxSize;
		int jumpDistance = 1;
		boolean repeated = false;
		int newIndex = index;
		while (entries[newIndex] != null) {
			if (entries[newIndex].getWord().equals(e.getWord())) {
				entries[newIndex].incrementCount();
				repeated = true;
				break;
			}
			
			newIndex = (index + jumpDistance) % maxSize;	
			jumpDistance++;
		}
		if (repeated == false) {
			entries[newIndex] = e;
			this.currentSize++;
		}
		
		
	}

	private void resize() {
		this.maxSize = this.maxSize * 2;
		this.currentSize = 0;
		Entry[] oldTable = this.entries;
		this.entries = new Entry[maxSize];
		for (int i = 0; i < oldTable.length; i++) {
			if (oldTable[i] != null) {
				this.add(oldTable[i]);
			}
		}
	}

	

	public String toString() {
        String formatter = "%-20s%-1d";
		String output = "";
		for (int i = 0; i < entries.length; i++) {
			if (entries[i] != null) {
				output += String.format(formatter, entries[i].getWord(), entries[i].getCount()) + "\n";
			}
		}
		return output;
	}
}

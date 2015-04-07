public class Hash_table {

	int HashSize = 100;
	Hash[] h;

	public int hashFunction(int element) {
		int key;
		key = element;

		key += ~(key << 16);
		key ^= (key >> 5);
		key += (key << 3);
		key ^= (key >> 13);
		key += ~(key << 9);
		key ^= (key >> 17);

		return key % HashSize;
	}

	Hash_table() {
		h = new Hash[HashSize];
		for (int i = 0; i < HashSize; i++) {
			h[i] = new Hash();
			h[i].key = i;
		}
	}

	public void hashSearch(int element) {
		int value = hashFunction(element);
		List l = new List();
		int i = 0;
		while (value != h[i].key) {
			i++;
		}

		if (h[i].head == null) {
			System.out.println("No such element!");
			return;
		}

		l = h[i].head;

		while (l.val != element) {
			if (l.next == null) {
				System.out.println("No such element!");
				return;
			}
			l = l.next;
		}

		System.out.println("Element was found!");
	}

	public void hashAdd(int element) {
		int value = hashFunction(element);
		List l = new List();
		int i = 0;
		while (value != h[i].key) {
			i++;
		}

		l = h[i].head;

		if (l == null) {
			List new_list = new List();
			h[i].head = new_list;
			h[i].head.val = element;
			h[i].head.next = null;
		} else {

			while (l.next != null) {
				l = l.next;
			}
			List new_data = new List();
			new_data.val = element;
			l.next = new_data;
		}
	}

	public void hashDelete(int element) {
		int value = hashFunction(element);
		List l = new List();
		int i = 0;
		while (value != h[i].key) {
			i++;
		}

		if (h[i].head == null) {
			System.out.println("No such element!");
			return;
		}

		l = h[i].head;

		while (l.next != null) {
			if (l.next.val == element) {
				l.next = l.next.next;
				System.out.println("Element was successfully deleted!");
				return;
			} else {
				l = l.next;
			}
		}
		System.out.println("No such element!");
		return;
	}
}
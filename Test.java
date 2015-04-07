
public class Test {
	public static void main(String[] args){
		Hash_table MyHashTable = new Hash_table();
		for (int i = 0; i < 100; i++){
			MyHashTable.hashAdd((int)(Math.random() * 100));
		}
		MyHashTable.hashAdd(1);
		
		MyHashTable.hashSearch((int)(Math.random() * 100));
		MyHashTable.hashSearch((int)(Math.random() * 100));
		MyHashTable.hashSearch((int)(Math.random() * 100));
		
		MyHashTable.hashDelete((int)(Math.random()*100));
		MyHashTable.hashDelete(1);
		MyHashTable.hashDelete(101);
		
	}
}

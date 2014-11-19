package practice_problems;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
	public List<String> keys;
	public HashNode[] myHashTable;
	
	public HashTable(){
		keys = new ArrayList<String>();
		myHashTable = new HashNode[128];
	}
	public void addEntry(HashNode newNode){
		keys.add(newNode.getKey());
		myHashTable[this.hash(newNode.getKey())] = newNode;
	}
	private Integer hash(String key){
		return key.hashCode()%128;
	}
	public void printTable(){
		for(String key : keys){
			System.out.println(key + " : " + myHashTable[hash(key)].getValue());
		}
	}
	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.addEntry(new HashNode("Nick", "Male"));
		ht.addEntry(new HashNode("John", "Male"));
		ht.addEntry(new HashNode("Sally", "Female"));
		ht.printTable();

	}

}



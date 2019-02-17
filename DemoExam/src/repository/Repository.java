package repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {
	int index = 0;
	Map<Integer, Person> data;
	
	public Repository() {
		this.data = new HashMap<>();
	}
	
	public void add(Person person) {
		this.data.put(index++, person);
	}
	
	public Person get(int id) {
		return data.get(id);
	}
	
	public boolean update(int id, Person newPerson) {
		if (!this.data.containsKey(id)) {
			return false;
		}
		
		this.data.put(id, newPerson);
		return true;
	}
	
	public boolean delete(int id) {
		if (!this.data.containsKey(id)) {
			return false;
		}
		
		this.data.remove(id);
		return true;
	}
	
	public int getCount() {
		return this.data.size();
	}
}

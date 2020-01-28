package DataStructuresAndAlgorithms.src.com.sandeep.custom.customhash;

public class LinkedHashSetCustom<E> {

	private LinkedHashMapCustom<E, Object> linkedHashMapCustom;
	
	public LinkedHashSetCustom() {
		linkedHashMapCustom = new LinkedHashMapCustom<>();
	}
	
	public void add(E value) {
		linkedHashMapCustom.put(value, null);
	}
	
	public boolean remove(E object) {
//		linkedHashMapCustom.remove(object);
		return false;
	}
	
	public boolean contains(E object) {
//		return linkedHashMapCustom.contains(object);
		return false;
	}
	
	public void display() {
//		linkedHashMapCustom.displaySet();
	}
	
}

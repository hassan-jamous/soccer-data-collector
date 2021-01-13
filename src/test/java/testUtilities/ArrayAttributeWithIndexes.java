package testUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAttributeWithIndexes {
	public String attributeName;
	public List <Integer> indexes;
	public ArrayAttributeWithIndexes() {
		indexes = new ArrayList<>(Arrays.asList());	
	}
	public ArrayAttributeWithIndexes(String attributeName) {
		indexes = new ArrayList<>(Arrays.asList());
		this.attributeName = attributeName;
	}
	public ArrayAttributeWithIndexes(String attributeNameString , List<Integer> indexes) {
		this();
		this.attributeName = attributeNameString;
		this.indexes = indexes;
	}

}

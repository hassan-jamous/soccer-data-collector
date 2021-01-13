package testUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAttributeWithIndexesFor_TEST {
	public String attributeName;
	public List <Integer> indexes;
	public ArrayAttributeWithIndexesFor_TEST() {
		indexes = new ArrayList<>(Arrays.asList());	
	}
	public ArrayAttributeWithIndexesFor_TEST(String attributeName) {
		indexes = new ArrayList<>(Arrays.asList());
		this.attributeName = attributeName;
	}
	public ArrayAttributeWithIndexesFor_TEST(String attributeNameString , List<Integer> indexes) {
		this();
		this.attributeName = attributeNameString;
		this.indexes = indexes;
	}

}

package collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldFootBallAttributeFor_TEST {
	String attributeName;
	public List <Integer> indexes;
	public WorldFootBallAttributeFor_TEST() {
		indexes = new ArrayList<>(Arrays.asList());	
	}
	public WorldFootBallAttributeFor_TEST(String attributeName) {
		indexes = new ArrayList<>(Arrays.asList());
		this.attributeName = attributeName;
	}
	public WorldFootBallAttributeFor_TEST(String attributeNameString , List<Integer> indexes) {
		this();
		this.attributeName = attributeNameString;
		this.indexes = indexes;
	}

}

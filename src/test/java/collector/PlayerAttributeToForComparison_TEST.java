package collector;

import java.util.ArrayList;

public class PlayerAttributeToForComparison_TEST {
	String attributeName;
	ArrayList <Integer> indexes;
	public PlayerAttributeToForComparison_TEST() {
		indexes = new ArrayList<>();	
	}
	public PlayerAttributeToForComparison_TEST(String attributeNameString , ArrayList<Integer> indexes) {
		this();
		this.attributeName = attributeNameString;
		this.indexes = indexes;
	}

}

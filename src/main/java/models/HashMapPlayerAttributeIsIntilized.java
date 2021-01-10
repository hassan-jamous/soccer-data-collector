package models;

import java.util.HashMap;



public class HashMapPlayerAttributeIsIntilized {

	public HashMap<PlayerPersonalInformationKindOf_TD , Boolean> attributesFlag ;
	
	public HashMapPlayerAttributeIsIntilized() {
		this.attributesFlag = new HashMap<>();
		attributesFlag.put(PlayerPersonalInformationKindOf_TD.fullName, false);
		attributesFlag.put(PlayerPersonalInformationKindOf_TD.Born, false);
		attributesFlag.put(PlayerPersonalInformationKindOf_TD.PlaceOfBirth, false);
		attributesFlag.put(PlayerPersonalInformationKindOf_TD.Nationality, false);
		attributesFlag.put(PlayerPersonalInformationKindOf_TD.Weight, false);
		attributesFlag.put(PlayerPersonalInformationKindOf_TD.Height, false);
		attributesFlag.put(PlayerPersonalInformationKindOf_TD.Position, false);
		attributesFlag.put(PlayerPersonalInformationKindOf_TD.Foot, false);

	}
	public void changeToTrue(PlayerPersonalInformationKindOf_TD key) {
		this.attributesFlag.replace(key, true);
	}
	public boolean isIntilized(PlayerPersonalInformationKindOf_TD key) {
		return this.attributesFlag.get(key);
	}

	
	
}

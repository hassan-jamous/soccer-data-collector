package worldfootball.models;

public class Referee {

	public String name;
	public String nation;
	public KindOfReferee kind;
	
	public Referee() {}
	public Referee(String name , String nation , KindOfReferee kind) {
		this.name = name;
		this.nation = nation;
		this.kind = kind;
	}
	
	public String toString() {
		String result = "";
		
		result = (this.kind == KindOfReferee.Referee ? "Referee  " :"Assiatant Referee  ") + name + "  {" + nation + "} " ; 
		return result;
	}
}

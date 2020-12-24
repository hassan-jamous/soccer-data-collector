package models;

import java.util.ArrayList;

public class ClubTransferTable {

	public Club clubBasicInfo;
	public String season;
	public ArrayList <TransferPlayerInformation> intable;
	public ArrayList <TransferPlayerInformation> outtable;
	
	
	public ClubTransferTable() {
		clubBasicInfo = new Club();
		intable = new ArrayList<>();
		outtable = new ArrayList<>();
		
	}
	public ClubTransferTable(String clubName , String season,  ArrayList <TransferPlayerInformation> in , ArrayList <TransferPlayerInformation> out) {
		this.clubBasicInfo = new Club();
		this.clubBasicInfo.name = clubName;
		this.season = season;
		this.intable  = new ArrayList <>();
		this.intable= in;
		this.outtable  = new ArrayList <>();
		this.outtable = out;
		
	}
	public String toString() {
		String result="";
		result = clubBasicInfo.name + "  "+ season+ "\n";
		
		if((intable != null)&&(intable.size()>0)) {
			result = result + "IN" + "\n";
			for(int i =0 ; i<intable.size(); i++) {
				result = result + intable.get(i).toString()+"\n";
			}
		}
		if((outtable != null)&&(outtable.size()>0)) {
			result = result + "OUT" + "\n";
			for(int i =0 ; i<outtable.size(); i++) {
				result = result + outtable.get(i).toString()+"\n";
			}
		}
		return result;
	}
}

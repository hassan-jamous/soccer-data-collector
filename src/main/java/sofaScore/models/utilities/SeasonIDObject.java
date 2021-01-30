package sofaScore.models.utilities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SeasonIDObject implements Comparable <SeasonIDObject>  {
	
	public String competitionName;
	public String years;
	
	@Override
	public int compareTo(SeasonIDObject objecttoCompare) {
	
		int thisYear = Integer.valueOf(years.substring(0, years.indexOf('/')));
		int otherYear = Integer.valueOf(objecttoCompare.years.substring(0, objecttoCompare.years.indexOf('/')));
		return thisYear-otherYear;
	}
	@Override
	public boolean equals(Object obj) {
        if (obj != null && obj instanceof SeasonIDObject)
            return (competitionName.equals(((SeasonIDObject)obj).competitionName)) &&
            		(years.equals(((SeasonIDObject)obj).years));
        else
            return false;
    }
	
	 public int hashCode() {
	        return competitionName.hashCode()+years.hashCode();
	    }
}

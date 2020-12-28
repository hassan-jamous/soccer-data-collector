package models;

import java.util.ArrayList;

public class Goals {

	public ArrayList <Goal> goals ;
	public Goals () {
		goals = new ArrayList<>();
	}
	public Goals (ArrayList<Goal> goals) {
		this.goals = new ArrayList<>();
		this.goals = goals;
	}
	public void addGoal(Goal goal) {
		goals.add(goal);
	}
	public ArrayList<Goal> getGoals() {
		return goals;
	}
	public String toString() {
		String result ="";
		for(int i = 0 ; i < goals.size() ; i++) {
			result = goals.get(i).toString() + "\n";
		}
		return result;
	}
}

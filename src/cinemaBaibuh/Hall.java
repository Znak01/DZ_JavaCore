package cinemaBaibuh;

import java.io.Serializable;

public class Hall implements Serializable{

	private int countOfSit;
	private int numberOfHall;
	public Hall(int countOfSit, int numberOfHall) {
		super();
		this.countOfSit = countOfSit;
		this.numberOfHall = numberOfHall;
	}
	
	public int getCountOfSit() {
		return countOfSit;
	}

	public void setCountOfSit(int countOfSit) {
		this.countOfSit = countOfSit;
	}

	public int getNumberOfHall() {
		return numberOfHall;
	}

	public void setNumberOfHall(int numberOfHall) {
		this.numberOfHall = numberOfHall;
	}

	@Override
	public String toString() {
		return "Hall [countOfSit=" + countOfSit + ", numberOfHall=" + numberOfHall + "]";
	}
	
	
	
	
}

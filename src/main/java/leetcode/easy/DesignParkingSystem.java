package leetcode.easy;

public class DesignParkingSystem {
}

class ParkingSystem {

	private int[] places = new int[3];

	public ParkingSystem(int big, int medium, int small) {
		this.places[0] = big;
		this.places[1] = medium;
		this.places[2] = small;
	}

	public boolean addCar(int carType) {
		if (this.places[carType-1] > 0){
			this.places[carType-1]-=1;
			return true;
		}
		return false;
	}
}

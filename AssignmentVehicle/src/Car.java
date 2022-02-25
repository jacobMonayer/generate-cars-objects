import java.util.Random;

public class Car extends MotorCycle {
	
	protected int numberOfDoors ;
	public Car() {
		super();
		Random rand = new Random();
		this.numberOfWheels = 4;
		this.numberOfDoors = rand.nextInt(4) + 2 ;
	}
	
	public String toString() {
		return "Car [numberOfDoors=" + numberOfDoors + ", numberOfWheels=" + numberOfWheels + ", color=" + color
				+ ", remainPower=" + remainPower + "]";
	}
	
}

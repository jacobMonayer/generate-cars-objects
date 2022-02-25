import java.util.Random;

public class Truck extends MotorCycle {
	protected boolean cargoAttached ;
	
	
	public Truck() {
		super();
		Random rand = new Random();
		this.numberOfWheels = 18;
		this.cargoAttached = rand.nextBoolean(); 
	}


	@Override
	public String toString() {
		return "Truck [cargoAttached=" + cargoAttached + ", numberOfWheels=" + numberOfWheels + ", color=" + color
				+ ", remainPower=" + remainPower + "]";
	}

}


public class MotorCycle extends Vehicle{
	protected int numberOfWheels ;

	public MotorCycle() {
		super();
		this.numberOfWheels = 2;
		
	}

	
	public String toString() {
		return "MotorCycle [numberOfWheels=" + numberOfWheels + ", color=" + color + ", remainPower=" + remainPower
				+ "]";
	}

	
	

}

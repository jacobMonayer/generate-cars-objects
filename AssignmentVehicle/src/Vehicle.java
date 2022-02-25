import java.awt.Color;
import java.util.Random;

public class Vehicle {
	
	protected Color color ;
	protected int remainPower;

	
	public Vehicle() {
		Random rand = new Random();
		this.color = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
		this.remainPower = rand.nextInt(101);
	}

	@Override
	public String toString() {
		return "vehicle [color=" + color + ", remainPower percent=" + remainPower   +"]";
	}
	
	
	
}

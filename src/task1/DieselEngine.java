package task1;

public class DieselEngine extends CombustionEngine
{
	private final double torque;
	public DieselEngine(double power, double volume, double torque)
	{
		super(power, volume);
		this.torque = torque;
	}

	public double getTorque()
	{
		return torque;
	}

	@Override
	public String show()
	{
		return String.format("Diesel Engine\n- Engine Power: %.2f h.p.\n- Volume: %.2f liters\n- Torque: %.2f\n\n",
				getPower(), getVolume(), getTorque());
	}
}

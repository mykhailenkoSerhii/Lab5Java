package task1;

public class CombustionEngine extends Engine
{
	private final double volume;
	public CombustionEngine(double power, double volume)
	{
		super(power);
		this.volume = volume;
	}

	public double getVolume()
	{
		return volume;
	}

	@Override
	public String show()
	{
		return String.format("Combustion Engine\n- Engine Power: %.2f h.p.\n- Volume: %.2f liters\n\n",
				getPower(), getVolume());
	}
}

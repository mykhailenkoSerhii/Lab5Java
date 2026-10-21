package task1;

public class JetEngine extends Engine
{
	private final double thrust;
	public JetEngine(double power, double thrust)
	{
		super(power);
		this.thrust = thrust;
	}

	public double getThrust()
	{
		return thrust;
	}

	@Override
	public String show()
	{
		return String.format("Jet Engine\n- Engine Power: %.2f h.p.\n- Thrust: %.2f kN\n\n", getPower(), getThrust());
	}

	@Override
	public int compareTo(Engine o)
	{
		if(o instanceof JetEngine jetEngine)
			return Double.compare(jetEngine.thrust, this.thrust);
		return super.compareTo(o);
	}
}

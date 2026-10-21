package task1;

public class Engine implements Comparable<Engine>
{
	private final double power;
	public Engine(double power)
	{
		this.power = power;
	}

	public double getPower()
	{
		return power;
	}

	public String show()
	{
		return String.format("Engine \n- Engine Power: %.2f h.p \n\n", getPower());
	}

	@Override
	public int compareTo(Engine o)
	{
		return Double.compare(o.power, this.power);
	}
}

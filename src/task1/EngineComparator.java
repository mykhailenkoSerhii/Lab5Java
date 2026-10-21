package task1;

import java.util.Comparator;

public class EngineComparator implements Comparator<Engine>
{
	@Override
	public int compare(Engine o1, Engine o2)
	{
		String name1 = o1.getClass().getSimpleName();
		String name2 = o2.getClass().getSimpleName();

		int mainCompare = o1.compareTo(o2);
		if(mainCompare == 0)
			return name1.compareTo(name2);
		else return mainCompare;
	}
}

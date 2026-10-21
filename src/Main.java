import task1.*;

import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose desired task: ");
		int task = scanner.nextInt();
		if(task == 1)
			task1(scanner);
		else if(task == 2)
			task2(scanner);
	}

	public static BufferedReader getReader(File file)
	{
		try
		{
			return new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Failed to find file!");
			return null;
		}
	}

	public static BufferedWriter getWriter(File file, boolean append)
	{
		try
		{
			return new BufferedWriter(new FileWriter(file, append));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
			return null;
		}
		catch(IOException e)
		{
			System.out.println("Couldn't write to the file.");
			return null;
		}
	}

	private static void task1(Scanner scanner)
	{
		BufferedReader combustionReader = null;
		BufferedReader dieselReader = null;
		BufferedReader jetReader = null;

		System.out.println("Input file for inputting Combustion Engine entries");
		while(combustionReader == null)
		{
			String file = scanner.next();
			combustionReader = getReader(new File(file));
		}

		System.out.println("Input file for inputting Diesel Engine entries");
		while(dieselReader == null)
		{
			String file = scanner.next();
			dieselReader = getReader(new File(file));
		}

		System.out.println("Input file for inputting Jet Engine entries");
		while(jetReader == null)
		{
			String file = scanner.next();
			jetReader = getReader(new File(file));
		}

		List<CombustionEngine> combustionEngines = new ArrayList<>();
		combustionReader.lines().forEach(str ->
			{
				String[] vals = str.split("[ ,.:;-?!]+");
				if(vals.length != 2)
				{
					String er = String.format("Must have 2, has %d", vals.length);
					throw new RuntimeException(
							"Combustion engine entry does not have the correct amount of parameters! \n" + er);
				} else combustionEngines.add(
						new CombustionEngine(Double.parseDouble(vals[0]), Double.parseDouble(vals[1])));
			});

		List<DieselEngine> dieselEngines = new ArrayList<>();
		dieselReader.lines().forEach(str ->
			{
				String[] vals = str.split("[ ,.:;-?!]+");
				if(vals.length != 3)
				{
					String er = String.format("Must have 3, has %d", vals.length);
					throw new RuntimeException(
							"Diesel engine entry does not have the correct amount of parameters! \n" + er);
				} else dieselEngines.add(new DieselEngine(Double.parseDouble(vals[0]), Double.parseDouble(vals[1]),
						Double.parseDouble(vals[2])));
			});

		List<JetEngine> jetEngines = new ArrayList<>();
		jetReader.lines().forEach(str ->
			{
				String[] vals = str.split("[ ,.:;-?!]+");
				if(vals.length != 2)
				{
					String er = String.format("Must have 2, has %d", vals.length);
					throw new RuntimeException(
							"Jet engine entry does not have the correct amount of parameters! \n" + er);
				} else jetEngines.add(new JetEngine(Double.parseDouble(vals[0]), Double.parseDouble(vals[1])));
			});

		List<Engine> engines = new ArrayList<>();
		engines.addAll(combustionEngines);
		engines.addAll(dieselEngines);
		engines.addAll(jetEngines);

		Collections.sort(engines, new EngineComparator());

		BufferedWriter writer = getWriter(new File("output.txt"), true);
		if(writer != null)
		{
			try
			{
				for(Engine engine : engines)
					writer.write(engine.show());
				writer.close();
				System.out.println("Finished Writing to output.txt!");
			}
			catch(IOException e)
			{
				System.out.println("An error occured while writing to output.txt!");
			}
		}
	}


	private static void task2(Scanner scanner)
	{
		System.out.println("Input line containig only brackets: (){}[]");
		String line = scanner.next();
		Stack<Character> stack = new Stack<>();

		for(int i = 0; i < line.length(); i++)
		{
			char chr = line.charAt(i);
			if(chr == '(' || chr == '[' || chr == '{')
				stack.push(chr);
			else if(chr == ')' || chr == ']' || chr == '}')
			{
				if(stack.isEmpty())
				{
					System.out.printf("Invalid bracket placement at chr. %d!", i);
					return;
				}

				char popped = stack.pop();
				if(chr == ')' && popped != '(')
				{
					System.out.printf("Invalid bracket placement at chr. %d!", i);
					return;
				}
				else if(chr == '}' && popped != '{')
				{
					System.out.printf("Invalid bracket placement at chr. %d!", i);
					return;
				}
				else if(chr == ']' && popped != '[')
				{
					System.out.printf("Invalid bracket placement at chr. %d!", i);
					return;
				}
			}
		}

		System.out.println("Correct bracket placement!");
	}
}

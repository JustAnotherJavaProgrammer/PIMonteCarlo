package pi;

import java.io.IOException;

public class Plotting {
	public static void plot(double[] estimates) throws IOException, InterruptedException {
		// StringBuilder command = new StringBuilder("gnuplot -p -e \"plot '-' using 1:2
		// with line title 'estimate';");
		StringBuilder command = new StringBuilder();
		for (long i = 0; i < estimates.length; i++) {
//				command.append((i + 1) + "\t" + estimates[(int) i] + "\n");
			command.append(estimates[(int) i] + "\n");
		}
		System.out.println(command.toString());
		// command.append("\"");
		// System.out.println("Plotting...");
		// int exitCode = Runtime.getRuntime().exec(command.toString()).waitFor();
		// if(exitCode != 0)
		// System.err.println("Gnuplot dinished with exit code " + exitCode + ".");
		// System.out.println("Finished plotting.");
		// return exitCode;
	}
	
	private int cumAvg(double[] estimates, int i, int vals) {
		int numOfValBef = Math.min(vals/2, i);
		int numOfValAfter = Math.min(vals/2, estimates.length-i);
		
	}
}

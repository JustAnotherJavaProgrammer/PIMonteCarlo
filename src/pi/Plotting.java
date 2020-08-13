package pi;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class Plotting {
	public static  void plot(double[] estimates) throws IOException {
		Process gnuplot = Runtime.getRuntime().exec("gnuplot");
		BufferedOutputStream plotter = new BufferedOutputStream(gnuplot.getOutputStream());
		// TODO finish implementation
	}
}

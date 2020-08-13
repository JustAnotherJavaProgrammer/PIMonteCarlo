package pi;

public class Main {
	public static void main(String[] args) {
		final int drops = 100000000;
		double[] estimates = new double[drops];

		MonteCarlo mc = new MonteCarlo();

		mc.init(drops, null);
		double pi = mc.calculate(new NewDropCallback() {

			@Override
			public void newValue(int dropTotal, int dropNo, double pi) {
				estimates[dropNo - 1] = pi;
			}
		});

		// Näherung für 20 Tropfen
		System.out.println(drops + "\t" + pi);

	}
}
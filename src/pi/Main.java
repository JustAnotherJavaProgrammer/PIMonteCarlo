package pi;

public class Main {
	public static void main(String[] args) {
		final int drops = Integer.MAX_VALUE;
//		double[] estimates = new double[drops];

		MonteCarlo mc = new MonteCarlo();

		mc.init(drops, null);
		double pi = mc.calculate(new NewDropCallback() {

			@Override
			public void newValue(int dropTotal, int dropNo, double pi) {
				if(dropNo % 1000000 == 0)
					System.out.println(dropNo + "\t" + pi);
//				estimates[dropNo - 1] = pi;
			}
		});

		// Näherung für 20 Tropfen
//		System.out.println(drops + "\t" + pi);
//		try {
//			Plotting.plot(estimates);
//		} catch (IOException | InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("Estimate: " + pi);
		System.out.println(Math.PI);
	}
}
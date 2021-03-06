package ex03_5;

/** 0から10まで足し足した値は都度表示するのにかかる時間 */
public class loopBenchmark extends Benchmark {

	@Override
	void benchmark() {
		int num = 0;
		for (int i = 0; i < 10; i++) {
			num += i;
			System.out.println(num);
		}
	}

	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);
		long time = new loopBenchmark().repeat(count);
		System.out.println(count + " methods in " + time + " nanoseconds");
	}

}

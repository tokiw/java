package ex03_5;

/** 0����10�܂ő����������l�͓s�x�\������̂ɂ����鎞�� */
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

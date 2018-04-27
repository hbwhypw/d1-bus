package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {

		// System.out.println(MD5.makeMd5("123456"));

		// double random = Math.random();
		// System.out.println(random);

		List<Long> list = new ArrayList<>();
		list.add(2L);
		for (long i = 3L; i < 10000000000000000L; i = i + 2) {
			Long prime = isPrime(list, i);
			if (null != prime) {
				list.add(prime);
			}

		}

	}

	public static Long isPrime(List<Long> list, long n) {
		

		for (Iterator<Long> iterator = list.iterator(); iterator.hasNext();) {
			Long long1 = iterator.next();

			if (n % long1 == 0)
				return null;
		}
		System.out.println(n);
//		System.out.println("------------" + n);
		return n;
	}
}

import java.util.Random;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import com.google.common.cache.LoadingCache;

public class CacheTest {
	@Test
	public void factorialCacheTest() throws ExecutionException {
		LoadingCache<Integer, Integer> factorialCache = FactorialCache
				.getCache();
		Random random = new Random();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 2000; i++) {
			int j = random.nextInt(1000);
			factorialCache.get(new Integer(j));
		}
		long end = System.currentTimeMillis() - start;

		System.out.println(end);
	}
}

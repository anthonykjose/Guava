import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * Basic Loading cache to return the Factorial of an integer.
 * 
 * @author anthojos
 * 
 */
public class FactorialCache {

	private static final LoadingCache<Integer, Integer> cache;

	static {
		// Create a cache loader with a load method to evaluate the
		// factorial.
		CacheLoader<Integer, Integer> cacheLoader = new CacheLoader<Integer, Integer>() {
			@Override
			public Integer load(Integer key) {
				int i = 1;
				int j = key.intValue();
				while (j > 1) {
					i *= j;
					j--;
				}
				return new Integer(i);
			}
		};
		// Build the cache.
		cache = CacheBuilder.newBuilder().maximumSize(1000)
				.expireAfterWrite(10, TimeUnit.MINUTES).build(cacheLoader);
	}

	/**
	 * Public access method to our loading cache. Implementations of the
	 * LoadingCache interface are all thread-safe and can be safely shared by
	 * multiple threads {@link http://tinyurl.com/mdmqrm2}
	 * 
	 * @return Cache object.
	 */
	public static LoadingCache<Integer, Integer> getCache() {
		return cache;
	}
}

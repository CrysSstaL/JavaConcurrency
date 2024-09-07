package src.com.test;

import java.math.BigInteger;
import java.util.Arrays;

public class VolatileCachedFactorizer{
    private volatile OneValueCache cache
            = new OneValueCache(null, null);

    public void service(Object request, Object response){
        BigInteger i = extractFromRequest(request);
        BigInteger [] factors = cache.getFactors(i);
        if (factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
        }
        encodeIntoResponse(response, factors);
    }

    // функция поиска множителей
    public BigInteger[] factor(BigInteger number){
        ////
        ///
        return new BigInteger[]{};
    }
    private void encodeIntoResponse(Object response, BigInteger[] factors) {
    }

    private BigInteger extractFromRequest(Object request) {
        return null;
    }
}

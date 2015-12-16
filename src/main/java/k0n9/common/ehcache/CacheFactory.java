package k0n9.common.ehcache;

import org.apache.ibatis.cache.Cache;

public interface CacheFactory {
    Cache getCache(String id);
}
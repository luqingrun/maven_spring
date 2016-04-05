package com.gongsibao.util.cache;

/**
 * Created by luqingrun on 16/3/29.
 */
public interface CacheService {
    /**
     * 默认有效时间为24小时
     *
     * @param key
     * @param value
     * @return
     */
    default boolean put(String key, Object value) {
        return put(key, value, 60 * 60 * 24);
    }

    boolean put(String key, Object value, int expireSecond);

    default <T> T get(String key, Class<T> clazz) {
        return (T) get(key);
    }

    Object get(String key);

    Object delete(String key);

    default <T> T delete(String key, Class<T> clazz) {
        return (T) delete(key);
    }

}

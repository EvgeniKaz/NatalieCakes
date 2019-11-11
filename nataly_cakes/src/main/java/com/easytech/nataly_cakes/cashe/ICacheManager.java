package com.easytech.nataly_cakes.cashe;

public interface ICacheManager {
	public void put(Object key, Object value);
	public Object get(Object key);
}

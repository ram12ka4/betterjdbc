package com.iooverflow.jdbc_better;

public class DemoClass<T> {
	
	private T t;
	
	public void set(T t){
		this.t = t;
	}
	
	public T get() {
		return t;
	}
	
}
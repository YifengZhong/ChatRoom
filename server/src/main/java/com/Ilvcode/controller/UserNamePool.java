package com.Ilvcode.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UserNamePool {
	private static Set<String> set ; 
	private UserNamePool() {
		
	}
	public synchronized  static Set<String> getInstance() {
		if(set == null) {
			set = new HashSet<>();
		}
		return set;
	}
}

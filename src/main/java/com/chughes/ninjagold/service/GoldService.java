package com.chughes.ninjagold.service;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GoldService {

	private int gold;
	
	public int getGold() {
		return gold;
	}
	
	public void processMoney(String hidden) {
		
		if (hidden.equals("farm")) {
			gold += new Random().nextInt(10) + 10;
		}
		
	}
	
}

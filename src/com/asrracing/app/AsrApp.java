package com.asrracing.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.asrracing.rest.AsrRest;

public class AsrApp extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public AsrApp() {
		singletons.add(new AsrRest());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}

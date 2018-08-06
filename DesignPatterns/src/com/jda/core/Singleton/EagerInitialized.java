package com.jda.core.Singleton;

public class EagerInitialized {
	private static final EagerInitialized instance = new EagerInitialized();

	private EagerInitialized() {
	}

	public static EagerInitialized getInstance() {
		return instance;
	}
}

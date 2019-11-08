package com.yyk.sz.common.base.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UtilThreadPool {

	private final ExecutorService executor;

	private static UtilThreadPool instance = new UtilThreadPool();

	private UtilThreadPool() {
		this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
	}

	public static UtilThreadPool getInstance() {
		return instance;
	}

	public static <T> Future<T> execute(final Callable<T> runnable) {
		return getInstance().executor.submit(runnable);
	}

	public static Future<?> execute(final Runnable runnable) {
		return getInstance().executor.submit(runnable);
	}

}

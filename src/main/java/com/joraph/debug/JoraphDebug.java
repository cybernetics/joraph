package com.joraph.debug;

import com.joraph.ObjectGraph;
import com.joraph.plan.ExecutionPlan;

public class JoraphDebug {
	
	private static InheritableThreadLocal<DebugInfo> debugInfo = new InheritableThreadLocal<>();

	public static void startDebug() {
		debugInfo.set(new DebugInfo());
	}

	public static DebugInfo finishDebug() {
		DebugInfo info = getDebugInfo();
		debugInfo.set(null);
		return info;
	}

	public static DebugInfo getDebugInfo() {
		return debugInfo.get();
	}

	public static boolean hasDebugInfo() {
		return debugInfo.get()!=null;
	}

	public static void addObjectGraph(ObjectGraph objectGraph) {
		if (!hasDebugInfo()) {
			return;
		}
		getDebugInfo().addObjectGraph(objectGraph);
	}

	public static void addExecutionPlan(ExecutionPlan executionPlan) {
		if (!hasDebugInfo()) {
			return;
		}
		getDebugInfo().addExecutionPlan(executionPlan);
	}

	public static void addLoaderDebug(LoaderDebug loaderDebug) {
		if (!hasDebugInfo()) {
			return;
		}
		getDebugInfo().addLoaderDebug(loaderDebug);
	}

	public static void addLoaderDebug(
			Class<?> entityClass, Long loaderTimeMillis, Integer loadedEntityCount, Integer entityIdCount) {
		if (!hasDebugInfo()) {
			return;
		}
		getDebugInfo().addLoaderDebug(
				entityClass, loaderTimeMillis,
				loadedEntityCount, entityIdCount);
	}

}

package com.joraph.debug;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.joraph.ObjectGraph;
import com.joraph.plan.ExecutionPlan;

public class DebugInfo {

	private Set<ObjectGraph> objectGraphs = new LinkedHashSet<>();
	private Set<ExecutionPlan> executionPlans = new LinkedHashSet<>();
	private List<LoaderDebug> loaderDebugs = new ArrayList<>();

	public void addObjectGraph(ObjectGraph objectGraph) {
		this.objectGraphs.add(objectGraph);
	}

	public void addExecutionPlan(ExecutionPlan executionPlan) {
		this.executionPlans.add(executionPlan);
	}

	public void addLoaderDebug(LoaderDebug loaderDebug) {
		this.loaderDebugs.add(loaderDebug);
	}

	public void addLoaderDebug(Class<?> entityClass, Long loaderTimeMillis,
			Integer loadedEntityCount, Integer entityIdCount) {
		LoaderDebug loaderDebug = new LoaderDebug();
		loaderDebug.setEntityClass(entityClass);
		loaderDebug.setLoadedEntityCount(loadedEntityCount);
		loaderDebug.setLoaderTimeMillis(loaderTimeMillis);
		loaderDebug.setEntityIdCount(entityIdCount);
		this.loaderDebugs.add(loaderDebug);
	}

	public Set<ObjectGraph> getObjectGraphs() {
		return objectGraphs;
	}

	public Set<ExecutionPlan> getExecutionPlans() {
		return executionPlans;
	}

	public List<LoaderDebug> getLoaderDebugs() {
		return loaderDebugs;
	}

}
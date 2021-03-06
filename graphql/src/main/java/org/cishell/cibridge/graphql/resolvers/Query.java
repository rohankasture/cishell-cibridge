package org.cishell.cibridge.graphql.resolvers;

import java.util.List;

import org.cishell.cibridge.core.CIBridge;
import org.cishell.cibridge.core.model.AlgorithmDefinition;
import org.cishell.cibridge.core.model.AlgorithmDefinitionQueryResults;
import org.cishell.cibridge.core.model.AlgorithmFilter;
import org.cishell.cibridge.core.model.AlgorithmInstance;
import org.cishell.cibridge.core.model.AlgorithmInstanceQueryResults;
import org.cishell.cibridge.core.model.DataFilter;
import org.cishell.cibridge.core.model.DataQueryResults;
import org.cishell.cibridge.core.model.LogFilter;
import org.cishell.cibridge.core.model.LogQueryResults;
import org.cishell.cibridge.core.model.NotificationFilter;
import org.cishell.cibridge.core.model.NotificationQueryResults;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {
	private CIBridge cibridge;

	public Query(CIBridge cibridge) {
		this.cibridge = cibridge;
		System.out.println("Query initialized");
	}

	public void setCIBridge(CIBridge cibridge) {
		this.cibridge = cibridge;
	}

	public CIBridge getCIBridge() {
		return this.cibridge;
	}

	// resolver functions
	public AlgorithmDefinitionQueryResults getAlgorithmDefinitions(AlgorithmFilter filter) {
		return cibridge.algorithm.getAlgorithmDefinitions(filter);
	}

	public AlgorithmInstanceQueryResults getAlgorithmInstances(AlgorithmFilter filter) {
		return cibridge.algorithm.getAlgorithmInstances(filter);
	}

	// TODO
	public String validateData(String algorithmDefinitionId, List<String> dataIds) {
		return cibridge.data.validateData(algorithmDefinitionId, dataIds);
	}

	public List<AlgorithmInstance> findConverters(String dataId, String outFormat) {
		return cibridge.data.findConverters(dataId, outFormat);
	}

	public List<AlgorithmInstance> findConvertersByFormat(String inFormat, String outFormat) {
		return cibridge.data.findConvertersByFormat(inFormat, outFormat);
	}

	public DataQueryResults getData(DataFilter filter) {
		return cibridge.data.getData(filter);
	}

	// public File downloadData(String dataId) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	public String downloadData(String dataId) {
		return cibridge.data.downloadData(dataId);
	}

	public NotificationQueryResults getNotifications(NotificationFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isClosed(String NotificationId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isSchedulerEmpty() {
		return cibridge.scheduler.isSchedulerEmpty();
	}

	public Boolean isSchedulerRunning() {
		return cibridge.scheduler.isSchedulerRunning();
	}

	public int getSchedulerQueueWaiting() {
		return cibridge.scheduler.getSchedulerQueueWaiting();
	}

	public LogQueryResults getLogs(LogFilter filter) {
		// TODO Auto-generated method stub
		return cibridge.logging.getLogs(filter);
	}

}
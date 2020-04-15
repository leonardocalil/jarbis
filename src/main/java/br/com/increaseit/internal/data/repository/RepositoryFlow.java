package br.com.increaseit.internal.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.increaseit.internal.data.entity.Flow;

public interface RepositoryFlow extends CrudRepository<Flow, Long> {
	
	List<Flow> findByNameIgnoreCase(final String name);
	
	List<Flow> findByNameContainingIgnoreCase(final String name);
	
	String queryReadyToExecute = "select f.* from flow f join frequence_interval fi on f.row_id = fi.flow_id " + 
					"where f.status = 'READY' and f.frequence = 'CYCLIC_MINUTE' and fi.status = 'WAITING' " + 
					"and (fi.last_execution is null or (fi.last_execution + (fi.interval::::text||' minute')::::INTERVAL) <= now()) union " +
				    "select f.* from flow f join frequence_weekday fw on f.row_id = fw.flow_id " +
				    "where f.status = 'READY' and f.frequence = 'CYCLIC_WEEKDAY' and fw.status = 'WAITING' " +
				    "and extract(dow from  current_date) = fw.week_day and fw.scheduled_time <= current_time union " +
				    "select f.* from flow f join frequence_datetime fd on f.row_id = fd.flow_id " +
				    "where f.status = 'READY' and f.frequence = 'SCHEDULED' and fd.status = 'WAITING' " +
				    "and fd.date_time <= current_timestamp ";
	@Query(value=queryReadyToExecute, nativeQuery=true)
	List<Flow> findAllReadyToExecute();
	
	
	String queryFinishedRecurrence = "select f.* from flow f join frequence_interval fi on f.row_id = fi.flow_id " + 
					"where f.status = 'READY' and f.frequence = 'CYCLIC_MINUTE' and fi.status = 'FINISHED' union " +
					"select f.* from flow f join frequence_weekday fw on f.row_id = fw.flow_id " +
				    "where f.status = 'READY' and f.frequence = 'CYCLIC_WEEKDAY' and fw.status = 'FINISHED' " +
				    "and extract(dow from  current_date) <> fw.week_day ";
	@Query(value=queryFinishedRecurrence, nativeQuery=true)
	List<Flow> findAllFinishedRecurrence();
}

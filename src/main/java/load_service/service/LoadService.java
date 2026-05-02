package load_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import load_service.entity.DOrder;
import load_service.entity.LoadData;
import load_service.repository.LoadRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoadService {
	private LoadRepository loadrepo;

	@KafkaListener(topics = "order-topic", groupId = "order-group" )
	public void consume(

			@Header(KafkaHeaders.RECEIVED_KEY) String key, DOrder orderEvent) {

		System.out.println("KEY = " + key);
		System.out.println(orderEvent);
		this.createLoadReport(orderEvent);
	}

	public void createLoadReport(DOrder orderEvent) {
		LoadData data = LoadData.builder().order_id(orderEvent.getId()).order_name(orderEvent.getName())
				.loadName(orderEvent.getName()).build();
		loadrepo.save(data);
	}

	public LoadData getLoadReport(Long id) {
		return loadrepo.findById(id).get();
	}
}

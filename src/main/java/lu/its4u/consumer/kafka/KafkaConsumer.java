package lu.its4u.consumer.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lu.its4u.consumer.service.VoitureService;
import lu.its4u.kafka.dto.Voiture;

@Component
public class KafkaConsumer {
	Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

	@Autowired
	private VoitureService voitureService;

	@KafkaListener(topics = { "#{'${kafka.topic.name}'}" }, groupId = "#{'${kafka.consumer.group-id}'}")
	public void consume(ConsumerRecord<String, Voiture> input) {
		log.info("recu: -- " + input.value());
		voitureService.save(input.value());
	}

}

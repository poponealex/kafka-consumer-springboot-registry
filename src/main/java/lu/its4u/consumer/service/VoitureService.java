package lu.its4u.consumer.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lu.its4u.consumer.entity.VoitureEntity;
import lu.its4u.consumer.repository.VoitureRepository;
import lu.its4u.kafka.dto.Voiture;

@Service
public class VoitureService {
	@Autowired
	private VoitureRepository voitureRepository;

	public void save(Voiture voiture) {
		VoitureEntity voitureEntity = new VoitureEntity();
		voitureEntity.setIdentifiant(voiture.getIdentifiant());
		voitureEntity.setDateMiseEnCirculation(new Date(voiture.getDateMiseEnCirculation()));
		voitureEntity.setMarque(voiture.getMarque().toString());
		voitureEntity.setModele(voiture.getModele().toString());
		voitureRepository.save(voitureEntity);
	}

}

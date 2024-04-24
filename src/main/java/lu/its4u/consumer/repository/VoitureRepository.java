package lu.its4u.consumer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lu.its4u.consumer.entity.VoitureEntity;

@Repository
public interface VoitureRepository extends CrudRepository<VoitureEntity, Integer> {

}

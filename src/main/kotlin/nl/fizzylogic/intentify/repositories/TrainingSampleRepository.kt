package nl.fizzylogic.intentify.repositories

import nl.fizzylogic.intentify.entities.TrainingSample
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Repository for the training samples
 */
@Repository
interface TrainingSampleRepository : CrudRepository<TrainingSample, Long> {
}
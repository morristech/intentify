package nl.fizzylogic.intentify.training;

import nl.fizzylogic.intentify.entities.TrainingSample;

/**
 * Stores training samples
 */
public interface TrainingSampleService {
    /**
     * Stores a new training sample
     *
     * @param sample Sample to store
     */
    void storeSample(TrainingSample sample);

    /**
     * Resets the sample storage
     */
    void reset();
}

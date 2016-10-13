package nl.fizzylogic.intentify.entities

/**
 * The training sample for the machine learning model
 * @param intent The intent of the sentence
 * @param text The text of the sentence
 */
data class TrainingSample(var intent: String, var text: String) {
}
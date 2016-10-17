package nl.fizzylogic.intentify.common;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.Json;
import nl.fizzylogic.intentify.entities.SubmitSampleForm;

/**
 * Message codec for encoding/decoding instance of {@link SubmitSampleForm}
 */
public class SubmitSampleFormCodec implements io.vertx.core.eventbus.MessageCodec<SubmitSampleForm, SubmitSampleForm> {
    /**
     * Encodes the message to wire level
     *
     * @param buffer           Buffer to write to
     * @param submitSampleForm Message to encode
     */
    @Override
    public void encodeToWire(Buffer buffer, SubmitSampleForm submitSampleForm) {
        buffer.appendString(Json.encode(submitSampleForm));
    }

    /**
     * Decodes the message from wire level
     *
     * @param pos    Position within the buffer
     * @param buffer The buffer
     * @return The decoded message
     */
    @Override
    public SubmitSampleForm decodeFromWire(int pos, Buffer buffer) {
        return Json.decodeValue(buffer.getString(0, buffer.length()), SubmitSampleForm.class);
    }

    /**
     * Transforms the input to the output message
     *
     * @param submitSampleForm The input message
     * @return The output message
     */
    @Override
    public SubmitSampleForm transform(SubmitSampleForm submitSampleForm) {
        return submitSampleForm;
    }

    /**
     * Gets the name of the codec
     *
     * @return
     */
    @Override
    public String name() {
        return "submit-sample-form-codec";
    }

    /**
     * Gets an indication whether this is a system codec
     *
     * @return -1 since this is a user codec
     */
    @Override
    public byte systemCodecID() {
        return -1;
    }
}


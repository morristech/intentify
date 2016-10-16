package nl.fizzylogic.intentify.common;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.Json;
import nl.fizzylogic.intentify.entities.SubmitSampleForm;

public class SubmitSampleFormCodec implements io.vertx.core.eventbus.MessageCodec<SubmitSampleForm, SubmitSampleForm> {

    @Override
    public void encodeToWire(Buffer buffer, SubmitSampleForm submitSampleForm) {
        buffer.appendString(Json.encode(submitSampleForm));
    }

    @Override
    public SubmitSampleForm decodeFromWire(int pos, Buffer buffer) {
        return Json.decodeValue(buffer.getString(0, buffer.length()), SubmitSampleForm.class);
    }

    @Override
    public SubmitSampleForm transform(SubmitSampleForm submitSampleForm) {
        return submitSampleForm;
    }

    @Override
    public String name() {
        return "submit-sample-form-codec";
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}


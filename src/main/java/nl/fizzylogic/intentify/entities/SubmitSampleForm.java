package nl.fizzylogic.intentify.entities;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class SubmitSampleForm {
    @NotNull
    @Length(min=1)
    private String text;

    @NotNull
    @Length(min=1)
    private String intent;

    public SubmitSampleForm() {
    }

    public SubmitSampleForm(String text, String intent) {
        this.text = text;
        this.intent = intent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubmitSampleForm that = (SubmitSampleForm) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return intent != null ? intent.equals(that.intent) : that.intent == null;

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (intent != null ? intent.hashCode() : 0);
        return result;
    }
}

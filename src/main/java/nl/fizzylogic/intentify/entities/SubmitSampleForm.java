package nl.fizzylogic.intentify.entities;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class SubmitSampleForm {
    @NotNull
    @Length(min = 1)
    private String text;

    @NotNull
    @Length(min = 1)
    private String intent;

    /**
     * Initializes a new instance of {@link SubmitSampleForm}
     */
    public SubmitSampleForm() {
        // Used for JSON encoding/decoding
    }

    /**
     * Initializes a new instance of {@link SubmitSampleForm}
     *
     * @param text   The text for the sentence
     * @param intent The intent of the sentence
     */
    public SubmitSampleForm(String text, String intent) {
        this.text = text;
        this.intent = intent;
    }

    /**
     * Gets the text of the sentence
     *
     * @return The text of the sentence
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text of the sentence
     *
     * @param text The text of the sentence
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the intent of the sentence
     *
     * @return The intent of the sentence
     */
    public String getIntent() {
        return intent;
    }

    /**
     * Sets the intent of the sentence
     *
     * @param intent The intent of the sentence
     */
    public void setIntent(String intent) {
        this.intent = intent;
    }

    /**
     * Compares this instance to another object to determine whether the two are equal
     *
     * @param o Other object to compare to
     * @return Returns true when the other object represents the same sentence; Otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SubmitSampleForm that = (SubmitSampleForm) o;

        if (text != null ? !text.equals(that.text) : that.text != null) {
            return false;
        }

        return intent != null ? intent.equals(that.intent) : that.intent == null;

    }

    /**
     * Gets the hashcode of this object
     *
     * @return The hashcode for the object
     */
    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (intent != null ? intent.hashCode() : 0);
        return result;
    }
}

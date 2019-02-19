package com.example.bl.adminer.commons;


public enum RequestStatus {
    NEW("NEW"),
    REJECTED("REJECTED"),
    ACCEPTED("ACCEPTED")
    ;

    private final String text;

    /**
     * @param text
     */
    RequestStatus(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
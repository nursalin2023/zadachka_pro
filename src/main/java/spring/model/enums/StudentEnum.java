package spring.model.enums;

public enum StudentEnum {
    OFFLINE("OFFLINE"),
    ONLINE("ONLINE");
    private String format;

    StudentEnum(String offline) {

    }

    void StudentEnum(String format) {
        this.format = format;
    }
}

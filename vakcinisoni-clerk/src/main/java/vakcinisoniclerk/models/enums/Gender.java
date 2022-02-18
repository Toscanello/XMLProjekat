package vakcinisoniclerk.models.enums;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender convertNumberToEnum(String number) {
        switch (number) {
            case "0":
                return Gender.MALE;
            case "1":
                return Gender.FEMALE;
        }
        return null;
    }
}

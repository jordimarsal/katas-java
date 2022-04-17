package net.jordimp.katas.dto;

public record PhoneNumber(String countryCode, String areaCode, String subscriberNumber) {

    public static PhoneNumber of(final String phoneNumber) {
        final String[] split = phoneNumber.split("-");
        validateCountryCode(split[0]);
        return new PhoneNumber(split[0], split[1], split[2]);
    }

    private static void validateCountryCode(final String s) {
        final String errorMessage = "Country code must be +XX or 00XX format";
        if ((s.contains("+") && s.length() != 3) || (s.contains("00") && s.length() != 4)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public String toString() {
        return String.format("%s-%s-%s", this.countryCode, this.areaCode, this.subscriberNumber);
    }

}

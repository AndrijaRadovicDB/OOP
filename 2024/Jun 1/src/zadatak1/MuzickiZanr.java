package zadatak1;

public enum MuzickiZanr {
    POP,
    ROK,
    REP;

    public static String prevediNaEngleski(MuzickiZanr muzickiZanr) {
        switch (muzickiZanr) {
            case POP:
                return "POP";
            case ROK:
                return "ROK";
            case REP:
                return "REP";
            default:
                return "";
        }
    }
}

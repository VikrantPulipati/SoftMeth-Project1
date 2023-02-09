public enum Major {
    CS("CS"),
    MATH("MATH"),
    EE("EE"),
    ITI("ITI"),
    BAIT("BAIT");

    private String majorName;

    Major (String name) {
        majorName = name;
    }

    public String getMajorName () {
        return this.majorName;
    }

    public static Major getMajorFromString (String name) {
        name = name.toUpperCase();
        if (name.equals(CS.getMajorName())) {
            return CS;
        }
        else if (name.equals(MATH.getMajorName())) {
            return MATH;
        }
        else if (name.equals(EE.getMajorName())) {
            return EE;
        }
        else if (name.equals(ITI.getMajorName())) {
            return ITI;
        }
        else if (name.equals(BAIT.getMajorName())) {
            return BAIT;
        } else {
            return null;
        }
    }
}
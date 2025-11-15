package cz.datbp2025.veverkyukol.model;

public class ApplicationData {

    private final String term;
    private final String parentName;
    private final String forename;
    private final String surname;
    private final String birthdate;
    private final String email;
    private final PaymentMethod payment;
    private final boolean isRestricted;
    private final String restrictionsText;
    private final String note;
    private final boolean agreedWithToc;


    private ApplicationData(String term, String parentName, String forename, String surname, String birthdate, String email, PaymentMethod payment, boolean isRestricted, String restrictionsText, String note, boolean agreedWithToc) {
        this.term = term;
        this.parentName = parentName;
        this.forename = forename;
        this.surname = surname;
        this.birthdate = birthdate;
        this.email = email;
        this.payment = payment;
        this.isRestricted = isRestricted;
        this.restrictionsText = restrictionsText;
        this.note = note;
        this.agreedWithToc = agreedWithToc;
    }

    public String term() {
        return term;
    }

    public String parentName() {
        return parentName;
    }

    public String forename() {
        return forename;
    }

    public String surname() {
        return surname;
    }

    public String birthdate() {
        return birthdate;
    }

    public String email() {
        return email;
    }

    public PaymentMethod payment() {
        return payment;
    }

    public boolean isRestricted() {
        return isRestricted;
    }

    public String restrictionsText() {
        return restrictionsText;
    }

    public String note() {
        return note;
    }

    public boolean agreedWithToc() {
        return agreedWithToc;
    }

    public static class Builder {
        private String term;
        private String parentName;
        private String forename;
        private String surname;
        private String birthdate;
        private String email;
        private PaymentMethod payment;
        private boolean isRestricted;
        private String restrictionsText;
        private String note;
        private boolean agreedWithToc;

        public Builder defaultData() {
            this.term = "01.01. - 07.01.2027";
            this.parentName = "Automatická Veverka";
            this.forename = "Veve";
            this.surname = "Automatická";
            this.birthdate = "01.01.2000";
            this.email = "automaticka.veverka@danakut.cz";
            this.payment = PaymentMethod.TRANSFER;
            this.isRestricted = false;
            this.restrictionsText  = "";
            this.note = "";
            this.agreedWithToc = true;
            return this;
        }

        public Builder from(ApplicationData data) {
            this.term = data.term;
            this.parentName = data.parentName;
            this.forename = data.forename;
            this.surname = data.surname;
            this.birthdate = data.birthdate;
            this.email = data.email;
            this.payment = data.payment;
            this.isRestricted = data.isRestricted;
            this.restrictionsText  = data.restrictionsText;
            this.note = data.note;
            this.agreedWithToc = data.agreedWithToc;
            return this;
        }

        public Builder withTerm(String term) {
            this.term = term;
            return this;
        }

        public Builder withParentName(String parentName) {
            this.parentName = parentName;
            return this;
        }

        public Builder withForename(String forename) {
            this.forename = forename;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withBirthdate(String birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPayment(PaymentMethod payment) {
            this.payment = payment;
            return this;
        }

        public Builder withRestricted(boolean isRestricted) {
            this.isRestricted = isRestricted;
            return this;
        }

        public Builder withRestrictionsText(String text) {
            this.restrictionsText = text;
            return this;
        }

        public Builder withNote(String note) {
            this.note = note;
            return this;
        }

        public Builder withAgreedWithToc(boolean agreedWithToc) {
            this.agreedWithToc = agreedWithToc;
            return this;
        }

        public ApplicationData build() {
            return new ApplicationData(term, parentName, forename, surname, birthdate, email, payment, isRestricted, restrictionsText, note, agreedWithToc);
        }
    }

}
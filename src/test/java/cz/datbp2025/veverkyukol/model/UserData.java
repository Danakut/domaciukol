package cz.datbp2025.veverkyukol.model;

public class UserData {

    private final String name;
    private final String email;
    private final String password;
    private final String passwordConfirm;
    private final UserRole role;


    private UserData(String name, String email, String password, String passwordConfirm, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.role = role;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    public String passwordConfirm() {
        return passwordConfirm;
    }

    public UserRole role() {
        return role;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[name=");
        sb.append(name);
        sb.append("; email=");
        sb.append(email);
        sb.append("; password=");
        sb.append(password);
        sb.append("; passwordConfirm=");
        sb.append(passwordConfirm);
        sb.append("; role=");
        sb.append(role.toString());
        return sb.toString();
    }

    public static class Builder {
        private String name = "";
        private String email = "";
        private String password = "";
        private String passwordConfirm  = "";
        private UserRole role = null;

        public Builder defaultData() {
            this.name = "Automatická Veverka";
            this.email = "automaticka.veverka@danakut.cz";
            this.password = "Password1";
            this.passwordConfirm  = "Password1";
            this.role = UserRole.PARENT;
            return this;
        }

        public Builder from(UserData data) {
            this.name = data.name;
            this.email = data.email;
            this.password = data.password;
            this.passwordConfirm = data.passwordConfirm;
            this.role = data.role;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withPasswordConfirm(String password) {
            this.password = password;
            return this;
        }

        public Builder withRole(UserRole role) {
            this.role = role;
            return this;
        }

        public UserData build() {
            return new UserData(name, email, password, passwordConfirm, role);
        }
    }

}
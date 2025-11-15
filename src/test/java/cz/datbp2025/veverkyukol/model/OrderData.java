package cz.datbp2025.veverkyukol.model;

public class OrderData {

    private final String ico;
    private final String client;
    private final String address;
    private final String substitute;
    private final String contactName;
    private final String phone;
    private final String email;
    private final String start1;
    private final String end1;
    private final String start2;
    private final String end2;
    private final String start3;
    private final String end3;


    private OrderData(String ico, String client, String substitute, String address, String contactName, String phone, String email, String start1, String end1, String start2, String end2, String start3, String end3) {
        this.ico = ico;
        this.client = client;
        this.address = address;
        this.substitute = substitute;
        this.contactName = contactName;
        this.phone = phone;
        this.email = email;
        this.start1 = start1;
        this.end1 = end1;
        this.start2 = start2;
        this.end2 = end2;
        this.start3 = start3;
        this.end3 = end3;
    }

    public String ico() {
        return ico;
    }

    public String client() {
        return client;
    }

    public String address() {
        return address;
    }

    public String substitute() {
        return substitute;
    }

    public String contactName() {
        return contactName;
    }

    public String phone() {
        return phone;
    }

    public String email() {
        return email;
    }

    public String start1() {
        return start1;
    }

    public String end1() {
        return end1;
    }

    public String start2() {
        return start2;
    }

    public String end2() {
        return end2;
    }

    public String start3() {
        return start3;
    }

    public String end3() {
        return end3;
    }

    public static class Builder {
        private String ico = "";
        private String client = "";
        private String address = "";
        private String substitute = "";
        private String contactName = "";
        private String phone = "";
        private String email = "";
        private String start1 = "";
        private String end1 = "";
        private String start2 = "";
        private String end2 = "";
        private String start3 = "";
        private String end3 = "";

        public Builder defaultData() {
            this.ico = "33333333";
            this.client = "Veverškola Brno";
            this.address = "Stromová 10";
            this.substitute = "Veverka Ředitelová";
            this.contactName = "Veverka Učitelová";
            this.phone = "987654321";
            this.email = "ucitelova.veverka@danakut.cz";
            this.start1 = "1.10.2027";
            this.end1 = "10.10.2027";
            this.start2 = "";
            this.end2 = "";
            this.start3 = "";
            this.end3 = "";
            return this;
        }

        public Builder from(OrderData data) {
            this.ico = data.ico;
            this.client = data.client;
            this.address = data.address;
            this.substitute = data.substitute;
            this.contactName = data.contactName;
            this.phone = data.phone;
            this.email = data.email;
            this.start1 = data.start1;
            this.end1 = data.end1;
            this.start2 = data.start2;
            this.end2 = data.end2;
            this.start3 = data.start3;
            this.end3 = data.end3;
            return this;
        }

        public Builder withIco(String ico) {
            this.ico = ico;
            return this;
        }

        public Builder withClient(String client) {
            this.client = client;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withSubstitute(String substitute) {
            this.substitute = substitute;
            return this;
        }

        public Builder withContactName(String contactName) {
            this.contactName = contactName;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withStart1(String start) {
            this.start1 = start;
            return this;
        }

        public Builder withEnd1(String end) {
            this.end1 = end;
            return this;
        }

        public Builder withStart2(String start) {
            this.start2 = start;
            return this;
        }

        public Builder withEnd2(String end) {
            this.end2 = end;
            return this;
        }

        public Builder withStart3(String start) {
            this.start3 = start;
            return this;
        }

        public Builder withEnd3(String end) {
            this.end3 = end;
            return this;
        }

        public OrderData build() {
            return new OrderData(ico, client, address,substitute, contactName, phone, email, start1, end1, start2, end2, start3, end3);
        }
    }

}
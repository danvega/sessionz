package dev.danvega.sessionz.speaker;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public final class Speaker {

        @Id
        private Integer id;
        private String name;
        private String title;
        private String company;
        @Enumerated(EnumType.STRING)
        @Column(length = 10)
        private Gender gender;
        private String country;
        private String email;
        private String phoneNumber;
        private String twitter;

        public Speaker() {
                
        }

        public Speaker(
                Integer id,
                String name,
                String title,
                String company,
                Gender gender,
                String country,
                String email,
                String phoneNumber,
                String twitter
        ) {
                this.id = id;
                this.name = name;
                this.title = title;
                this.company = company;
                this.gender = gender;
                this.country = country;
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.twitter = twitter;
        }

        @Id
        public Integer id() {
                return id;
        }

        public String name() {
                return name;
        }

        public String title() {
                return title;
        }

        public String company() {
                return company;
        }

        public Gender gender() {
                return gender;
        }

        public String country() {
                return country;
        }

        public String email() {
                return email;
        }

        public String phoneNumber() {
                return phoneNumber;
        }

        public String twitter() {
                return twitter;
        }

        @Override
        public boolean equals(Object obj) {
                if (obj == this) return true;
                if (obj == null || obj.getClass() != this.getClass()) return false;
                var that = (Speaker) obj;
                return Objects.equals(this.id, that.id) &&
                        Objects.equals(this.name, that.name) &&
                        Objects.equals(this.title, that.title) &&
                        Objects.equals(this.company, that.company) &&
                        Objects.equals(this.gender, that.gender) &&
                        Objects.equals(this.country, that.country) &&
                        Objects.equals(this.email, that.email) &&
                        Objects.equals(this.phoneNumber, that.phoneNumber) &&
                        Objects.equals(this.twitter, that.twitter);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, title, company, gender, country, email, phoneNumber, twitter);
        }

        @Override
        public String toString() {
                return "Speaker[" +
                        "id=" + id + ", " +
                        "name=" + name + ", " +
                        "title=" + title + ", " +
                        "company=" + company + ", " +
                        "gender=" + gender + ", " +
                        "country=" + country + ", " +
                        "email=" + email + ", " +
                        "phoneNumber=" + phoneNumber + ", " +
                        "twitter=" + twitter + ']';
        }

}
package dev.danvega.sessionz.event;

import dev.danvega.sessionz.session.Session;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {

        @Id
        private Integer id;
        private String name;
        @Column(columnDefinition = "TEXT")
        private String description;
        private LocalDate startDate;
        private LocalDate endDate;
        private LocalDate cfpStartDate;
        private LocalDate cfpEndDate;
        private String location;
        private String website;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
        //@JoinColumn(name = "event_id"),
        private Set<Session> sessions = new HashSet<>();

        public Event() {

        }

        public Event(Integer id, String name, String description, LocalDate startDate, LocalDate endDate, LocalDate cfpStartDate, LocalDate cfpEndDate, String location, String website) {
                this.id = id;
                this.name = name;
                this.description = description;
                this.startDate = startDate;
                this.endDate = endDate;
                this.cfpStartDate = cfpStartDate;
                this.cfpEndDate = cfpEndDate;
                this.location = location;
                this.website = website;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public LocalDate getStartDate() {
                return startDate;
        }

        public void setStartDate(LocalDate startDate) {
                this.startDate = startDate;
        }

        public LocalDate getEndDate() {
                return endDate;
        }

        public void setEndDate(LocalDate endDate) {
                this.endDate = endDate;
        }

        public LocalDate getCfpStartDate() {
                return cfpStartDate;
        }

        public void setCfpStartDate(LocalDate cfpStartDate) {
                this.cfpStartDate = cfpStartDate;
        }

        public LocalDate getCfpEndDate() {
                return cfpEndDate;
        }

        public void setCfpEndDate(LocalDate cfpEndDate) {
                this.cfpEndDate = cfpEndDate;
        }

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public String getWebsite() {
                return website;
        }

        public void setWebsite(String website) {
                this.website = website;
        }

        @Override
        public String toString() {
                return "Event{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", description='" + description + '\'' +
                        ", startDate=" + startDate +
                        ", endDate=" + endDate +
                        ", cfpStartDate=" + cfpStartDate +
                        ", cfpEndDate=" + cfpEndDate +
                        ", location='" + location + '\'' +
                        ", website='" + website + '\'' +
                        '}';
        }
}
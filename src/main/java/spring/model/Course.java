package spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


    @Entity
    @Setter
    @Getter
    @NoArgsConstructor
    public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "courseName")
        private String courName;
        @Column(name = "duration")
        private String duration;
        @ManyToOne
        @JoinColumn(name = "company_id")
        private Company company;
        @ManyToMany
        @JoinTable(name = "course_groups", joinColumns = {@JoinColumn(name = "course_id")}, inverseJoinColumns = {@JoinColumn(name = "group_id")})
        private List<Groups> groups;
        @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
        private Teacher teacher;
        public Course(String courName, String duration) {
            this.courName = courName;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "id=" + id +
                    ", courName='" + courName + '\'' +
                    ", duration=" + duration +
                    '}';
        }
    }


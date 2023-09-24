package edu.miu.cs.cs425.eregistrar.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_student")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long studentId;
    @Column(name = "student_number", unique = true, nullable = false)
    private String studentNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "cgpa")
    private Double cgpa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;
    @Column(name = "is_international")
    private Boolean isInternational;
}

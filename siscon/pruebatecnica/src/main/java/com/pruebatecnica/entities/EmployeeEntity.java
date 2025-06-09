package com.pruebatecnica.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "employees", indexes = {
        @Index(name = "idx_gender", columnList = "gender"),
        @Index(name = "idx_position ", columnList = "position"),
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(length = 30, nullable = false)
    private String givenName;

    @Column(length = 30, nullable = false)
    private String middleName;

    @Column(length = 30, nullable = false)
    private String surname;

    private Integer age;

    private String gender;

    private LocalDate birthDay;

    @Column(length = 30, nullable = false)
    private String position;
}

package com.ikm.Citizen.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name="citizen")
public class Citizen {


        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        int id;

        @NotEmpty
        @Column(name="name")
        String name;

        @NotEmpty
        @Column(name="address")
        String address;

        @Column(name="phone ")
        String phone ;

        @Past(message = "dateOfBirth should be a past date")
        @Column(name ="dateOfBirth")
        Date dateapplied;

}


package com.gfg.spring.transactions.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // @NotNull constraint does not accept null as valid!
    @NotBlank(message = "Employee name cannot be empty")
    @Size(min = 2, max = 200, message = "Employee name must have a length between 2 and 200 characters")
    private String name;

    // @Email constraint accepts null as valid!
    @Email(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Please enter a valid email Id")
    @NotNull(message = "Email cannot be Null")
    private String email;

    // value should be 18yrs ago, 2025-2007=18
    @Max(value = 2007, message = "Minimum working age must be 18")
    private int yearOfBirth;

    // Like 1234-01000, or just 01908 without box number
    @Pattern(regexp = "^(\\d+-)?\\d{5}$", message = "Postal code must be a 5-digit number with optional box number")
    private String postalCode;
}

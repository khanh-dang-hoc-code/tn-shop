package com.tech.tnshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Entity
@Table(name = "profile")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Profile {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    @Pattern(regexp = "^(\\+84|0)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5|8|9]|9[0-4|6-9])(\\d{7})$", message = "Incorrect phone number format")
    @NotNull(message = "The phone number can be not null")
    private String telephoneNumber;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private String address1;
    @Column
    private String address2;
    @Column
    private String address3;
    @Column
    private String email;

    @CreationTimestamp
    @Column
    private LocalDate createdAt;

    @Column
    @UpdateTimestamp
    private LocalDate updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "imageUrl", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfileImage> profileImageList;

}

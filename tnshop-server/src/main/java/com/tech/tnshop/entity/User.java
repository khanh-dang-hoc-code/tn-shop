package com.tech.tnshop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tech.tnshop.shop_enum.UserStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String id;

    @Column(unique = true)
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email address is not valid, let try again.")
    private String email;

    @Column(unique = true)
    @Pattern(regexp = "^(\\+84|0)(3[2-9]|5[6|8|9]|7[0|6-9]|8[1-5|8|9]|9[0-4|6-9])(\\d{7})$", message = "Incorrect phone number format")
    @NotBlank(message = "userName is not blank")
    private String userName;

    @Column
    private String password;

    @CreationTimestamp
    @Column
    private LocalDate createdAt;

    @Column
    @UpdateTimestamp
    private LocalDate updatedAt;

    @Column(length = 10)
    private String status;

    @Column(length = 10)
    private String role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private transient Profile profile;


    @OneToOne(mappedBy = "cartUser", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private transient Cart cartUser;

    @OneToMany(mappedBy = "userComment",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private transient List<Comment> commentList;

    @OneToMany(mappedBy = "postUser", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private transient List<Post> userPostList;

    @OneToOne(mappedBy = "userReview", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private transient Review review;

    @OneToMany(mappedBy = "userOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private transient List<Order> userOrderList;

    @OneToMany(mappedBy = "userReceiveLocation", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private transient List<ReceiveLocation> userReceiveLocationList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.role));
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status.equalsIgnoreCase(UserStatusEnum.ACTIVE.name());
    }

    @Override
    public String getPassword() {
        return password;
    }
}

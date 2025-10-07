package com.trainJava.demo.entities;

import java.util.Collection;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_accounts")
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount implements UserDetails {

    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, unique = true, length = 100)
    private String username;
    @Column(nullable = false, length = 100, unique = true)
    @JsonIgnore
    private String password;
    @Column(nullable = false, length = 100)
    private String role = "USER";
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", unique = true)
    @JsonProperty("employeeId")
    private Employee employee;

    public UUID getEmployee() {
        return employee.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

}

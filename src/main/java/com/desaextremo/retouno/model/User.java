package com.desaextremo.retouno.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author desarrolloextremo
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "user", indexes = @Index(name = "indx_email", columnList = "user_email", unique = true))
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "user_email", nullable = false, length = 50)
    private String email;
    @NonNull
    @Column(name = "user_password", nullable = false, length = 50)
    private String password;
    @NonNull
    @Column(name = "user_name", nullable = false, length = 80)
    private String name;   
}

package com.github.solairerove.facepalm.domain.model.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Persistable<Integer> {

    private static final long serialVersionUID = -1515312152555322990L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "username", length = 64, unique = true)
    @NotNull
    @Size(min = 4, max = 64)
    private String username;

    @Column(name = "password", length = 64, unique = true)
    @NotNull
    @Size(min = 8, max = 64)
    private String password;

    @Column(name = "first_name", length = 64, unique = true)
    @NotNull
    @Size(min = 4, max = 64)
    private String firstName;

    @Column(name = "last_name", length = 64, unique = true)
    @NotNull
    @Size(min = 4, max = 64)
    private String lastName;

    @Column(name = "email", length = 64, unique = true)
    @NotNull
    @Size(min = 4, max = 64)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private List<Authority> authorities;

    @JsonIgnore
    @Override
    public Integer getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public boolean isNew() {
        return false;
    }
}

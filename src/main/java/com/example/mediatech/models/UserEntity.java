package com.example.mediatech.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity  implements Serializable {

    @Id
    @Column(name = "user_id")
    private Integer userID;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;


    @ManyToMany
    @JoinTable(name="user_roles", joinColumns = @JoinColumn(name="userID"),
        inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private List<RoleEntity> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserProfile profile;

}

package bada.model;

import bada.security.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "users")
public class User implements UserDetails {

    public enum Role{
        ADMIN, EMPLOYEE, CLIENT;
    }

    @Id
    @SequenceGenerator(name = "user_gen", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "login", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    private String role = UserRole.CLIENT.name();

    @Column(name = "enabled")
    private boolean isEnabled = true;

    public User(){

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> set = new HashSet();
        set.add(new SimpleGrantedAuthority("ROLE_" + role));
        return set;
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
        return isEnabled;
    }


    @Override
    public String getUsername() { return username; }
    @Override
    public String getPassword() { return password; }

    public Integer getId() { return id; }
    public void setPassword(String value) {password = value;}
}

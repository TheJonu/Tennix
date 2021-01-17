package bada.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.stream.Collectors;

import static bada.security.UserPermission.*;

public enum UserRole {
    //ADMIN(Sets.newHashSet(POCZTY_READ, POCZTY_WRITE, HIDDEN_READ, HIDDEN_WRITE)),
    //EMPLOYEE(Sets.newHashSet(POCZTY_READ, HIDDEN_READ)),
    //CLIENT(Sets.newHashSet());
    ADMIN,
    EMPLOYEE,
    CLIENT;

    /*
    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }
    */
}
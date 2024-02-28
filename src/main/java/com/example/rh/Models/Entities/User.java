package com.example.rh.Models.Entities;
import com.example.rh.Models.Enum.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@MappedSuperclass
public abstract class User implements UserDetails {
        private String first_name;

        private String last_name;
        private String username;

        private String email;

        private String password;

        private String image;

        private String telephone;

        private String address;
        @Enumerated(EnumType.STRING)
        private Role role;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                var authorities = role.getAuthorities().stream().map(
                        permission -> new SimpleGrantedAuthority(permission.getAuthority())
                ).collect(Collectors.toList());

                return authorities ;
        }
        @Override
        public String getPassword() {
                return this.password;
        }

        @Override
        public String getUsername() {
                return this.username;
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
                return true;
        }
}

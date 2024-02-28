package com.example.rh.Models.Enum;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.rh.Models.Enum.Permission.*;


@RequiredArgsConstructor
public enum Role {

    USER(Collections.EMPTY_SET),
       CEO (
            Set.of(
                    CEO_READ,
                    CEO_CREATE,
                    CEO_UPDATE,
                    CEO_DELETE

            )
    )

    , CHRO(
            Set.of(
                    CHRO_READ,
                    CHRO_CREATE,
                    CHRO_UPDATE,
                    CHRO_DELETE
            )

    )



    , PROJECT_MANAGER(
            Set.of(
                    PROJECT_MANAGER_READ,
                    PROJECT_MANAGER_CREATE,
                    PROJECT_MANAGER_UPDATE,
                    PROJECT_MANAGER_DELETE

            )
    )

    , STANDARD_EMPLOYER(
            Set.of(
                    STANDARD_EMPLOYER_READ,
                    STANDARD_EMPLOYER_CREATE,
                    STANDARD_EMPLOYER_UPDATE,
                    STANDARD_EMPLOYER_DELETE

            )
    )
    ;



    @Getter
    private final Set<Permission> Permissions ;


    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions().stream().map(
                permission -> new SimpleGrantedAuthority(permission.getPermission())
        ).collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));

        return authorities ;
    }
}



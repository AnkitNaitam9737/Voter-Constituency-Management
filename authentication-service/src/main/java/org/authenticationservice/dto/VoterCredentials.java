package org.authenticationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VoterCredentials {
    private Integer id;
    private String voterName;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    private Integer constituencyId;
}

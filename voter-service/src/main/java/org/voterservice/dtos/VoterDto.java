package org.voterservice.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoterDto {
    private Integer id;
    private String voterName;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    private Integer constituencyId;
}

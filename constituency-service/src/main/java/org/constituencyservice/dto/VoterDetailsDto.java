package org.constituencyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VoterDetailsDto {
    private Integer id;
    private String voterName;
    private String email;
    private Integer age;
    private String gender;
    private Integer constituencyId;
}

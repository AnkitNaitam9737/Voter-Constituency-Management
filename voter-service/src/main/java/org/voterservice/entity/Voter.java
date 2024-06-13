package org.voterservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "voter_details")
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String voterName;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    private Integer constituencyId;
}

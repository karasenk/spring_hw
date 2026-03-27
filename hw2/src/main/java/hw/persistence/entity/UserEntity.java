package hw.persistence.entity;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private Long id;
    private String nickname;
    private String email;
    private String bio;
    private String password;
    private Date joinDate;
}


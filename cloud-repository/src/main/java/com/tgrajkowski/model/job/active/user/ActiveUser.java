package com.tgrajkowski.model.job.active.user;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ActiveUser {
    private String login;
    private int count;
}

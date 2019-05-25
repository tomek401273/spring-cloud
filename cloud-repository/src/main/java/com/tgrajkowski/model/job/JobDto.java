package com.tgrajkowski.model.job;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    private Long id;
    private String title;
    private Date date;
    private String user;
}

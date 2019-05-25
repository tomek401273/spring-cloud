package com.tgrajkowski.model.job.daily;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JobDaily {
    private Date date;
    private Integer count;
}

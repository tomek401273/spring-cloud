package com.tgrajkowski.model.job.daily;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class JobsDaily {
    public List<String> dateList;
    private List<Integer> counts;
}

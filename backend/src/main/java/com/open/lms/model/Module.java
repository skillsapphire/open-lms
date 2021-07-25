package com.open.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    private String id;
    private String title;
    private Boolean draft;
    private List<Lesson> lessons;
}

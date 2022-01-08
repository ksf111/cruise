package com.erat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Liner {

    String name;
    Integer passengers;
    Integer crew;
    Long id;
}

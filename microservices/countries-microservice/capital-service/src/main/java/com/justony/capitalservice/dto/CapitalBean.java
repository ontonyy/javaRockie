package com.justony.capitalservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CapitalBean {
    private String country, name, capital;
    private int port;
}

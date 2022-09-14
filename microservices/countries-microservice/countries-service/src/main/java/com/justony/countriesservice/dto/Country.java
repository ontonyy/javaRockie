package com.justony.countriesservice.dto;


import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Data
@NoArgsConstructor
public class Country {
    @Id
    private String country;

    @Column @NotNull
    private String name;

    @Column @NotNull
    private String currency;

    @Column @NotNull
    private String language;

    @Transient
    int port;
}

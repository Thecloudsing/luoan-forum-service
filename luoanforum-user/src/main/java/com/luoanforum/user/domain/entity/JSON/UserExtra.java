package com.luoanforum.user.domain.entity.JSON;

import lombok.*;
import org.checkerframework.checker.units.qual.N;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
//@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class UserExtra implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}

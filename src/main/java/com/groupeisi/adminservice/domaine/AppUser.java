package com.groupeisi.adminservice.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    private int id;
    @NotNull(message = "Le email ne doit pas etre null ")
    private String email;
    @NotNull(message = "Le password ne doit pas etre null ")
    private String password;
}

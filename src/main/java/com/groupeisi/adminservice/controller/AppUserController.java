package com.groupeisi.adminservice.controller;


import com.groupeisi.adminservice.domaine.AppUser;
import com.groupeisi.adminservice.entites.AppUserEntity;
import com.groupeisi.adminservice.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/appuser")
@AllArgsConstructor
public class AppUserController {
    private AppUserService appUserService;

    @GetMapping
    public List<AppUser> getAppUser() {
        return appUserService.getAppuser();
    }

    @GetMapping("/{id}")
    public AppUser getAppUser(@PathVariable("id") int id) {
        return appUserService.getAppUser(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppUser createAppUser(@Valid @RequestBody AppUser appUser) {
        return appUserService.createAppUser(appUser);
    }

    @PutMapping("/{id}")
    public AppUser updateAppUser(@PathVariable("id") int id, @Valid @RequestBody AppUser appUser) {
        return appUserService.updateAppUser(id, appUser);
    }

    @DeleteMapping("/{id}")
    public void deleteAppUser(@PathVariable("id") int id) {
        appUserService.deleteAppUser(id);
    }

}

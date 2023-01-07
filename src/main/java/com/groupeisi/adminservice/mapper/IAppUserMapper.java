package com.groupeisi.adminservice.mapper;


import com.groupeisi.adminservice.domaine.AppUser;
import com.groupeisi.adminservice.entites.AppUserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface IAppUserMapper {
    AppUser toAppUser(AppUserEntity appUserEntity);
    AppUserEntity fromAppUser(AppUser appUser);
}

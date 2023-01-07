package com.groupeisi.adminservice.repository;

import com.groupeisi.adminservice.entites.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUserEntity,Integer> {
}

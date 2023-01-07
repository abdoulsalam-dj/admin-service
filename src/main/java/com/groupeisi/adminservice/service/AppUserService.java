package com.groupeisi.adminservice.service;


import com.groupeisi.adminservice.domaine.AppUser;
import com.groupeisi.adminservice.mapper.IAppUserMapper;
import com.groupeisi.adminservice.repository.IAppUserRepository;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppUserService {
    private IAppUserRepository iAppUserRepository;
    private IAppUserMapper iAppUserMapper;
    MessageSource messageSource;

    public AppUserService(IAppUserRepository iAppUserRepository, IAppUserMapper iAppUserMapper,MessageSource messageSource) {
        this.iAppUserRepository = iAppUserRepository;
        this.iAppUserMapper = iAppUserMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<AppUser> getAppuser() {
        return StreamSupport.stream(iAppUserRepository.findAll().spliterator(), false)
                .map(iAppUserMapper::toAppUser)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AppUser getAppUser(int id) {
        return iAppUserMapper.toAppUser(iAppUserRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public AppUser createAppUser(AppUser appUser) {
        return iAppUserMapper.toAppUser(iAppUserRepository.save(iAppUserMapper.fromAppUser(appUser)));
    }

    @Transactional
    public AppUser updateAppUser(int id, AppUser appUser) {
        return iAppUserRepository.findById(id)
                .map(entity -> {
                    appUser.setId(id);
                    return iAppUserMapper.toAppUser(
                            iAppUserRepository.save(iAppUserMapper.fromAppUser(appUser)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteAppUser(int id) {
        try {
            iAppUserRepository.deleteById(id);
        } catch (Exception e) {
            /*throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);*/
        }
    }
}

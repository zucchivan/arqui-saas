package zucchivan.dev.service;

import org.springframework.stereotype.Service;
import zucchivan.dev.model.AppUser;
import zucchivan.dev.model.repository.AppUserRepository;

import java.util.List;

@Service
public class UserService {

    private final AppUserRepository appUserRepository;

    public UserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> fetchAllUsers() {
        return appUserRepository.findAll();
    }
}
package zucchivan.dev.service;

import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import zucchivan.dev.data.AppUser;

import java.util.List;

@Service
public class UserService {

    private final DSLContext dsl;

    public UserService(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<AppUser> fetchAllUsers() {
        return dsl.select()
                  .from("app_user")
                  .fetchInto(AppUser.class);
    }
}
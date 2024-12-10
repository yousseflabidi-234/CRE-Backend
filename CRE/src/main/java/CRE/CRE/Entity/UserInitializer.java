package CRE.CRE.Entity;

import CRE.CRE.Entity.UserCRE;
import CRE.CRE.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public UserInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("responsable_bct").isEmpty()) {
            UserCRE admin = new UserCRE();
            admin.setUsername("responsable_bct");
            admin.setPassword("234"); // Use encoded password in production
            admin.setRole("ROLE_RESPONSABLE_BCT");
            userRepository.save(admin);
        }

        if (userRepository.findByUsername("user").isEmpty()) {
            UserCRE user = new UserCRE();
            user.setUsername("user");
            user.setPassword("432"); // Use encoded password in production
            user.setRole("ROLE_USER");
            userRepository.save(user);
        }
    }
}

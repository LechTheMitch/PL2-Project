package AccountManagement;

import UserTypes.User;

@FunctionalInterface

public interface LoginManager {
    <T extends User>void doStuff(T user);
}

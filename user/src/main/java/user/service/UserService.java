package user.service;

import user.entity.Result;

public interface UserService {
    public void saveUser(String id);
    public Result login(String id, String password);
    public Result changePassword(String id, String password);
}

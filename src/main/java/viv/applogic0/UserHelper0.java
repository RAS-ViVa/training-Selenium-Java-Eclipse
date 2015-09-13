package viv.applogic0;

import viv.applogic.UserHelper;
import viv.model.User;

public class UserHelper0 implements UserHelper {

  private User user;

  @Override
  public void loginAs(User user) {
    this.user = user;
  }

  @Override
  public void logout() {
    this.user = null;
  }

  @Override
  public boolean isLoggedIn() {
    return user != null;
  }

  @Override
  public boolean isLoggedInAs(User user) {
    return isLoggedIn() && this.user.getLogin().equals(user.getLogin());
  }

  @Override
  public boolean isNotLoggedIn() {
    return user == null;
  }

}

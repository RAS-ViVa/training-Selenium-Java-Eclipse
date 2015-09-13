package viv.applogic0;

import viv.applogic.ApplicationManager;
import viv.applogic.FilmHelper;
import viv.applogic.NavigationHelper;
import viv.applogic.UserHelper;

public class ApplicationManager0 implements ApplicationManager {

  UserHelper userHelper = new UserHelper0();
  FilmHelper filmHelper = new FilmHelper0();
  
  @Override
  public UserHelper getUserHelper() {
    return userHelper;
  }

  @Override
  public FilmHelper getFilmHelper() {
    return filmHelper;
  }

  @Override
  public NavigationHelper getNavigationHelper() {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public void stop() {
    // TODO Auto-generated method stub
    
  }
}
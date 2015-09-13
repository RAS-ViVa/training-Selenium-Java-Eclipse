package viv;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import viv.applogic.ApplicationManager;
import viv.applogic0.ApplicationManager0;
import viv.applogic1.ApplicationManager1;

public class TestBase {

  protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager1();
	}
	
	@AfterSuite
	public void stop() {
		app.stop();
	}

}
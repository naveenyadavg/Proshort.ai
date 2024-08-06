package Supports;

import Pages.*;
import org.openqa.selenium.WebDriver;

public class PagesClass {
    public static LoginPage loginPage;
    public static WebDriverHelper webDriverHelper;
    public static ActivitiesPage activitiesPage;
    public static ManageVideosPage manageVideosPage;
    public static ManageUsersPage manageUsersPage;
    public static ManageGroupsPage manageGroupsPage;
    public static WorkSpaceSetUpPage workSpaceSetUpPage;
    public static AnalyticsPage analyticsPage;
    public static AccountPage accountPage;
    public static DashboardPage dashboardPage;
    public static  HomePage homePage;
    final WebDriver driver = new BrowserCreation().getDriver();

    public void driverClass() {
        PagesClass.loginPage = new LoginPage(driver);
        PagesClass.webDriverHelper = new WebDriverHelper(driver);
        PagesClass.activitiesPage = new ActivitiesPage(driver);
        PagesClass.manageVideosPage = new ManageVideosPage(driver);
        PagesClass.manageUsersPage = new ManageUsersPage(driver);
        PagesClass.manageGroupsPage = new ManageGroupsPage(driver);
        PagesClass.analyticsPage = new AnalyticsPage(driver);
        PagesClass.workSpaceSetUpPage = new WorkSpaceSetUpPage(driver);
        PagesClass.accountPage = new AccountPage(driver);
        PagesClass.dashboardPage = new DashboardPage(driver);
        PagesClass.homePage = new HomePage(driver);
    }
}

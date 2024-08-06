package Pages;

import Supports.Constants;
import Supports.PropertiesReader;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static Supports.Constants.*;
import static Supports.PagesClass.activitiesPage;
import static Supports.PagesClass.webDriverHelper;
import static Supports.WebDriverHelper.extractNumbers;

public class ManageGroupsPage {
    private WebDriver driver;

    public ManageGroupsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@id, 'headlessui-disclosure-button')]//span[text()='Users & Groups']")
    private WebElement manageUsersGroupsTab;
    @FindBy(xpath = "//div[contains(@id, 'headlessui-disclosure-panel')]/a")
    private List<WebElement> manageBtn;
    @FindBy(xpath = "(//div[contains(@class,'flex items-center')]//button)[1]")
    private WebElement createBtn;
    @FindBy(xpath = "(//tbody/tr/td[1]//p)[1]")
    private WebElement firstGroup;
    @FindBy(xpath = "//tbody/tr/td[1]//p")
    private List<WebElement> groupsList;
    @FindBy(xpath = "//div[contains(@id , 'headlessui-dialog-panel')]//p[contains(@class,'font-bold leading')]")
    private WebElement createBtnHeaderTitle;
    @FindBy(xpath = "//div[contains(@id , 'headlessui-dialog-panel')]//input[@placeholder]")
    private WebElement enterGroupName;
    @FindBy(xpath = "//form/div[@class=' cursor-default text-black']")
    private WebElement toastMsg;
    @FindBy(xpath = "//button[text()='Next']")
    private WebElement nextBtn;
    @FindBy(xpath = "//p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'add people')]")
    private WebElement addPeopleTitle;
    @FindBy(xpath = "//div[@class='relative px-4']/div/ul/li//div[@class='cursor-pointer truncate text-xs font-semibold']")
    private List<WebElement> membersList;
    @FindBy(xpath = "(//div[@class='relative px-4']/div)[1]//p")
    private List<WebElement> selectedMembersList;
    @FindBy(xpath = "//div[@class='cursor-pointer truncate text-xs font-semibold']")
    private List<WebElement> membersListAfterAddingMembers;
//    @FindBy(xpath = "//div[contains(@class,'hover group relative')]")
//    private List<WebElement> membersListAfterAddingMembers;
    @FindBy(xpath = "//button/span[text()='Add Members']")
    private WebElement addMemberBtn;
    @FindBy(xpath = "//p[contains(@class,'cursor-pointer text-sm font-semibold leading')]")
    private WebElement memberCount;
    @FindBy(xpath = "//div[contains(@id,'headlessui-dialog-panel')]/*[local-name()='svg']")
    private WebElement cancelBtn;
    @FindBy(xpath = "//input[@placeholder='Type something to search']")
    private WebElement searchBar;
    @FindBy(xpath = "//tbody/tr/td[3]")
    private WebElement createdDate;
    @FindBy(xpath = "//tbody/tr/td[2]")
    private WebElement createdBy;
    @FindBy(xpath = "//button[contains(@id,'headlessui-menu-button')]")
    private List<WebElement> activityMenuBtn;
    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveBtn;
    @FindBy(xpath = "//div[text()='Edit group']")
    private WebElement editGroupTitle;
    @FindBy(xpath = "//div[contains(@class,'cursor-pointer items-center justify-center rounded')]/*[local-name()='svg']")
    private WebElement addBtn;
    @FindBy(xpath = "//div[contains(@class,' font-bold text')]")
    private WebElement deactivateMsg;
    @FindBy(xpath = "//span[text()='Deactivate']")
    private WebElement deactivateBtn;
    @FindBy(xpath = "//h1[contains(@class,'font-semibold text-gray')]")
    private WebElement browseGroupTitle;
    @FindBy(xpath = "//label")
    private List<WebElement> groupType;
    @FindBy(xpath = "//span[text()=' Add Groups']")
    private WebElement addGroupBtn;
    @FindBy(xpath = "//div[contains(@class,'relative grid')]//a")
    private List<WebElement> groupTypeList;
    @FindBy(xpath = "//button[text()='Add']")
    private List<WebElement> addMembersBtnList;
    @FindBy(xpath = "//div[contains(@class,'truncate text-start text')]")
    private List<WebElement> membersNameList;
    @FindBy(xpath = "//div[contains(@id,'headlessui-dialog-panel')]/*[local-name()='svg']")
    private WebElement createGroupTabCloseBtn;
    @FindBy(xpath = "//div[contains(@id,'headlessui-disclosure-panel')]//button")
    private List<WebElement> groupList;
    @FindBy(xpath = "//span[text()='Groups']")
    private WebElement groupsBtn;
    @FindBy(xpath = "//div[contains(@class,'flex w-full items-center justify-start gap')]/*[local-name()='svg']")
    private List<WebElement> groupTypeIcon;
    @FindBy(xpath = "//input[@placeholder='Find group']")
    private WebElement searchField;
    @FindBy(xpath = "//div[contains(@class,'scrollbar-hidden')]/p")
    private List<WebElement> browseGroupList;
    @FindBy(xpath = "//button[text()='Leave' or text()='Join']")
    private List<WebElement> groupStatus;
    @FindBy(xpath = "//span[contains(@class,'text-sm font-semibold text-gray')]")
    private WebElement groupCount;
    @FindBy(xpath = "//div[@class='relative px-4']/div/ul/li/div//div[@class='font-sm ml-2 flex flex-col justify-center text-start']//p")
    public List<WebElement> membersRoleList;
    public static List<String> groupMembersList = new ArrayList<>();
    List<String> memberNameList = new ArrayList<>();
    List<String> selectedMemberNameList = new ArrayList<>();
    List<String> afterSelectingMemberNameList = new ArrayList<>();
//    List<String> beforeSelectingMemberNameList = new ArrayList<>();
    public String groupName;
    public String selectedGroupName;

    public void insideUserGroupsMenuSelectOption(String manageType) {
        try {
            webDriverHelper.waitUntilVisible(manageUsersGroupsTab, waitTime90Sec, pollingInterval1Sec);
            manageUsersGroupsTab.click();
            webDriverHelper.waitUntilVisibilityOfAllElements(manageBtn, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : manageBtn) {
                String elementName = element.getText();
                if (elementName.contains(manageType)) {
                    element.click();
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_insideUserGroupsMenuSelectOption.jpg");
            Assert.fail("Failed in the method insideUserGroupsMenuSelectOption due to exception :- " + exc);
        }
    }

    public void clickOnCreateBtn(String manageType) {
        try {
            webDriverHelper.waitUntilVisible(firstGroup, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisible(createBtn, waitTime90Sec, pollingInterval1Sec);
            String createBtnText = createBtn.getText();
            if (createBtnText.contains(manageType)) {
                webDriverHelper.waitUntilElementToBeClickable(createBtn, waitTime90Sec, pollingInterval1Sec);
                createBtn.click();
            }
            webDriverHelper.waitUntilVisible(createBtnHeaderTitle, waitTime90Sec, pollingInterval1Sec);
            String title = createBtnHeaderTitle.getText();
            Assert.assertEquals(title, "Create a " + manageType.toLowerCase(), "Failed to verify the title");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnCreateBtn.jpg");
            Assert.fail("Failed in the method clickOnCreateBtn due to exception :- " + exc);
        }
    }

    public void enterTheNameClickOnNext(String manageType) {
        try {
            webDriverHelper.waitUntilVisible(enterGroupName, waitTime90Sec, pollingInterval1Sec);
            groupName = manageType + "_Auto" + webDriverHelper.randomNumber();
            enterGroupName.sendKeys(groupName);
            webDriverHelper.waitUntilVisible(nextBtn, waitTime90Sec, pollingInterval1Sec);
            nextBtn.click();
            boolean toastDisplayed = true;
            while (toastDisplayed) {
                try {
                    webDriverHelper.waitUntilVisible(toastMsg, waitTime90Sec, pollingInterval1Sec);
                    String msg = toastMsg.getText();
                    Assert.assertEquals(msg, manageType + alreadyExitErrorMsg, "Failed to verify the msg displayed");
                    webDriverHelper.waitUntilVisible(enterGroupName, waitTime90Sec, pollingInterval1Sec);
                    groupName = manageType + "_Auto" + webDriverHelper.randomNumber();
                    enterGroupName.clear();
                    enterGroupName.sendKeys(groupName);
                    nextBtn.click();
                    webDriverHelper.waitUntilVisible(toastMsg, waitTime90Sec, pollingInterval1Sec);
                } catch (Exception exc) {
                    toastDisplayed = false;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_enterTheNameClickOnNext.jpg");
            Assert.fail("Failed in the method enterTheNameClickOnNext due to exception: " + exc.getMessage());
        }
    }

    public void addTheMembers() {
        try {
            activitiesPage.exceptionHandling(addPeopleTitle);
            webDriverHelper.waitUntilVisibilityOfAllElements(membersList, waitTime90Sec, pollingInterval1Sec);
            int selectedCount = 0;
            for (int i = 0; i < membersList.size(); i++) {
                String memberName = membersList.get(i).getText();
                if (!(memberNameList.contains(memberName)) && !(memberName.equals("NA")) && !(memberName.equals(PropertiesReader.applicationCreatedBy))) {
                    memberNameList.add(memberName);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", membersList.get(i));
//                    webDriverHelper.scrollToWebElement(membersList.get(i));
                    membersList.get(i).click();
                    selectedCount++;
                    if (selectedCount == 3) {
                        break;
                    }
                }
            }
            if (selectedCount != 3) {
                Assert.fail("Failed to add the members into the group");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_addTheMembers.jpg");
            Assert.fail("Failed in the method addTheMembers due to exception: " + exc.getMessage());
        }
    }

    public void verifyTheMembersDetailsThereCount() {
        try {
            System.out.println("memberNameList : "+memberNameList);
            if (memberNameList.size() != 0) {
                Thread.sleep(waitTime10000MillSec);
                for (WebElement element : selectedMembersList) {
                    String memberName = element.getText();
                    selectedMemberNameList.add(memberName);
                    System.out.println(selectedMemberNameList.size());
                }
                Assert.assertEquals(memberNameList, selectedMemberNameList, "Failed to verify the names in the selected list");
                webDriverHelper.waitUntilVisible(addMemberBtn, waitTime90Sec, pollingInterval1Sec);
                addMemberBtn.click();
            } else {
                webDriverHelper.waitUntilVisible(memberCount, waitTime90Sec, pollingInterval1Sec);
                memberCount.click();
            }
            afterSelectingMemberNameList.clear();
            Thread.sleep(waitTime5000MillSec);
            for (WebElement element : membersListAfterAddingMembers) {
                String memberName = element.getText();
                afterSelectingMemberNameList.add(memberName);
            }
            webDriverHelper.waitUntilVisible(memberCount, waitTime90Sec, pollingInterval1Sec);
            String memberCountText = memberCount.getText();
            int numbersOnly = Integer.parseInt(extractNumbers(memberCountText));
            Assert.assertEquals(numbersOnly, afterSelectingMemberNameList.size(), "Failed to verify the count and the displayed members");
            webDriverHelper.waitUntilVisible(cancelBtn, waitTime90Sec, pollingInterval1Sec);
            cancelBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheMembersDetailsThereCount.jpg");
            Assert.fail("Failed in the method verifyTheMembersDetailsThereCount due to exception: " + exc.getMessage());
        }
    }


    public void verifyTheCreateIsDisplayedInTheTable() {
        try {
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            searchBar.sendKeys(groupName);
            webDriverHelper.waitUntilVisible(createdBy, waitTime90Sec, pollingInterval1Sec);
            String createdName = createdBy.getText();
            Assert.assertTrue(createdName.contains(PropertiesReader.applicationCreatedBy), "Failed because the created name are not matching");
            webDriverHelper.waitUntilVisible(createdDate, waitTime90Sec, pollingInterval1Sec);
            String date = createdDate.getText();
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = currentDate.format(formatter);
            Assert.assertEquals(date, formattedDate, "Failed because the dates are not matching");
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheCreateIsDisplayedInTheTable.jpg");
            Assert.fail("Failed in the method verifyTheCreateIsDisplayedInTheTable due to exception: " + exc.getMessage());
        }
    }

    public void selectOnExistingEditDetailsBtn(String manageType, String button) {
        try {
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisible(firstGroup, waitTime90Sec, pollingInterval1Sec);
            searchBar.sendKeys(manageType + "_Auto");
            webDriverHelper.waitUntilVisible(firstGroup, waitTime90Sec, pollingInterval1Sec);
            Thread.sleep(waitTime5000MillSec);
            for (int i = 0; i < groupsList.size(); i++) {
                String groupName = groupsList.get(i).getText();
                if (groupName.contains((manageType + "_Auto").toLowerCase())) {
                    selectedGroupName = groupName;
                    activityMenuBtn.get(i).click();
                    WebElement element = driver.findElement(By.xpath("//button[text()='" + button + "']"));
                    element.click();
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectOnExistingEditDetailsBtn.jpg");
            Assert.fail("Failed in the method selectOnExistingEditDetailsBtn due to exception :- " + exc);

        }
    }

    public void verifyTheDetailsInTheTableAfterEditingName(String manageType) {
        try {
            webDriverHelper.waitUntilVisible(editGroupTitle, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisible(enterGroupName, waitTime90Sec, pollingInterval1Sec);
            groupName = manageType + "_Auto" + webDriverHelper.randomNumber();
            enterGroupName.clear();
            enterGroupName.sendKeys(groupName);
            saveBtn.click();
            webDriverHelper.waitUntilVisible(toastMsg, waitTime90Sec, pollingInterval1Sec);
            String msg = toastMsg.getText();
            Assert.assertEquals(msg, manageType + renamedMsg, "Failed to verify the msg displayed");
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            searchBar.sendKeys(groupName);
            for (WebElement webElement : groupsList) {
                String activitiesName = webElement.getText();
                if (activitiesName.equals(groupName)) {
                    break;
                } else {
                    Assert.fail("Failed to edit the group name");
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheDetailsInTheTableAfterName.jpg");
            Assert.fail("Failed in the method verifyTheDetailsInTheTableAfterName due to exception :- " + exc);
        }
    }

    public void clickOnAddBtnToAddMembers() {
        try {
            webDriverHelper.waitUntilVisible(addPeopleTitle, waitTime90Sec, pollingInterval1Sec);
            webDriverHelper.waitUntilVisibilityOfAllElements(membersListAfterAddingMembers, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : membersListAfterAddingMembers) {
                String memberName = element.getText();
                afterSelectingMemberNameList.add(memberName);
            }
            webDriverHelper.waitUntilVisible(addBtn, waitTime90Sec, pollingInterval1Sec);
            addBtn.click();
            Thread.sleep(waitTime5000MillSec);
            webDriverHelper.waitUntilVisibilityOfAllElements(membersList, waitTime90Sec, pollingInterval1Sec);
            memberNameList.clear();
            int selectedCount = 0;
            for (int i = 0; i < membersList.size(); i++) {
                String memberName = membersList.get(i).getText();
                if (!(memberNameList.contains(memberName)) && !(afterSelectingMemberNameList.contains(memberName)) && !(memberName.equals("NA"))) {
                    memberNameList.add(memberName);
//                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", membersRoleList.get(i));
//                    membersRoleList.get(i).click();
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", membersList.get(i));
                    membersList.get(i).click();
                    selectedCount++;
                    if (selectedCount == 3) {
                        break;
                    }
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnAddBtnToAddMembers.jpg");
            Assert.fail("Failed in the method clickOnAddBtnToAddMembers due to exception :- " + exc);
        }
    }


    public void verifyTheSuccessMessageTheDetailsInTable(String manageType) {
        try {
            webDriverHelper.waitUntilVisible(deactivateMsg, waitTime90Sec, pollingInterval1Sec);
            deactivateBtn.click();
            webDriverHelper.waitUntilVisible(toastMsg, waitTime90Sec, pollingInterval1Sec);
            String successMsg = toastMsg.getText();
            String msg = manageType + groupDeactivateMsg;
            Assert.assertEquals(successMsg, msg, "Failed to verify the toast msg");
            webDriverHelper.waitUntilVisible(searchBar, waitTime90Sec, pollingInterval1Sec);
            searchBar.clear();
            searchBar.sendKeys(selectedGroupName);
            Thread.sleep(waitTime5000MillSec);
            try {
                WebElement element = driver.findElement(By.xpath("//p[text()='" + selectedGroupName + "']"));
                if (element.isDisplayed()) {
                    Assert.fail("Failed because th group is still exit in the table");
                }
            } catch (Exception exc) {
                System.out.println("The group is successfully deactivated and removed from table");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheSuccessMessageTheDetailsInTable.jpg");
            Assert.fail("Failed in the method verifyTheSuccessMessageTheDetailsInTable due to exception :- " + exc);
        }
    }

    public void verifyCreateTitle(String manageType) {
        try {
            if (manageType.equals("Browse")) {
                webDriverHelper.waitUntilVisible(browseGroupTitle, waitTime60Sec, pollingInterval1Sec);
                String title = browseGroupTitle.getText();
                Assert.assertEquals(title, "All Groups", "Failed to verify the title");
            } else {
                webDriverHelper.waitUntilVisible(createBtnHeaderTitle, waitTime60Sec, pollingInterval1Sec);
                String title = createBtnHeaderTitle.getText();
                Assert.assertEquals(title, "Create a " + manageType.toLowerCase(), "Failed to verify the title");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_createANew.jpg");
            Assert.fail("Failed in the method createANew due to exception :- " + exc);
        }
    }

    public void clickOn(String menu) {
        try {
            Thread.sleep(waitTime5000MillSec);
            WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + menu + "')]"));
            activitiesPage.exceptionHandling(element);
            element.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickOnAddGroups.jpg");
            Assert.fail("Failed in the method clickOnAddGroups due to exception :- " + exc);
        }
    }

    public void selectAnCreateGroup() {
        try {
            webDriverHelper.waitUntilVisibilityOfAllElements(groupTypeList, waitTime60Sec, pollingInterval1Sec);
            for (WebElement element : groupTypeList) {
                String elementName = element.getText();
                if (elementName.contains("Create")) {
                    element.click();
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectAnCreateGroup.jpg");
            Assert.fail("Failed in the method selectAnCreateGroup due to exception :- " + exc);
        }
    }


    public void addTheMembersIntoTheGroupAndVerifyTheSuccessMsg() {
        try {
            activitiesPage.exceptionHandling(addPeopleTitle);
            Thread.sleep(waitTime5000MillSec);
            int selectedCount = 0;
            for (int i = 0; i < membersNameList.size(); i++) {
                String memberName = membersNameList.get(i).getText();
                System.out.println(memberName);
                if (!(groupMembersList.contains(memberName)) && !(memberName.equalsIgnoreCase("NA"))) {
                    groupMembersList.add(memberName);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addMembersBtnList.get(i));
                    addMembersBtnList.get(i).click();
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
                    WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/div[@class=' cursor-default text-black']")));
                    String msg = toastMsg.getText();
                    Assert.assertEquals(msg, "User Added Successfully", "Failed to add the user in to the group");
                    selectedCount++;
                    if (selectedCount == 3) {
                        break;
                    }
                }
            }
            webDriverHelper.waitUntilVisible(createGroupTabCloseBtn, waitTime60Sec, pollingInterval1Sec);
            createGroupTabCloseBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_addTheMembersIntoTheGroupAndVerifyTheSuccessMsg.jpg");
            Assert.fail("Failed in the method addTheMembersIntoTheGroupAndVerifyTheSuccessMsg due to exception :- " + exc);
        }
    }

    public void verifyTheCreated() {
        try {
            webDriverHelper.waitUntilVisible(groupsBtn, waitTime60Sec, pollingInterval1Sec);
            groupsBtn.click();
            Thread.sleep(waitTime5000MillSec);
            boolean falg = false;
            for (WebElement element : groupList) {
                String elementName = element.getText();
                if (elementName.equals(groupName)) {
                    falg = true;
                    break;
                }
            }
            if (falg) {
                Assert.fail("Failed to verify the group " + groupName + " in the list");
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheCreated.jpg");
            Assert.fail("Failed in the method verifyTheCreated due to exception :- " + exc);
        }
    }

    public void selectAnBrowseGroup() {
        try {
            webDriverHelper.waitUntilVisibilityOfAllElements(groupTypeList, waitTime60Sec, pollingInterval1Sec);
            for (WebElement element : groupTypeList) {
                String elementName = element.getText();
                if (elementName.contains("Browse")) {
                    element.click();
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_selectAnBrowseGroup.jpg");
            Assert.fail("Failed in the method selectAnBrowseGroup due to exception :- " + exc);
        }
    }

    public void verifyTheGroup(String value) {
        try {
            webDriverHelper.waitUntilVisible(searchField, waitTime60Sec, pollingInterval1Sec);
            searchField.clear();
            searchField.sendKeys(value);
            webDriverHelper.waitUntilVisibilityOfAllElements(browseGroupList, waitTime90Sec, pollingInterval1Sec);
            for (WebElement element : browseGroupList) {
                String groupName = element.getText();
                if (groupName.contains(value)) {
                    webDriverHelper.waitUntilVisibilityOfAllElements(groupStatus, waitTime90Sec, pollingInterval1Sec);
                    for (WebElement element1 : groupStatus) {
                        String element1Name = element1.getText();
                        if (element1Name.equals("Join")) {
                            element1.click();
                            break;
                        }
                    }
                    break;
                }
            }
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_verifyTheGroup.jpg");
            Assert.fail("Failed in the method verifyTheGroup due to exception :- " + exc);
        }
    }

    public void browseTheGroupAndVerifyTheDetails() {
        try {
            webDriverHelper.waitUntilVisibilityOfAllElements(groupType, waitTime60Sec, pollingInterval1Sec);
            for (int i = 0; i < groupType.size(); i++) {
                String groupTypeName = groupType.get(i).getText();
                groupType.get(i).click();
                webDriverHelper.waitUntilVisible(groupCount, waitTime60Sec, pollingInterval1Sec);
                String count = groupCount.getText();
                StringBuilder digits = new StringBuilder();
                for (char c : count.toCharArray()) {
                    if (Character.isDigit(c)) {
                        digits.append(c);
                    }
                }
                int number = Integer.parseInt(digits.toString());
                webDriverHelper.waitUntilVisibilityOfAllElements(browseGroupList, waitTime60Sec, pollingInterval1Sec);
                int listCount = browseGroupList.size();
                Assert.assertEquals(number, listCount, "Failed to verify the count displayed and the list count");
                String value;
                switch (groupTypeName) {
                    case "Public":
                        groupTypeIcon.get(i).getAttribute("stroke");
                        value = "";
                        System.out.println("value " + value);
                        verifyTheGroup(value);
                        groupType.get(i).click();
                        break;
                    case "Private":
                        groupTypeIcon.get(i).getAttribute("class");
                        value = "";
                        System.out.println("value " + value);
                        verifyTheGroup(value);
                        groupType.get(i).click();
                        break;
                    case "All":
                        for (int j = 0; j < 2; j++) {
                            String value1;
                            if (j == 0) {
                                value1 = "Auto";
                            } else {
                                value1 = "general";
                            }
                            verifyTheGroup(value1);
                        }
                        break;
                }
            }
            webDriverHelper.waitUntilVisible(createGroupTabCloseBtn, waitTime60Sec, pollingInterval1Sec);
            createGroupTabCloseBtn.click();
        } catch (Exception exc) {
            webDriverHelper.takeAScreenShot("_clickTheGroupTypeAndIcon.jpg");
            Assert.fail("Failed in the method clickTheGroupTypeAndIcon due to exception :- " + exc);
        }
    }
}

package com.drb.script;
import org.testng.annotations.Test;
import com.drb.pages.DrbCreateProfile;
import com.drb.pages.DrbDeleteProfile;
import com.drb.pages.DrbDownload;
import com.drb.pages.DrbEditProfile;
import com.drb.pages.DrbLogin;
import com.drb.pages.DrbLogout;
import com.drb.pages.DrbSignUp;
import com.drb.utilities.ExcelUtilities;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class DrbTest extends DrbBase{
	 DrbLogin dlin;
	 DrbSignUp dsignup;
	 DrbCreateProfile dcrtprf;
	 DrbEditProfile dedtprf;

  @Test(priority=2)
//VALID LOGIN
  public void validlogin() throws IOException, InterruptedException     
  {   
	  String userName=ExcelUtilities.getcelldata(0, 0, 1);
	  String pass=ExcelUtilities.getcelldata(0, 1, 1);
	  dlin=new DrbLogin(driver);
	  dlin.clickSignUp();
	  dlin.setUserName(userName);
	  dlin.setPassword(pass);
	  dlin.clickRememberMe();
	  dlin.loginClick();
	  Thread.sleep(500);
	  String title="http://167.71.226.96/";
	  String actualTitle=driver.getCurrentUrl();
	  System.out.println(actualTitle);
	  Assert.assertEquals(actualTitle, title);	  
  }
  
  @Test
  //INVALID LOGIN
  public void inValidlogin1() throws IOException, InterruptedException      
  {
	  String userName=ExcelUtilities.getcelldata(0, 0, 2);
	  String pass=ExcelUtilities.getcelldata(0, 1, 2);
	  dlin=new DrbLogin(driver);
	  dlin.clickSignUp();
	  dlin.setUserName(userName);
	  dlin.setPassword(pass);
	  dlin.clickRememberMe();
	  dlin.loginClick();
	  WebElement loginButton =driver.findElement(By.className("login100-form-btn"));
	  boolean actual=loginButton.isSelected();
	  System.out.println(actual);
	  Assert.assertFalse(actual);
  }
  
  @Test
  //VALID SIGNUP 
  public  void validSignUp() throws IOException, InterruptedException
  {	  String username=ExcelUtilities.getcelldata(1, 0, 1);
  	  String phone=ExcelUtilities.getcelldata(1, 1, 1);
  	  String email=ExcelUtilities.getcelldata(1, 2, 1);
  	  String pass=ExcelUtilities.getcelldata(1, 3, 1);
  	  String cpass=ExcelUtilities.getcelldata(1, 4, 1);
	  dsignup=new DrbSignUp(driver);
	  driver.navigate().to("http://167.71.226.96/signup");
	  dsignup.setUserName(username);
	  dsignup.setPhoneNumber(phone);
	  dsignup.setMailId(email);
	  dsignup.setPassword(pass);
	  dsignup.setConfirmPassword(cpass);
	  dsignup.clickRegister();
	  String expected="New user added";
	  String actual=driver.switchTo().alert().getText();
	  Assert.assertEquals(actual, expected);
	  driver.switchTo().alert().accept();
	 
  }
  
  @Test
  //INVALID SIGNUP
  public  void invalidSignUp() throws IOException, InterruptedException
  {	  String username=ExcelUtilities.getcelldata(1, 0, 2);
  	  String phone=ExcelUtilities.getcelldata(1, 1, 2);
  	  String email=ExcelUtilities.getcelldata(1, 2, 2);
  	  String pass=ExcelUtilities.getcelldata(1, 3, 2);
  	  String cpass=ExcelUtilities.getcelldata(1, 4, 2);
  	  dsignup=new DrbSignUp(driver);
  	  driver.navigate().to("http://167.71.226.96/signup");
  	  dsignup.setUserName(username);
  	  dsignup.setPhoneNumber(phone);
  	  dsignup.setMailId(email);
  	  dsignup.setPassword(pass);
  	  dsignup.setConfirmPassword(cpass);
  	  dsignup.clickRegister();
  	  
  	  WebElement registerButton=driver.findElement(By.cssSelector("body > app-root > app-signup > div > div > form > button > span"));
  		
  	  boolean actual=registerButton.isSelected();
  	  System.out.println(actual);
  	  Assert.assertFalse(actual);
  	  Thread.sleep(1000);  
  }
  
  @Test(priority=1)
  //INVALID SIGNUP WITH EXISTING USERNAME
  public  void inValidSignUpWithExisting() throws IOException, InterruptedException
  {	  validSignUp();
  	  String username=ExcelUtilities.getcelldata(1, 0, 1);
	  String phone=ExcelUtilities.getcelldata(1, 1, 1);
	  String email=ExcelUtilities.getcelldata(1, 2, 1);
	  String pass=ExcelUtilities.getcelldata(1, 3, 1);
	  String cpass=ExcelUtilities.getcelldata(1, 4, 1);
	  dsignup=new DrbSignUp(driver);
	 // dsignup.clickSignUp();
	 // dsignup.clickSignupLink();
	  driver.navigate().to("http://167.71.226.96/signup");
	  dsignup.setUserName(username);
	  dsignup.setPhoneNumber(phone);
	  dsignup.setMailId(email);
	  dsignup.setPassword(pass);
	  dsignup.setConfirmPassword(cpass);
	  dsignup.clickRegister();
	  String expected="User already Exists";
	  String actual=driver.switchTo().alert().getText();
	  Assert.assertEquals(actual, expected);
	  driver.switchTo().alert().accept();
	 
  }
  
  @Test(priority=3)
  //VALID CREATE PROFILE WITH MANDATORY FIELDS
  public void validCreateProfile() throws IOException, InterruptedException
  {
	  
  	  String name=ExcelUtilities.getcelldata(2, 1, 1);
  	  String dob=ExcelUtilities.getcelldata(2, 2, 1);
  	  String gender=ExcelUtilities.getcelldata(2, 3, 1);
  	  String email=ExcelUtilities.getcelldata(2, 4, 1);
  	  String phone=ExcelUtilities.getcelldata(2, 5, 1);
  	  String schoolstrm=ExcelUtilities.getcelldata(2, 6, 1);
  	  String percentage=ExcelUtilities.getcelldata(2, 7, 1);
  	  String school=ExcelUtilities.getcelldata(2, 8, 1);
   	  String year=ExcelUtilities.getcelldata(2, 9, 1);
   	  String skills=ExcelUtilities.getcelldata(2, 10, 1);
   	  String lang=ExcelUtilities.getcelldata(2, 11, 1);
   	  String describe=ExcelUtilities.getcelldata(2, 12, 1);
   	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata(2, 13, 1);
   	  
   	  dcrtprf=new DrbCreateProfile(driver);
   	  
   	  validlogin();
   	  
   	  dcrtprf.clickMyProfile();
   	  dcrtprf.clickCrtProfile();
   	  dcrtprf.setName(name);
   	  dcrtprf.setDob(dob);
   	  dcrtprf.clickGender(gender);
   	  dcrtprf.setEmail(email);
   	  dcrtprf.setPhone(phone);
   	  dcrtprf.setSchoolStream(schoolstrm);
   	  dcrtprf.setPercent(percentage);
   	  dcrtprf.setSchool(school);
   	  dcrtprf.setYear(year);
   	  dcrtprf.setSkills(skills);
   	  dcrtprf.setLanguage(lang);
   	  dcrtprf.setDescribe(describe);
   	  dcrtprf.setImage(img);
   	  dcrtprf.acceptCheck();
   	  dcrtprf.clickCreateProfile();
  
}
  
  @Test(priority=5)
  //LOGOUT 
  public void logOut() throws IOException, InterruptedException
  {
	  validlogin();
	  DrbLogout dlout=new DrbLogout(driver);
	  Thread.sleep(1000);
	  dlout.clickLogout();
	   }
  
  @Test(priority=7)
 //DELETE PROFILE
  public void deleteProfile() throws IOException, InterruptedException
  {
	  validlogin();
	  DrbDeleteProfile drbdlt=new DrbDeleteProfile(driver);
	  drbdlt.deleteProfile();
	 
	  
  }

  @Test(priority=6)
 //DOWNLOAD TEMPLATE 1
  public void downloadTemplate1() throws IOException, InterruptedException
  {
	  validlogin();
	  DrbDownload  drbdwnld =new DrbDownload(driver);
	  drbdwnld.clickTemplateBtn();
	  Thread.sleep(500);
	  drbdwnld.clickTemplate("#web-development > div > div > div:nth-child(2) > div:nth-child(1) > a > figure > figcaption");
	  Thread.sleep(1000);
	  drbdwnld.clickDownloadResume("body > app-root > app-threetemp > section > button.btn.btn.btn-dark.m-1");
  }
  
  
  @Test
  //DOWNLOAD TEMPLATE 2
  public void downloadTemplate2() throws IOException, InterruptedException
  {
	  validlogin();
	  DrbDownload  drbdwnld =new DrbDownload(driver);
	  drbdwnld.clickTemplateBtn();
	  Thread.sleep(500);
	  drbdwnld.clickTemplate("#web-development > div > div > div:nth-child(2) > div.cc-porfolio-image.img-raised.aos-init.aos-animate > a > figure > figcaption");
	  Thread.sleep(1000);
	  drbdwnld.clickDownloadResume("body > app-root > app-threetemp > section > button.btn.btn.btn-dark.m-1");
  }
  
  @Test
  //DOWNLOAD TEMPLATE 3
  public void downloadTemplate3() throws IOException, InterruptedException
  {
	  validlogin();
	  DrbDownload  drbdwnld =new DrbDownload(driver);
	  drbdwnld.clickTemplateBtn();
	  Thread.sleep(500);
	  drbdwnld.clickTemplate("#web-development > div > div > div:nth-child(1) > div:nth-child(2) > a > figure > figcaption");
	  Thread.sleep(1000);
	  drbdwnld.clickDownloadResume("body > app-root > app-twotemp > section > button.btn.btn.btn-dark.m-1");
  }

  
    @Test(priority=4)
    //EDIT PROFILE WITH VALID MANDATORY FIELDS
    public void validEditProfile() throws IOException, InterruptedException
  { 
  	  String name=ExcelUtilities.getcelldata(3, 1, 1);
  	  String dob=ExcelUtilities.getcelldata(3, 2, 1);
  	  String gender=ExcelUtilities.getcelldata(3, 3, 1);
  	  String email=ExcelUtilities.getcelldata(3, 4, 1);
  	  String phone=ExcelUtilities.getcelldata(3, 5, 1);
  	  String schoolstrm=ExcelUtilities.getcelldata(3, 6, 1);
  	  String percentage=ExcelUtilities.getcelldata(3, 7, 1);
  	  String school=ExcelUtilities.getcelldata(3, 8, 1);
   	  String year=ExcelUtilities.getcelldata(3, 9, 1);
   	  String skills=ExcelUtilities.getcelldata(3, 10, 1);
   	  String lang=ExcelUtilities.getcelldata(3, 11, 1);
   	  String describe=ExcelUtilities.getcelldata(3, 12, 1);
   	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata(3, 13, 1);
   	  
   	  dedtprf=new DrbEditProfile(driver);
   	  
   	  validlogin();
   	  
   	  dedtprf.clickMyProfile();
   	  dedtprf.clickEditProfilebtn();
   	  dedtprf.setName(name);
   	  dedtprf.setDob(dob);
   	  dedtprf.clickGender(gender);
   	  dedtprf.setEmail(email);
   	  dedtprf.setPhone(phone);
   	  dedtprf.setSchoolStream(schoolstrm);
   	  dedtprf.setPercent(percentage);
   	  dedtprf.setSchool(school);
   	  dedtprf.setYear(year);
   	  dedtprf.setSkills(skills);
   	  dedtprf.setLanguage(lang);
   	  dedtprf.setDescribe(describe);
   	  dedtprf.setImage(img);
   	  dedtprf.acceptCheck();
   	  dedtprf.clickUpdateProfile();
   	
}
   

@Test
//CREATE PROFILE WITH VALID DATA - ALL FIELDS
public void validAllCreateProfile() throws IOException, InterruptedException
{
	  
	  String name=ExcelUtilities.getcelldata(2, 16, 1);
	  String dob=ExcelUtilities.getcelldata(2, 17, 1);
	  String gender=ExcelUtilities.getcelldata(2, 18, 1);
	  String email=ExcelUtilities.getcelldata(2, 19, 1);
	  String phone=ExcelUtilities.getcelldata(2, 20, 1);
	  String schoolstrm=ExcelUtilities.getcelldata(2, 21, 1);
	  String percentage=ExcelUtilities.getcelldata(2, 22, 1);
	  String school=ExcelUtilities.getcelldata(2, 23, 1);
 	  String year=ExcelUtilities.getcelldata(2, 24, 1);
 	  String higersec=ExcelUtilities.getcelldata(2, 25, 1);
 	  String higersecPercentage=ExcelUtilities.getcelldata(2, 26, 1);
 	  String higersecSchool=ExcelUtilities.getcelldata(2, 27, 1);
 	  String higersecYear=ExcelUtilities.getcelldata(2, 28, 1);
 	  String graduation=ExcelUtilities.getcelldata(2, 29, 1);
 	  String gradStream=ExcelUtilities.getcelldata(2, 30, 1);
 	  String gradPercentage=ExcelUtilities.getcelldata(2, 31, 1);
 	  String gradInstitute=ExcelUtilities.getcelldata(2, 32, 1);
 	  String gradYear=ExcelUtilities.getcelldata(2, 33, 1);
 	  String project=ExcelUtilities.getcelldata(2, 39, 1);
 	  String projectDesc=ExcelUtilities.getcelldata(2, 40, 1);
 	  String skills=ExcelUtilities.getcelldata(2, 47, 1);
 	  String lang=ExcelUtilities.getcelldata(2, 48, 1);
 	  String  achievements=ExcelUtilities.getcelldata(2, 50, 1);
 	  String describe=ExcelUtilities.getcelldata(2, 51, 1);
 	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata(2, 52, 1);
 	  
 	  dcrtprf=new DrbCreateProfile(driver);
 	  
 	  validlogin();
 	  
 	  dcrtprf.clickMyProfile();
 	  dcrtprf.clickCrtProfile();
 	  dcrtprf.setName(name);
 	  dcrtprf.setDob(dob);
 	  dcrtprf.clickGender(gender);
 	  dcrtprf.setEmail(email);
 	  dcrtprf.setPhone(phone);
 	  dcrtprf.setSchoolStream(schoolstrm);
 	  dcrtprf.setPercent(percentage);
 	  dcrtprf.setSchool(school);
 	  dcrtprf.setYear(year);
 	  dcrtprf.higherSecondaryStream(higersec);
 	  dcrtprf.setHighersecPercentage(higersecPercentage);
      dcrtprf.setHighersecSchool(higersecSchool);
 	  dcrtprf.setHighersecYear(higersecYear);
 	  dcrtprf.setGraduation(graduation);
 	  dcrtprf.setGraduationStream(gradStream);
	  dcrtprf.setGraduationPercentage(gradPercentage);
	  dcrtprf.setGraduationInstitute(gradInstitute);
	  dcrtprf.setGraduationYear(gradYear);
	  dcrtprf.setProjectDetails(project,projectDesc);
	  dcrtprf.setSkills(skills);
 	  dcrtprf.setLanguage(lang);
 	  dcrtprf.setAchievements(achievements);
 	  dcrtprf.setDescribe(describe);
 	  dcrtprf.setImage(img);
 	  dcrtprf.acceptCheck();
 	  dcrtprf.clickCreateProfile();
 	 
}


//INVALID EDITPROFILE - MANDATORY FIELDS
@Test
public void invalidEditProfile() throws IOException, InterruptedException
{
	  
	  String name=ExcelUtilities.getcelldata(3, 1, 2);                
	  String dob=ExcelUtilities.getcelldata(3, 2, 2);
	  String gender=ExcelUtilities.getcelldata(3, 3, 2);
	  String email=ExcelUtilities.getcelldata(3, 4, 2);
	  String phone=ExcelUtilities.getcelldata(3, 5, 2);
	  String schoolstrm=ExcelUtilities.getcelldata(3, 6, 2);
	  String percentage=ExcelUtilities.getcelldata(3, 7, 2);
	  String school=ExcelUtilities.getcelldata(3, 8, 2);
 	  String year=ExcelUtilities.getcelldata(3, 9, 2);
 	  String skills=ExcelUtilities.getcelldata(3, 10, 2);
 	  String lang=ExcelUtilities.getcelldata(3, 11, 2);
 	  String describe=ExcelUtilities.getcelldata(3, 12, 2);
 	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata(3, 13, 2);
 	  dedtprf=new DrbEditProfile(driver);

 	  validlogin();

 	 dedtprf.clickMyProfile();
  	  dedtprf.clickEditProfilebtn();
 	   dedtprf.setName(name);
 	  dedtprf.setDob(dob);
 	  dedtprf.clickGender(gender);
 	  dedtprf.setEmail(email);
 	  dedtprf.setPhone(phone);
 	  dedtprf.setSchoolStream(schoolstrm);
 	  dedtprf.setPercent(percentage);
 	  dedtprf.setSchool(school);
 	  dedtprf.setYear(year);
 	  dedtprf.setSkills(skills);
 	  dedtprf.setLanguage(lang);
 	  dedtprf.setDescribe(describe);
 	  dedtprf.setImage(img);
 	  dedtprf.acceptCheck();
      dedtprf.clickUpdateProfile();	

	  String expected ="Enter valid data";
	  String actual =driver.switchTo().alert().getText();
	  Assert.assertEquals(actual,expected);
		driver.switchTo().alert().accept();
 
	  Thread.sleep(1000);         
}


@Test
//EDIT PROFILE WITH ALL VALID FIELDS
public void validAllEditProfile() throws IOException, InterruptedException
{
	  
	  String name=ExcelUtilities.getcelldata(3, 16, 1);
	  String dob=ExcelUtilities.getcelldata(3, 17, 1);
	  String gender=ExcelUtilities.getcelldata(3, 18, 1);
	  String email=ExcelUtilities.getcelldata(3, 19, 1);
	  String phone=ExcelUtilities.getcelldata(3, 20, 1);
	  String schoolstrm=ExcelUtilities.getcelldata(3, 21, 1);
	  String percentage=ExcelUtilities.getcelldata(3, 22, 1);
	  String school=ExcelUtilities.getcelldata(3, 23, 1);
	  String year=ExcelUtilities.getcelldata(3, 24, 1);
	  String higersec=ExcelUtilities.getcelldata(3, 25, 1);
	  String higersecPercentage=ExcelUtilities.getcelldata(3, 26, 1);
	  String higersecSchool=ExcelUtilities.getcelldata(3, 27, 1);
	  String higersecYear=ExcelUtilities.getcelldata(3, 28, 1);
	  String graduation=ExcelUtilities.getcelldata(3, 29, 1);
	  String gradStream=ExcelUtilities.getcelldata(3, 30, 1);
	  String gradPercentage=ExcelUtilities.getcelldata(3, 31, 1);
	  String gradInstitute=ExcelUtilities.getcelldata(3, 32, 1);
	  String gradYear=ExcelUtilities.getcelldata(3, 33, 1);
	  String project=ExcelUtilities.getcelldata(3, 39, 1);
	  String projectDesc=ExcelUtilities.getcelldata(3, 40, 1);
	  String skills=ExcelUtilities.getcelldata(3, 47, 1);
	  String lang=ExcelUtilities.getcelldata(3, 48, 1);
	  String  achievements=ExcelUtilities.getcelldata(3, 50, 1);
	  String describe=ExcelUtilities.getcelldata(3, 51, 1);
	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata(3, 52, 1);

	  dedtprf=new DrbEditProfile(driver);

	  validlogin();
	  dedtprf.clickMyProfile();
	  dedtprf.clickEditProfilebtn();
	  dedtprf.setName(name);
	  dedtprf.setDob(dob);
	  dedtprf.clickGender(gender);
	  dedtprf.setEmail(email);
	  dedtprf.setPhone(phone);
	  dedtprf.setSchoolStream(schoolstrm);
	  dedtprf.setPercent(percentage);
	  dedtprf.setSchool(school);
	  dedtprf.setYear(year);
	  dedtprf.higherSecondaryStream(higersec);
	  dedtprf.setHighersecPercentage(higersecPercentage);
      dedtprf.setHighersecSchool(higersecSchool);
	  dedtprf.setHighersecYear(higersecYear);
	  dedtprf.setGraduation(graduation);
	  dedtprf.setGraduationStream(gradStream);
	  dedtprf.setGraduationPercentage(gradPercentage);
	  dedtprf.setGraduationInstitute(gradInstitute);
	  dedtprf.setGraduationYear(gradYear);
	  dedtprf.setProjectDetails(project,projectDesc);	  
	  dedtprf.setSkills(skills);
	  dedtprf.setLanguage(lang);
	  dedtprf.setAchievements(achievements);
	  dedtprf.setDescribe(describe);
	  dedtprf.setImage(img);
	  dedtprf.acceptCheck();
	  dedtprf.clickUpdateProfile();
	
	  Thread.sleep(1000);
}




}

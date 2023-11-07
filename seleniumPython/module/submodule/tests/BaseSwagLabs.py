
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import pytest
import time
import pandas, os
from pathlib import Path


class BaseSwagLabs:

	def __init__(self, driverReceived: webdriver.Chrome) -> None:
		self.driver : webdriver.Chrome = driverReceived
		self.useName: webdriver.Chrome._web_element_cls = None
		self.passwordThrown: webdriver.Chrome._web_element_cls = None
		self.login: webdriver.Chrome._web_element_cls = None
		self.errorLogin: webdriver.Chrome._web_element_cls = None
		self.loginErrorText: str = None
		self.burgerMenu: webdriver.Chrome._web_element_cls = None
		self.logout: webdriver.Chrome._web_element_cls = None
		self.pageTitle: str = None
		self.userNameSet: str = None
		self.passwordSet: str = None

        
	def visitPage(self) -> None:
		self.driver.get("https://www.saucedemo.com/")
		time.sleep(5)

	def maximizeWindow(self) -> None:
		self.driver.maximize_window()
    
    
	def sauceDemoTestDriverInitializer(self) -> None:
		self.useName = WebDriverWait(self.driver, 5, .5).until(EC.presence_of_element_located( (By.XPATH, "//input[@id = 'user-name']" ) ))
		self.passwordThrown = WebDriverWait(self.driver, 5, .5).until(EC.presence_of_element_located( (By.XPATH, "//input[@id = 'password']" ) ))
		self.login = WebDriverWait(self.driver, 5, .5).until(EC.presence_of_element_located( (By.XPATH, "//input[@id = 'login-button']" ) ))
		
		
	def enterCredsAndLogin(self, userNameDataProvided, passwordDataProvided) -> None:
     
		print("Usernames: ",userNameDataProvided, " and Passwords: ", passwordDataProvided)
		self.userNameSet = userNameDataProvided
		self.passwordSet = passwordDataProvided
		time.sleep(1)
		self.useName.send_keys(self.userNameSet)
		self.passwordThrown.send_keys(self.passwordSet)
		self.login.click()
		
  
	def checkInvalidUser(self) -> str:
		if self.userNameSet == "locked_out_user":
			self.errorLogin = WebDriverWait(self.driver, 5, .5).until(EC.presence_of_element_located( (By.XPATH, "//h3[@data-test = 'error']" ) ))
			self.loginErrorText = self.errorLogin.text
	
		return self.loginErrorText

	
	
	def logsAndFetchTitle(self) -> str :
        
    # 	//Inside the web page and logging out
	
		self.pageTitle = self.driver.title
		self.burgerMenu = WebDriverWait(self.driver, 5, .5).until(EC.presence_of_element_located( (By.XPATH, "//button[contains(@id, 'menu')]" ) ))
		time.sleep(1.2)
		self.burgerMenu.click()		
		time.sleep(1)
		self.logout = WebDriverWait(self.driver, 5, .5).until(EC.presence_of_element_located( (By.XPATH, "//a[contains(@id, 'logout')]" ) ))
		self.logout.click()   
	
		return self.pageTitle
    
    
	def quitSession(self) -> None:
		self.driver.quit()
        
        
        
	
        
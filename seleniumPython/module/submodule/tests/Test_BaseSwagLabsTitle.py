import os
os.path.abspath(os.path.join('/virtusaPython/module/submodule', os.pardir))

from .BaseSwagLabs import BaseSwagLabs
from selenium import webdriver
import pytest
import time, pandas
from pathlib import Path



class DataFinder:
    
    def dataOutside(self):
        print(Path.cwd())
        # print(os.path.join(os.getcwd(), "../../../sauceDemo.xlsx"))
        loca = Path(os.path.join(os.getcwd(), "./../../../sauceDemo copy.xlsx")).resolve()
        print(loca)
        fg = pandas.read_excel(loca, sheet_name="Credentials")   
        tup = fg.values.tolist()    
        print(tup)
        return tup




class Test_BaseSwagLabsTitle():

  
    @pytest.fixture(scope="module")
    def prerequiteLogoFetch(self):
        w3SchoolsSeleniumI = BaseSwagLabs(webdriver.Chrome())
        return w3SchoolsSeleniumI
 
        
         
    @pytest.mark.parametrize('value', DataFinder().dataOutside())
    def test_logoPresence(self, value, prerequiteLogoFetch):
        
        prerequiteLogoFetch.visitPage()
        prerequiteLogoFetch.maximizeWindow()
        prerequiteLogoFetch.sauceDemoTestDriverInitializer()
        prerequiteLogoFetch.enterCredsAndLogin(value[0], value[1])
           
        errorText = prerequiteLogoFetch.checkInvalidUser()
        if value[0] == "locked_out_user":
             assert errorText=="Epic sadface: Sorry, this user has been locked out."
             
        else:
            titlePage = prerequiteLogoFetch.logsAndFetchTitle()
            assert titlePage=="Swag Labs"
        
        
    @pytest.fixture(scope="session")
    def quitBrowser(self,prerequiteLogoFetch):
       {
           prerequiteLogoFetch.quitSession()
       }     
       
       


    


        





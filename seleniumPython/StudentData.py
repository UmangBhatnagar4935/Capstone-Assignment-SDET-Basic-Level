from selenium import webdriver
from selenium.webdriver.common.by import *


class Student:
    def __init__(mySelf, nameReceived:str, gradeReceived:int, ageReceived:int) -> None:
        mySelf.name:str = nameReceived
        mySelf.grade:int = gradeReceived
        mySelf.age:int = ageReceived
      

    def display(mySelf):
        print("The student with name: {name}, in grade: {grade} with age: {age} is looking for good school nearby !!"
              .format(name = mySelf.name,
                    grade = mySelf.grade,
                    age = mySelf.age))
        
        


        
student1:Student = Student("Umang Bhatnagar", 5, 18)

if(__name__ == '__main__'):
    student1.display()        




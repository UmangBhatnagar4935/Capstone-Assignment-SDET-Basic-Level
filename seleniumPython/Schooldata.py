from StudentData import Student

class School(Student):


    def __init__(mySelf, nameReceivedSchool: str, gradeReceivedSchool: int, ageReceivedSchool: int) -> None:

        super().__init__(nameReceivedSchool, gradeReceivedSchool, ageReceivedSchool)
        


    def SchoolStudentDisplay(mySelf) -> None:
          print(""" Maryland School of Aeronautical Sciences confirms the admission of child: {name},
                  in grade: {grade} with his/her age: {age}  
              """.format(name = mySelf.age,
                         age = mySelf.age,
                         grade = mySelf.grade))
        

      




school:School = School("Linda Vista", 12, 22)
school.SchoolStudentDisplay()
        



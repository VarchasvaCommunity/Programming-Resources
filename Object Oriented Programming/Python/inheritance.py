class Employee:
    company="google"
    def getSalary(self):
        print("salary is 100k")

    @staticmethod    
    def greet():
        print("good morning")  

    def __init__(self):  # runs automatically without calling
        print("emoloyee is created")   

pablo=Employee()

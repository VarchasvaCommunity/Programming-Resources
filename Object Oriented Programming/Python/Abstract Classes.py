Abstract Classes
 
Abstraction is the process of hiding implementation details and only revealing the parts of information which are relevant to the user i.e. it is basically, hiding the unnecessary details from the users. An abstract class can be considered as a blueprint for other classes that it can follow. Abstract classes are those type of classes that can contain one or more abstract methods. Here, an abstract method is a method that has a declaration but does not have an implementation (which is left for the inherited class to implement in its own form/fashion). This set of methods must be created within any child classes which inherit from the abstract class. A class that contains one or more abstract methods is called an abstract class.
 
Creating Abstract Classes in Python

 
● By default, Python does not provide abstract classes.
 
● Python comes with a module that provides the base for defining Abstract Base classes(ABC) and that module name is abc.
 
● abc works by decorating methods of the base class as abstract and then registering concrete classes as implementations of the abstract base.
 
● A method becomes abstract when decorated with the keyword @abstractmethod.
 
● You are required to import ABC superclass and abstractmethod from the abc module before declaring your abstract class.
 
● An abstract class cannot be directly instantiated i.e. we cannot create an object of the abstract class.
 
● However, the subclasses of an abstract class that have definitions for all the abstract methods declared in the abstract class, can be instantiated.
 
● While declaring abstract methods in the class, it is not mandatory to use the @abstractmethod decorator (i.e it would not throw an exception). However, it is considered a good practice to use it as it notifies the compiler that the user has defined an abstract method.

The given Python code uses the ABC class and defines an abstract base class:
 
from abc import ABC, abstractmethod #Importing the ABC Module

class AbstractClass(ABC):
    def __init__(self, value): #Class Constructor
        self.value = value
        pass
    
    @abstractmethod
    def do_something(self): #Our abstract method declaration
        pass
 
● You are required to define (implement) all the abstract methods declared in an Abstract class, in all its subclasses to be able to instantiate the subclass.
 
For example, We will now define a subclass using the previously defined abstract class. You will notice that since we haven't implemented the do_something method, in this subclass, we will get an exception.
 
class TestClass(AbstractClass):
   pass #No definition for do_something method 

x = TestClass(4)

We will get the output as:
 
TypeError: Can't instantiate abstract class TestClass with abstract methods do_something
 
We will do it the correct way in the following example, in which we define two classes inheriting from our abstract class:
 
class add(AbstractClass):
    def do_something(self):
        return self.value + 42
    

class mul(AbstractClass):
    def do_something(self):
        return self.value * 42


#Driver's code
x = add(10)
y = mul(10)
print(x.do_something())
print(y.do_something())
 
We get the output as:
 
52 
420

Thus, we can observe that a class that is derived from an abstract class cannot be instantiated unless all of its abstract methods are overridden. 

 
Note: Concrete classes contain only concrete (normal) methods whereas abstract classes may contain both concrete methods and abstract methods.
 
● An abstract method can have an implementation in the abstract class. 
 
● However, even if they are implemented, this implementation shall be overridden in the subclasses. 
 
● If you wish to invoke the method definition from the abstract superclass, the abstract method can be invoked with super() call mechanism. (Similar to cases of “normal” inheritance).
 
● Similarly, we can even have concrete methods in the abstract class that can be invoked using super() call. Since these methods are not abstract it is not necessary to provide their implementation in the subclasses. 
 
● Consider the given example:
 
Let's take an example of an abstract class Payment. It has an abstract method called, paymentMode. There are three classes derived from Payment, namely CreditCardPayment, DebitCardPayment, and UPI_Payment. All the three derived classes implement the abstract method paymentMode as one of their functionalities.
 
As a user, we are abstracted from the paymentMode that is inside the class Payment. If we are creating another class CreditCardPayment that inherits the properties of class Payment then we must have to override all the abstract methods i.e paymentMethod here.
 
Example:
 
from abc import ABC, abstractmethod

class Payment(ABC):
    def printSlip(self, amount):
        print('Purchase of amount- ', amount)
   
    @abstractmethod
    def paymentMode(self, amount):
        pass

class CreditCardPayment(Payment):

    def paymentMode(self, amount):
        print('Credit card payment of- ', amount)

class DebitCardPayment(Payment):

    def paymentMode(self, amount):
        print('Debit card payment of- ', amount)
   
class UPI_Payment(Payment):

    def paymentMode(self,amount):
        print("UPI payment of- ",amount)
       
       
       
#Driver's code        
object = CreditCardPayment()
object.paymentMode(100)
object.printSlip(100)

object = DebitCardPayment()
object.paymentMode(200)
object.printSlip(200)

object = UPI_Payment()
object.paymentMode(300)
object.printSlip(300)
 
output:
 
Credit card payment of-  100
Purchase of amount-  100
Debit card payment of-  200
Purchase of amount-  200
UPI payment of-  300
Purchase of amount-  300
 
The given code shows another implementation of an abstract class.
 
# Python program showing how an abstract class works
from abc import ABC, abstractmethod

class Animal(ABC): #Abstract Class
    @abstractmethod
    def move(self):
        pass


class Human(Animal): #Subclass 1
    def move(self):
        print("I can walk and run")
        
        
class Snake(Animal): #Subclass 2
    def move(self):
        print("I can crawl")
   
        
class Dog(Animal): #Subclass 3
    def move(self): 
        print("I can bark")
        

        
# Driver's code
R = Human()
R.move()
K = Snake()
K.move()
R = Dog()
R.move()

We will get the output as:
 
I can walk and run
I can crawl
I can bark

// The capability of a class to derive properties and characteristics from another class is called Inheritance. Inheritance is one of the most important features of Object-Oriented Programming. 

// Inheritance is a feature or a process in which, new classes are created from the existing classes. The new class created is called “derived class” or “child class” and the existing class is known as the “base class” or “parent class”. The derived class now is said to be inherited from the base class.

// When we say derived class inherits the base class, it means, the derived class inherits all the properties of the base class, without changing the properties of base class and may add new features to its own. These new features in the derived class will not affect the base class. The derived class is the specialized class for the base class.

// Sub Class: The class that inherits properties from another class is called Subclass or Derived Class. 
// Super Class: The class whose properties are inherited by a subclass is called Base Class or Superclass. 

#include <iostream>
using namespace std;
//Program to demonstrate Inheritance of cuboid from Rectangle class

//Base Class
class Rectangle
{
private:
    int length;
    int breadth;

public:
    //Mutators or Setters
    void setLength(int l)
    {
        if (l > 0)
        {
            length = l;
        }
        else
        {
            length = 0;
        }
    }
    void setBreadth(int b)
    {
        if (b > 0)
        {
            breadth = b;
        }
        else
        {
            breadth = 0;
        }
    }
    //Accessors or Getters
    int getLength()
    {
        return length;
    }
    int getBreadth()
    {
        return breadth;
    }
    //Function to calculate area of rectangle
    int area()
    {
        return (length * breadth);
    }
    //Function to calculate perimeter of rectangle
    int perimeter()
    {
        return (2 * (length + breadth));
    }
};
//Derived Class
class Cuboid : public Rectangle
{
private:
    int height;

public:
    Cuboid(int l = 0, int b = 0, int h = 0)
    {
        setLength(l);
        setBreadth(b);
        height = h;
    }
    int getHeight()
    {
        return height;
    }
    void setHeight(int h)
    {
        height = h;
    }
    int volume()
    {
        return (getLength() * getBreadth() * height);
    }
};

int main(void)
{
    Cuboid c(10, 5, 3);
    cout << c.getLength() << " " << c.getBreadth() << " " << c.getHeight();
    cout << "Volume = " << c.volume() << endl;
    cout << "Area = " << c.area() << endl;

    return 0;
}



#include <iostream>
#include <math.h>
#include "Fraction.h"
using namespace std;
ostream& operator<<(ostream& outObj, Fraction& f)
{
	outObj << f.num << "/" << f.den << endl;
	return outObj;
}
istream& operator>>(istream& inObj, Fraction& f)
{
	cout << "Enter numerator: ";
	inObj >> f.num;
	cout << "Enter denominator: ";
	inObj >> f.den;
	return inObj;
}
void printGCD(Fraction& f)
{
	cout << "GCD: " << f.gcd();
}
int main()
{
	//Driver Function to show functioning of all operators
	Fraction f1;
	Fraction f2(2, 3);
	Fraction f3(f2);
	Fraction f4;
	f4.setNumerator(4);
	f4.setDenominator(5);
	cout << "Enter values for fraction 1: " << endl;
	cin >> f1;

	cout << endl;
	cout << "F1: " << f1;
	cout << "F2: " << f2;
	cout << "F3: " << f3;
	cout << "F4: " << f4;                                                                                                                                             //f1.Reduce(); f2.Reduce(); f3.Reduce();

	f4 = f1 + f2;                                                                                                                                                     //f4.Reduce();
	cout << endl << "Addition of f1 & f2: " << f4;

	f4 = f1 - f2;                                                                                                                                                    // f4.Reduce();
	cout << endl << "Subtraction of f1 & f2: " << f4;

	f4 = f1 * f2;                                                                                                                                                     //f4.Reduce();
	cout << endl << "Multiplication of f1 & f2: " << f4;

	f4 = f1 / f2;                                                                                                                                                    // f4.Reduce();
	cout << endl << "Division of f1 & f2: " << f4 << endl;

	f4.setNumerator(76);
	f4.setDenominator(16);
	printGCD(f4);
	cout << endl;
	
	double red = f1.reduce();
	cout << endl << "F1 after reduction: " << red << endl;

	if (f2 == f3) cout << endl << "F3 & F2 are equal" << endl;
	else cout << endl << "F3 & F2 are not equal" << endl;

	if (f1 != f3) cout << endl << "F3 & F1 are not equal" << endl;
	else cout << endl << "F3 & F1 are not equal" << endl;

	if (f1 < f2) cout << endl << "F1 is less than F2" << endl;
	else cout << endl << "F1 is greater than F2" << endl;

	f4 = -f3;
	cout << endl << "Negation of F3: " << f4;

	f4 = ++f3;
	cout << endl << "F4 after pre increment: " << f4;
	cout << endl << "F3 after pre increment: " << f3;

	f4 = f3++;
	cout << endl << "F4 after post increment: " << f4;
	cout << endl << "F3 after post increment: " << f3;

	f4 = f2 ^ 3;
	cout << endl << "F2 raised to power 3: " << f4;

	f2 += f2;
	cout << endl << "F2 after combined operator += : " << f2;
}



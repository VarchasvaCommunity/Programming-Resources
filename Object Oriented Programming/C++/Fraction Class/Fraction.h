#pragma once
#include <iostream>
#include <math.h>
using namespace std;
class Fraction 
{
private: 
	     int num; // Numerator of the fractional part. 
		 int den; // Denominator of the fractional part. This must be non-zero 
		 int gcd() // compute and return the GCD of given numbers.
		 {
			 int gcd;
			 for (int i = 10; i>=2; i--)
			 {
				 if (den % i == 0 && num % i == 0)
					 return i;
			 }
		 }
public:
	    Fraction(); // Initialize data members to default values. Remember denominator must not be zero.
		Fraction(int a_nmrator, int a_dnmnator); // Initialize data members with parameter values. 
		Fraction(Fraction& a_Frac); // copy constructor.
		~Fraction(); // Destructor should display message “Object is destroyed”.
		void setDenominator(int a_dnmnator);
		void setNumerator(int a_nmrator);
		int getDenominator() const;
		int getNumerator()const;
		double reduce();
		Fraction operator+(const Fraction&); // overload binary + operator.
		Fraction operator-(const Fraction&); // overload binary – operator.
		Fraction operator*(const Fraction&); // overload binary * operator.
		Fraction operator/(const Fraction&); // overload binary / operator.
		bool operator==(const Fraction& ); // overload relational == operator
		bool operator<(const Fraction& ); // overload relational < operator.
		bool operator!=(const Fraction& ); // overload relational != operator
		Fraction operator-(); // overload unary – operator. 
		Fraction& operator++(); // overload pre-increment operator.
		Fraction operator++(int); // overload post-increment operator.
		friend ostream& operator<<(ostream&, Fraction&); // overload << operator.
		friend istream& operator>>(istream&, Fraction&); // overload << operator.
		Fraction operator+=(const Fraction&); // overload combined operator +=
		Fraction operator^(int ); // overload power operator ^ 
		friend void printGCD(Fraction& f);
		Fraction Reduce() //evaluate and simplify the fraction.
		{
			if (num % den == 0)
			{
				num=num / den;
				den = 1;
			}
			else
			{
				for (int i = 2; i <= 10; i++)
				{
					if (den % i == 0 && num % i == 0)
					{
						den = den / i;
						num = num / i;
					}
				}
			}
			return *this;
		}
};

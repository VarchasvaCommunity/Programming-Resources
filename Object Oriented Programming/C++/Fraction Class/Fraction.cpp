#include "Fraction.h"
Fraction::Fraction() // Initialize data members to default values. Remember denominator must not be zero.
{
	num = 0;
	den = 1;
}
Fraction::Fraction(int a_nmrator, int a_dnmnator) // Initialize data members with parameter values. 
{
	num = a_nmrator;
	den = a_dnmnator;
}
Fraction::Fraction(Fraction& a_Frac) // copy constructor.
{
	num = a_Frac.num;
	den = a_Frac.den;
}
Fraction::~Fraction() // Destructor should display message “Object is destroyed”.
{
	//cout << "Object is destroyed" << endl;
}
void Fraction::setDenominator(int a_dnmnator)
{
	den = a_dnmnator;
}
void Fraction::setNumerator(int a_nmrator)
{
	num = a_nmrator;
}
int Fraction::getDenominator() const
{
	return den;
}
int Fraction::getNumerator()const
{
	return num;
}
double Fraction::reduce() //evaluate and simplify the fraction.
{
	double val;
	if (num % den == 0)
		val = static_cast<double>(num) / den;
	else
	{
		for (int i = 2; i <= 10; i++)
		{
			if (den % i == 0 && num % i == 0)
			{
				den = (den) / i;
				num = (num) / i;
			}
		}
		val = static_cast<double>(num) / den;
	}
	return val;
}
Fraction Fraction::operator+(const Fraction& f2) // overload binary + operator.
{
	Fraction f3;
	if (den == f2.den)
	{
		f3.den = f2.den;
		f3.num = num + f2.num;
	}
	else
	{
		f3.den = den * f2.den;
		f3.num = ((f3.den / den) * num) + ((f3.den / f2.den) * f2.num);
	}
	return f3;
}
Fraction Fraction::operator-(const Fraction& f2) // overload binary – operator.
{
	Fraction f3;
	if (den == f2.den)
	{
		f3.den = f2.den;
		f3.num = num - f2.num;
	}
	else
	{
		f3.den = den * f2.den;
		f3.num = ((f3.den / den) * num) - ((f3.den / f2.den) * f2.num);
	}
	return f3;
}
Fraction Fraction::operator*(const Fraction& f) // overload binary * operator.
{
	Fraction f3;
	f3.num = num * f.num;
	f3.den = den * f.den;
	return f3;
}
Fraction Fraction::operator/(const Fraction& f)
{
	Fraction f3;
	f3.num = num * f.den;
	f3.den = den * f.num;
	return f3;
}
bool Fraction::operator==(const Fraction& f) // overload relational == operator
{
	if (num == f.num && den == f.den)
		return true;
	else 
		return false;
}
bool Fraction::operator<(const Fraction& f) // overload relational < operator.
{
	return (num / den < f.num / f.den);
}
bool Fraction::operator!=(const Fraction& f) // overload relational != operator
{
	if (num == f.num && den != f.den)
		return true;
	else if (num != f.num && den == f.den)
		return true;
	else if (num != f.num && den != f.den)
		return true;
	else
		return false;
}
Fraction Fraction::operator-() // overload unary – operator. 
{
	Fraction f2;
	f2.num = (-1)*num;
	f2.den = den;
	return f2;
}
Fraction& Fraction::operator++() // overload pre-increment operator.
{
	num = (den * 1) + num;
	return *this;
}
Fraction Fraction::operator++(int) // overload post-increment operator.
{
	Fraction temp(*this);
	num = (den * 1) + num;
	return temp;
}
Fraction Fraction::operator+=(const Fraction& f) // overload combined operator +=
{
	if (den == f.den)
	{
		den = f.den;
		num = num + f.num;
	}
	else
	{
		den = den * f.den;
		num = ((den / den) * num) + ((den / f.den) * f.num);
	}
	return *this;
}
Fraction Fraction::operator^(int n) // overload power operator ^ 
{
	Fraction f2;
	f2.num = pow(num, n);
	f2.den = pow(den, n);
	return f2;
}
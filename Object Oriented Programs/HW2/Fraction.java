package HW2;

public class Fraction{
	
  private int numerator = 0;		// numerator (and keeps sign)
  private int denominator = 1;		// always stores positive value

  public Fraction()
  {
  }

  public Fraction(int n, int d)
  {
    if (set(n,d)==false)
	set(0,1);
  }

  public boolean set(int n, int d)
  {
    if (d > 0)
    {
	numerator = n;
	denominator = d;
	return true;
    }
    else
	return false;
  }
  
  public String toString()
  {
    return (numerator + "/" + denominator);
  }

  public int getNumerator()
  {
    return numerator;
  }

  public int getDenominator()
  {
    return denominator;
  }

  public double decimal()
  {
    return (double)numerator / denominator;
  }
  
  public Fraction simplify() {
	  Fraction newFraction = new Fraction();
	  
	  int num = numerator;
	  int denom = denominator;
	  int gcd = 1;
	  
	  if(num < 0) {
		  num *= -1;
		  
		  for(int i = 1; i <= num && i <= denom; i ++) {
			  if(num % i == 0 && denom % i == 0) {
				  gcd = i;
			  }
		  }
		  
		  num = num/gcd;
		  denom = denom/gcd;
		  num *= -1;
		  newFraction.set(num, denom);
	  }
	  else if(denom < 0) {
		  denom *= -1;
		  
		  for(int i = 1; i <= num && i <= denom; i ++) {
			  if(num % i == 0 && denom % i == 0) {
				  gcd = i;
			  }
		  }
		  
		  num = num/gcd;
		  denom = denom/gcd;
		  num *= -1;
		  newFraction.set(num, denom);
	  }
	  else {
		  for(int i = 1; i <= num && i <= denom; i ++) {
			  if(num % i == 0 && denom % i == 0) {
				  gcd = i;
			  }
		  }
		  
		  num = num/gcd;
		  denom = denom/gcd;
		  newFraction.set(num, denom);
	  }
	 
	  return newFraction;
  }
  
  public Fraction add(Fraction oFrac) {
	  Fraction sum = new Fraction();
	  
	  sum.numerator = ((numerator * oFrac.denominator) + (denominator * oFrac.numerator));
	  sum.denominator = (denominator * oFrac.denominator);
	  
	  return sum.simplify();
  }
  
  public Fraction subtract(Fraction oFrac) {
	  Fraction s = new Fraction();
	  
	  s.numerator = ((numerator * oFrac.denominator) - (denominator * oFrac.numerator));
	  s.denominator = (denominator * oFrac.denominator);
	  
	  return s.simplify();
  }
  
  public Fraction multiply(Fraction oFrac) {
	  Fraction product = new Fraction();
	  
	  product.numerator = numerator * oFrac.numerator;
	  product.denominator = denominator * oFrac.denominator;
  
	  return product.simplify();
  }
  
  public Fraction divide(Fraction oFrac) {
	  Fraction end = new Fraction();
	  
	  end.numerator = numerator * oFrac.denominator;
	  end.denominator = denominator * oFrac.numerator;

	  return end.simplify();	  
  }

}
package practical;

public class Complex {
    private double realPart;
    private double imaginaryPart;

    public Complex() {
        realPart = 0;
        imaginaryPart = 0;
    }

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public Complex add(Complex otherComplex) {
        return new Complex(realPart + otherComplex.getRealPart(), imaginaryPart + otherComplex.getImaginaryPart());
    }

    public Complex subtract(Complex otherComplex) {
        return new Complex(realPart - otherComplex.getRealPart(), imaginaryPart - otherComplex.getImaginaryPart());
    }

    public Complex multiply(Complex otherComplex) {
        Complex newCp = new Complex();
        newCp.setRealPart(realPart * otherComplex.getRealPart() - imaginaryPart * otherComplex.getImaginaryPart());
        newCp.setImaginaryPart(realPart * otherComplex.getImaginaryPart() + imaginaryPart * otherComplex.getRealPart());
        return newCp;
    }

    public Complex divide(Complex otherComplex) {
        Complex newCp = new Complex();
        newCp.setRealPart((realPart * otherComplex.getRealPart() + imaginaryPart * otherComplex.getImaginaryPart()) /
                (Math.pow(otherComplex.getRealPart(), 2) + Math.pow(otherComplex.getImaginaryPart(), 2)));
        newCp.setImaginaryPart((imaginaryPart * otherComplex.getRealPart() - realPart * otherComplex.getImaginaryPart()) /
                (Math.pow(otherComplex.getRealPart(), 2) + Math.pow(otherComplex.getImaginaryPart(), 2)));
        return newCp;
    }

    @Override
    public String toString() {
        return realPart +
                (imaginaryPart>0?"+":"-") + Math.abs(imaginaryPart) +
                'i'
                ;
    }
}

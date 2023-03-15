enum RomainNumbers {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100);
    public final int value;
    RomainNumbers(int value){this.value = value;}

    public int getValue() {
        return value;
    }
}

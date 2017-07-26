from MyPackage.MyClass import MySpecialClass

def main():
    print "In the main method"
    myObj = MySpecialClass("Hello, World!")
    print myObj
    myObj.addSome(2)
    print myObj.myInt
    MySpecialClass.staticMethod()

    myObj.myValue = "Something else!"
    print myObj


if __name__ == '__main__':
    # Equivalent to Java's
    # public static void main(String[] args)
    main()

from MyPackage.MyClass import MySpecialClass

def main():
    print "In the main method"
    
    myObj = MySpecialClass("Hello, World!", 1)
    print myObj
    myObj.addSome(2)
    print myObj.myInt
    
    myObj.addSomeCommonMethod(6)
    print "myObj.myCommonInt: " + str(myObj.myCommonInt)

    myObj2 = MySpecialClass("Bye, World!", 2)
    
    print myObj2
    
    myObj2.addSome(3)
    print myObj2.myInt
    print myObj2.myCommonInt
    
    MySpecialClass.staticMethod()

    myObj.myValue = "Something else!"
    print myObj
    
    myObj.changeGlobal(6)
    print myObj2.myCommonInt
    print myObj.myCommonInt
    print MySpecialClass.myCommonInt

if __name__ == '__main__':
    # Equivalent to Java's
    # public static void main(String[] args)
    main()

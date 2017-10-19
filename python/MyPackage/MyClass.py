# This file defines a class
 
class MySpecialClass(object):
    """
    This is a pydoc string
    Very similar to javadoc
    """
    myCommonInt = 999
    
    def __init__(self, value, myInt):
        """
        This is the constructor for an object
        :param value: The parameter value, can be anything I want
        """
        self.myInt = myInt
        self.myValue = value

    def myMethod(self):
        """
        Concats myInt with myValue
        :return: myInt concated with myValue
        """
        return str(self.myInt) + "\n" + str(self.myValue)

    def addSome(self, some):
        """
        Adds some number to myInt
        :param some: A number value
        :return: None
        """
        self.myInt += some
        
        
    def addSomeCommonMethod(self, some):
        """
        Adds some number to myInt
        :param some: A number value
        :return: None
        """
        MySpecialClass.myCommonInt +=some
        print "MySpecialClass.myCommonInt=" + str(MySpecialClass.myCommonInt)

    def changeGlobal(self, some):
        """
        Adds some number to myInt
        :param some: A number value
        :return: None
        """
        global myCommonInt
        myCommonInt = MySpecialClass.myCommonInt
        myCommonInt += some
        print myCommonInt
        test()
    @classmethod    
    def test(self):
         print "InSelf==" +str(myCommonInt)   

    def getObj(self):
        return myCommonInt

    @staticmethod
    def staticMethod():
        print "Hello from the static method!"

    def __str__(self):
        return "MySpecialClass " + str(self.myValue)

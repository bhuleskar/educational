arr =["I", 2,"eat"]



def printArray():
    print "In printArray"
    for var in arr: 
        print var
        
    foo()
    return arr

def foo():
    print "In foo"

a = printArray()
print a 
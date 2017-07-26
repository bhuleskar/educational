# Different for loops in python

my_array = ["one", "two", 3, "apple"]

# Basic enhanced for loop (for each)
print "For each loop"
for item in my_array:
    print item

# Python has no standard for loop
# Eg. there is no direct equivalent to for(int i = 0; i < 10; i++)
# Instead, if you need specific indexes, you should use a while loop, or the following
print "Standard for loop"
for i in xrange(0, len(my_array)):
    # Notice, because the array has mixed types
    # I must stringify the values before concat-ing them
    print str(i) + ": " + str(my_array[i])

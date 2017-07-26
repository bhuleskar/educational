falseValue = False
trueValue = True
zeroValue = 0
truthyValue = "I'm true!"

if trueValue:
    print "true!"

if not falseValue:
    print "Not false"

if zeroValue and truthyValue:
    print "Zero is truthy?"
else:
    print "Zero is falsey"

if falseValue:
    "Shouldn't see this"
elif truthyValue or zeroValue:
    print "Strings are truthy"
else:
    print "Nothing is true"
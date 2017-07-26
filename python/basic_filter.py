def only_even(val):
    return not val % 2

nums = [1,2,3,4,5,6,7,8,9,10]

print filter(only_even, nums)
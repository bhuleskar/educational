

# A python dictionary
my_dict = {"fruit" : "apple", "vegetable" : "broccoli", "numbers" : [1, 2, 3]}
books = {"Dune": "Frank Herbert"}

books["Artemis Fowl"] = "Eoin Colfer"  # Adding a key/value pair

my_dict["books"] = books  # Adding a dict to another dict
my_dict["books"]["A Series of Unfortunate Events"] = "Lemony Snicket"

# Keys don't need to be strings, they just need to be "hashable"
my_dict[1] = "One"
my_dict[1.5] = "My key is a float!"

for key in my_dict:
    print str(key) + ": " + str(my_dict[key])

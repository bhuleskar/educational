temps_c = [39.2, 36.5, 37.3, 37.8]
temps_f = [((float(9)/5)*x + 32) for x in temps_c]

sentence = "Hello! My name is Jacob."
upper = [(s.upper()) for s in sentence.split()]

print temps_c
print temps_f
print upper
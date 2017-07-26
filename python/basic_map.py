
def f_to_c(temp):
    return ((float(9)/5)*temp + 32)

def c_to_f(temp):
    return (float(5) / 9) * (temp - 32)


temps_orig_c = [10, 20, 37.5, 100]
temps_f = map(f_to_c, temps_orig_c)
temps_c = map(c_to_f, temps_f)

print temps_orig_c
print temps_f
print temps_c
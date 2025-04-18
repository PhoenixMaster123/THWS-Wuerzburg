# -*- coding: utf-8 -*-
"""
Created on Wed Apr 16 09:26:33 2025

@author: krisi
"""

# Exponentialreihe
import numpy as np
import math
import matplotlib.pyplot as plt 

# Variant 1:
n = np.arange(0, 100, 1)

e = np.array([1 / math.factorial(i) for i in n])
summe = np.sum(e)

print(f"{summe}")

# Variant 2: Prof
N = 100
[1 / math.factorial(k) for k in range(N+1)] # <=> math.e

# Taylorentwicklung von exp(x)
x = np.arange(-3,3, 0.001)
f = np.exp(x)

T1 = 1 + x
T2 = T1 + x**2 / math.factorial(2)
T3 = T2 + x**3 / math.factorial(3)
T4 = T3 + x**4 / math.factorial(4)
T5 = T4 + x**5 / math.factorial(5)

plt.figure()
plt.plot(x, f, label="$\\exp(x)$")
plt.plot(x, T1, label="Taylorpolyn. 1. Ordnung")
plt.plot(x, T2, label="Taylorpolyn. 2. Ordnung")
plt.plot(x, T3, label="Taylorpolyn. 3. Ordnung")
plt.plot(x, T4, label="Taylorpolyn. 4. Ordnung")
plt.plot(x, T5, label="Taylorpolyn. 5. Ordnung")
plt.legend()
plt.show()


# Kompakt Code:
x = np.arange(-3, 3, 0.001)
f = np.exp(x)

T = np.ones_like(x)
for n in range(1, 6):
    T += x**n / math.factorial(n)
    plt.plot(x, T, label=f"Taylorpolyn. {n}.Ordnung")
plt.legend()
plt.show()
    
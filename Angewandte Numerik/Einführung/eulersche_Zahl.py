import math
import matplotlib.pyplot as plt

N = 100
y = []
for n in range(1, N + 1):
    y.append((1 + 1 / n) ** n)

plt.figure()
plt.plot(range(1, N + 1), y, "ro")
plt.axhline(math.e, label="Eulersche Zahl $e$")
plt.legend()
plt.show()

"""
Kompakter mit List comprehension!
"""
N = 100
y = [(1 + 1 / n) ** n for n in range(1, N + 1)] # compact Schreibweise
plt.figure()
plt.plot(range(1, N + 1), y, "ro")
plt.axhline(math.e, label="Eulersche Zahl $e$")
plt.legend()
plt.show()

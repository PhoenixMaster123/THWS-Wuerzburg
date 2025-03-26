import matplotlib.pyplot as plt
# Fibonacci Folge

# def ⇒ funktion definieren
# [] ⇒ liste definieren

# [1] * 4 = [1, 1, 1, 1]
# [1, 5, 6, "Text"]
# [-1] -> letzte Element von der Liste

# For Schleife:
# for i in range (startIndex, endIndex - 1)

# Fibonacci Folge: Variant 1
def fib_v1(n):
    f = [1] * n
    for i in range(2, n):
        f[i] = f[i - 1] + f[i - 2]
    return f
print("v1:", fib_v1(10))
print("v1:", fib_v1(0))
# Fibonacci Folge: Variant 2

def fib_v2(n): # Liste sukzessiv erweitern
    if n <= 0:
        return []
    elif n == 1:
        return [1]
    f = [1, 1]
    for i in range(2, n):
        f.append(f[-1] + f[-2])
    return f
print("v2:", fib_v2(10))
# Fibonacci Folge: Variant 3

def fib_v3(n): # Liste sukzessiv erweitern
    if n <= 0:
        return []
    elif n == 1:
        return [1]
    f = [1, 1]
    for _ in range(2, n): # i nicht verwendet ⇒ verwende underscore
        f.append(f[-1] + f[-2])
    return f
print("v3:", fib_v3(10))
# Fibonacci Folge: Variant 4
def fib_v4(n): # Liste sukzessiv erweitern
    if n <= 0:
        return []
    elif n == 1:
        return [1]
    f = [1, 1]
    i = 1
    while i <= n - 2:
        f.append(f[-1] + f[-2])
        i += 1
    return f
print("v4:", fib_v4(10))
# print("v1:", fib_v1(10)) # [1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
# print("v1:", fib_v1(0)) # []
# print("v2:", fib_v2(10))
print("v5:", fib_v4(10))

# Create Diagramm
n = 10
x = range(1, n + 1)
y = fib_v1(n)

# interface-Funktionen zum Plotten (ähnlich zu MATLAB)
plt.figure()
plt.plot(x, y, "ro")
plt.show()

# Zusätzliche Einstellungen
plt.figure(figsize=(8, 6))
plt.plot(x, y, "ro")
plt.grid()
plt.xlabel("x-Achse")
plt.ylabel("y-Achse")
plt.title("Fibonacci-Zahlen")
plt.show()

# Object-orientierte approach

fig = plt.figure(figsize=(8, 6))
ax = fig.subplots() # Create Axes objects inside the Figure and return the Axes
ax.plot(x, y, "ro")
ax.grid()
ax.set_xlabel("x-Achse")
ax.set_ylabel("y-Achse")
ax.set_title("Fibonacci numbers")
plt.show()


# Etwas schneller: fix, ax in einem Schritt
fig, ax = plt.subplots(figsize=(8, 6))
ax.plot(x, y, "ro")
ax.grid()
ax.set_xlabel("x-Achse")
ax.set_ylabel("y-Achse")
ax.set_title("Fibonacci numbers")
plt.show()

# Figure with 6 axes (2 Zeilen, 3 Spalten)
fix, axs = plt.subplots(2, 3)
axs[1, 2].plot(x, y, "ro")
axs[1, 2].grid()
plt.show()


# Weitere Beispiele
import math
"""
Basel Problem
"""

limit_approx = 0
for k in range(1, 1000000):
    limit_approx += 1 / k**2
print(limit_approx)


limit = math.pi**2 / 6
print(limit)

#  Visualisierung der Reihenkonvergenz
import matplotlib.pyplot as plt
import math
limit = math.pi**2 / 6
n = 70 # Anzahl Terme
sum_values = [math.nan] * n
cumsum = 0 # kumulative Summe
for k in range(n):
    cumsum += 1 / (k + 1)**2
    sum_values[k] = cumsum
plt.figure()
x = range(1, n + 1)
plt.plot(x, sum_values, "ro", label="Cumulative sum $\\sum_{i=1}^{n}$")
plt.axhline(limit, label="Limit $\\frac{\\pi^2}{6}$")
plt.xlabel("Number of terms n")
plt.legend()
plt.show()

# Latex Code für pi^2/6: $\frac{\pi^2}{6}$

# Leibniz-Reihe
n = 70
limit = math.pi / 4
cumsum = 0
sum_values = [math.nan] * n
for k in range(n):
    cumsum += (-1)**k / (2 * k + 1)
    sum_values[k] = cumsum

plt.figure()
x = range(1, n+1)
plt.plot(x, sum_values, "r-", label="Leibniz $\\sum_{k=0}^\\infty \\frac{(-1)^k}{2*k+1}$")
plt.axhline(limit, label="limit $\\frac{\\pi}{4}$")
plt.xlabel("Number of terms n")
plt.legend()
plt.show()

# More about loops, list comprehension, etc.

# Eulersche Zahl e

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

# NumPy => library for arrays
import numpy as np

#np.linspace(start, stop, num, endpoint)

n = np.arange(start = 1, stop = 100, step = 1)
y = (1 + 1 / n)**n

plt.figure()
plt.plot(n, y, 'ro')
plt.show()
import matplotlib.pyplot as plt
import math
# Weitere Beispiele
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
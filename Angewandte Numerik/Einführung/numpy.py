import numpy as np
import matplotlib.pyplot as plt

#np.linspace(start, stop, num, endpoint)

n = np.arange(start = 1, stop = 100, step = 1)
y = (1 + 1 / n)**n

plt.figure()
plt.plot(n, y, 'ro')
plt.show()

plt.figure()
plt.plot(n, y, 'ro')
plt.xlabel("n")
plt.ylabel("Approximation von e")
plt.axhline(np.e, color="blue", linestyle="--", label="Eulersche Zahl e")
plt.legend()
plt.show()
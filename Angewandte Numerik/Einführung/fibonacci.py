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
# %% Fibonacci Folge: Variant 3

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

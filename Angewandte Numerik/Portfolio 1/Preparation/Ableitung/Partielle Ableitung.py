# -*- coding: utf-8 -*-
"""
Created on Fri Apr 18 21:14:11 2025

@author: krisi
"""
from sympy import symbols, diff
from sympy.parsing.sympy_parser import parse_expr

def partielle_ableitung(expr_str, var_list_str, ableitung_nach):
    # Variablen erzeugen (z.B. "x y z" → x, y, z)
    expr = parse_expr(expr_str, evaluate=False)

    # Ableitungsvariable holen
    ableitungs_var = symbols(ableitung_nach)

    # Partielle Ableitung berechnen
    ableitung = diff(expr, ableitungs_var)

    return expr, ableitung


if __name__ == "__main__":
    funktion = "cos(x*y)**2" # exp(x)*y + 2*x*y # x**2 - 5*x*y**2
    variablen = "x y"
    nach = "x"  # auch "y" möglich

    f, df = partielle_ableitung(funktion, variablen, nach)

    print(f"Funktion:            {f}")
    print(f"Partielle Ableitung ∂f/∂{nach}:  {df}")


print("\n")

## Zweite Partielle Ableitung
def zweite_partielle_ableitung(expr_str, var_list_str, ableitung_nach_1, ableitung_nach_2):
    # Variablen erzeugen
    expr = parse_expr(expr_str, evaluate=False)

    # Partielle Ableitung 2. Ordnung
    ableitung = diff(expr, symbols(ableitung_nach_1), symbols(ableitung_nach_2))

    return expr, ableitung


if __name__ == "__main__":
    funktion = "cos(x*y)**2"
    variablen = "x y"

    # Beispiel
    f1, df_xx = zweite_partielle_ableitung(funktion, variablen, "x", "y")   # ∂²f/∂x²

    print("Funktion:", f1)
    print("Zweite partielle Ableitung", df_xx)
# -*- coding: utf-8 -*-
"""
Created on Fri Apr 18 19:26:49 2025

@author: krisi
"""

from sympy import Matrix

def symbolic_eigenvalues(matrix):
    A = Matrix(matrix)
    eigenvals = A.eigenvals()  # returns dict {eigenvalue: multiplicity}
    return eigenvals

if __name__ == "__main__":
    A = [
            [1, 3, -1],
            [0, 2, 1],
            [0, -1, 2]
        ]

    eigenvals = symbolic_eigenvalues(A)
    print("Symbolische Eigenwerte:")
    for ev, multiplicity in eigenvals.items():
        print(f"{ev} (Vielfachheit: {multiplicity})")
        
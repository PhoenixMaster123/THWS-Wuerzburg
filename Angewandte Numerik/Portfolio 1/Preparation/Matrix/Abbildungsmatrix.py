# -*- coding: utf-8 -*-
"""
Created on Fri Apr 18 19:14:49 2025

@author: krisi
"""
import sympy as sp

def get_transformation_matrix():
    # Define symbols
    x, y, z = sp.symbols('x y z')

    # Define the transformation function T(x, y, z)
    T = sp.Matrix([
        5*x - y - z,
        z,
        x + y
    ])

    # Define the input vector
    vec = sp.Matrix([x, y, z])

    # Compute the Jacobian matrix (Abbildungsmatrix)
    A = T.jacobian(vec)
    return A

if __name__ == "__main__":
    A = get_transformation_matrix()
    print("Abbildungsmatrix A:")
    sp.pprint(A, use_unicode=True)

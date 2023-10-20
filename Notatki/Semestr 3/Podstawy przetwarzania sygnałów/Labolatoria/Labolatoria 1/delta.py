import math


def delta():
    try:
        print("Insert A, B, C such as Ax^2+Bx+C:\n")
        a = float(input("A:\n"))
        b = float(input("B:\n"))
        c = float(input("C:\n"))
    except:
        print("Wrong value:\n")
        a = 0
        b = 0
        c = 1

    if a == 0:
        if b == 0:
            if c == 0:
                print("All\n")
            else:
                print("None\n")
        else:
            print("X=0 for: ", -c / b, "\n")
    else:
        d = b ** 2 - 4 * a * c
        if d < 0:
            print("None\n")
        elif d == 0:
            print("X=0 for: ", -b / (2 * a), "\n")
        else:
            print("X=0 for: ", (-b + math.sqrt(d)) / (2 * a), (-b - math.sqrt(d)) / (2 * a), "\n")


if __name__ == '__main__':
    while True:
        delta()
        line = input("Continue [Y/N]?\n")
        if line == "n" or line == "N":
            break

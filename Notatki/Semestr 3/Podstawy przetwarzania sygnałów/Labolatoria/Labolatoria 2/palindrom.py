def printispalindrom(text):
    if text == text[::-1]:
        print("Wyraz jest palindromem")
    else:
        print("Wyraz nie jest palindromem")


if __name__ == '__main__':
    printispalindrom(input("Wyraz do sprawdzenia: "))

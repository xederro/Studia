def count(path):
    file = open(path)
    c = {}
    for line in file:
        for char in line:
            if not c.get(char):
                c[char] = 1
            else:
                c[char] += 1
    return c


if __name__ == '__main__':
    counted = count("text.txt")
    for key in sorted(counted.keys()):
        print(key, counted[key])
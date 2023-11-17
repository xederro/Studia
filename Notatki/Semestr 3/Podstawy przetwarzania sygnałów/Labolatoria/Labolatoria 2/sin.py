import math

import numpy as np
import matplotlib.pyplot as plt

def plotsin():
    time = np.arange(0, 2*math.pi, 0.0001)
    amplitude = np.sin(time)
    plt.plot(time, amplitude)
    plt.title("Sine")
    plt.ylabel("Amplitude")
    plt.xlabel("Time")
    plt.show()


if __name__ == '__main__':
    plotsin()

import numpy as np
import matplotlib.pyplot as plt


def plotDFT(time, freq):
    time = np.arange(0.0, time, 0.001)
    amplitude = np.sin(time * 2 * np.pi * freq)
    N = len(amplitude)
    n = np.arange(N)
    k = n.reshape((N, 1))

    DFT = np.exp(-2 * np.pi * 1j * k * n / N)
    return np.abs(np.dot(amplitude, DFT))[:N // 2]



if __name__ == '__main__':
    DFT = plotDFT(2, 200)
    plt.plot(DFT)
    plt.title("Sine")
    plt.ylabel("Amplituda")
    plt.xlabel("Czestotliwosc")
    plt.show()

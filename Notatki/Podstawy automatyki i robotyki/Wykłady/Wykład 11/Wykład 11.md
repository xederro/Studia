# Cyfrowe przetwarzanie obrazów i jego zastosowania

- "wstęp do przetwarzania obrazów przemysłowych" Rafajłowicz

Python:
	Tensorflow
		Keras
	Pytorch
OpenCV
CUDA



## Zastosowania
- przemysł samochodowy
- spożywczy
- tekstylny
- kontrola jakości
- pakowania
- powierzchni
- inspekcja trudno dostępnych miejsce
- rolnictwo
- wykrywanie pożarów



## Transformacje punktowe

I(i,j) - wartość pixela w i-tym wierszu i j-tej kolumnie
I'(i,i) = f(I(i,j))

 - często najpierw zamiana na obraz monochromatyczny

Korekcja Gamma

Progowanie
jeżeli wartość jest mniejsza od progu to 0 jak większa to 1

Korekcja kontrastu

znajdowanie obiektu znając kształt przez liczenie wskaźnika wariancji

segmanetacja - zaznaczenie interesujących nas obiektów

Filtracja
	zakłócenie typu "sól i pieprz" - usuwanie czarnego i białego szumu bierzemy fragment i liczymy mediane, to co zbytnio odstaje zastępujemy np. medianą
	Filtr gaussowski - uśredniamy środkowy pixel zastępując średnią ważoną okolicznych pixeli
	Histogramy brzegowe - liczymy wartości pixeli wierszami i kolumnami, np jezęli mamy po srodku czarny obiekt to tam na obu osiach będzie minimum #kolokwium 



Podczerwień
Bolometr
Termowizja
Pozytonowa tomografia emisyjna
USG



Stetoskopia - 2 kamery dzięki którym liczymy odległość


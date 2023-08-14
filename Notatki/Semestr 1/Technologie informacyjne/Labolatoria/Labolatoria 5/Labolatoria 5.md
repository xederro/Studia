![TI___lab5](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%205/TI___lab5.pdf)
![lab5](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%205/lab5.pdf)
```tex
\documentclass{beamer}
\usepackage[utf8]{inputenc}
\usepackage{polski}
\usetheme{Ilmenau}
\usecolortheme{rose}
\title[PP - stdio]{\textbf{Podstawy Programowania - standardowy strumień wejścia/wyjścia}}
\author[Dawid Jabłoński]{Dawid Jabłoński}
\date{\today}
\setbeamertemplate{caption}[numbered]
\begin{document}


\begin{frame}[plain]
    \maketitle
\end{frame}
\begin{frame}
    \frametitle{Spis treści}
    \tableofcontents
\end{frame}

\section{Funkcja: printf}
\begin{frame}
    \frametitle{Funkcja: printf()}
    \begin{exampleblock}{Blok}
        int printf( tekst\_sterujący , argument\_1 , argument\_2 , ... ) ;
    \end{exampleblock}
    \newline
    tekst sterujący - jest to stała łańcuchowa (w cudzysłowach) zawierająca:
    \newline
     - zwykłe znaki (które są po prostu kopiowane na ekran)
    \newline
     - kody formatujące kolejnych argumentów 
\end{frame}

\section{Kody formatujące}
\begin{frame}
    \frametitle{Kody formatujące}
    \begin{itemize}
        \item<1-> \%g - liczba zmiennoprzecinkowa (krótszy z formatów \%f \%e)
        \item<2-> \%u - liczba dziesiętna bez znaku
        \item<3-> \%x - liczba w kodzie szesnastkowym (bez znaku)
        \item<4-> \%o - liczba w kodzie ósemkowym (bez znaku)
        \item<5-> l - przedrostek (long) stosowany przed: d u x o
    \end{itemize}
\end{frame}
\begin{frame}
    \frametitle{Kody formatujące cd.}
    \begin{itemize}
        \item<1-> \%c - pojedynczy znak
        \item<2-> \%s - łańcuch znaków
        \item<3-> \%d - liczba dziesiętna ze znakiem
        \item<4-> \%f - liczba zmiennoprzecinkowa (notacja dziesiętna)
        \item<5-> \%e - liczba zmiennoprzecinkowa (notacja wykładnicza)
    \end{itemize}
\end{frame}

\section{Przykład: printf}
\begin{frame}
    \frametitle{Przykład}
    \begin{figure}[ht]
        \centering
        \includegraphics[width= 10cm]{carbon (1).png}
        \caption{Efekt na ekranie: Wynik obliczen 10 + 20 = 30.000000}%
    \end{figure}
\end{frame}

\section{Kody formatujące długość}
\begin{frame}
    \frametitle{Kody formatujące długość}
    Aby określić ilość drukowanych cyfr do kodu formatującego można
dodać kody długości: \%Xd \%X.Xf
\newline
    \begin{columns}
        \begin{column}{.1\linewidth}
            \textbf{Kod}
            \newline
            \%4d:
            \newline
            \%10f:
            \newline
            \%10.2f:
            \newline
            \%.3f:
            \newline
        \end{column}
        \begin{column}{.9\linewidth}
            \textbf{Działanie}
            \newline
            liczba dziesiętna na czterech pozycjach
            \newline
            liczba rzeczywista na 10 pozycjach
            \newline
            liczba rzeczywista na 10 pozycjach, 2 cyfry po przecinku
            \newline
            liczba rzeczywista z dokladnoscią do 3 cyfr po przecinku 
            \newline
        \end{column}
    \end{columns}
\end{frame}

\section{Funkcja: scanf}
\begin{frame}
    \frametitle{Funkcja: scanf()}
    \begin{exampleblock}{Blok}
        int scanf( tekst\_sterujący , adres\_1 , adres\_2 , ... ) ;
    \end{exampleblock}
    \newline
    \& - operator adresowania (zwraca adres zmiennej podanej po operatorze) 
\end{frame}

\section{Przykład: scanf}
\begin{frame}
    \frametitle{Przykład}
    Aby uzyskać w terminalu komunikacje z użytkownikiem \newline
    Wydruk - Podaj jedna liczbe rzeczywista i jeden znak: \newline
    Odczyt - 456.789 a \newline
    \begin{figure}[ht]
        \centering
        \includegraphics[width= 10cm]{carbon (2).png}

        \caption{Wynik wczytywania: y == 456.789, znak == ’a’ }%
    \end{figure}
\end{frame}

\section{}
\begin{frame}[plain]
    \frametitle{Bibliografia}
    \begin{itemize}
        \item \href{http://marek.piasecki.staff.iiar.pwr.wroc.pl/dydaktyka/pp/2020_W02_wej-wyj_if_else_switch.pdf}{Marek Piasecki - Wykład 2} 
    \end{itemize}
\end{frame}
\end{document}

```
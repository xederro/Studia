
main.tex
```latex
\input{header}
\begin{document}
\frontpage{%
    Technologie Informacyjne% nazwa kursu
}{%
    Informatyka Techniczna% kierunek
}{%
    Wtorek TP 7:30% termin
}{-}{-}{%
    Dawid Jabłoński 272970% dane osobowe
}{%
    https://www.overleaf.com/read/rgxwfyrkkjfy% link do edytowalnej wersji projektu
}{\today}{%
    3% numer raportu
}
\pagestyle{empty}
\section{Wykresy z pliku}
\begin{figure}[h]
\centering
\begin{tikzpicture}
    \begin{axis}[
        width=\textwidth*0.9,
        xlabel=x,
        ylabel=f\textsubscript{i}(x),
        xmajorgrids=true,
        ymajorgrids=true,
        grid style={dashed, gray!50},
        legend pos = outer north east
    ]
    \addplot[orange!65, mark=*] table[x=x, y=f1, col sep=comma] {./DANE3.csv};
    \addplot[blue!65, mark=square*] table[x=x, y=f2, col sep=comma] {./DANE3.csv};
    \addplot[red!65, mark=+] table[ x=x, y=f3, col sep=comma] {./DANE3.csv};
    \legend{$sin(x)$,$ sin(2x)$,$x^2e^{-x}$}
    \end{axis}
\end{tikzpicture}
\caption{wykres funkcji w skali liniowej}
\label{fig:2dchart}

\end{figure}
\vfill
\makeatletter \setlength{\@fptop}{0pt} \makeatother
\begin{figure}[h]
\centering
\begin{tikzpicture}
    \begin{semilogxaxis}[
        width=\textwidth*0.9,
        xlabel=x,
        ylabel=f\textsubscript{i}(x),
        ymajorgrids=true,
        grid style={dashed, orange!50},
        legend pos = south west
    ]
    \addplot[red, mark=*] table[x=x, y=f1, col sep=comma] {./DANE3.csv};
    \addplot[blue!65, mark=square] table[x=x, y=f2, col sep=comma] {./DANE3.csv};
    \addplot[black, mark=*] table[ x=x, y=f3, col sep=comma] {./DANE3.csv};
    \legend{$sin(x)$,$ sin(2x)$,$x^2e^{-x}$}
    \end{semilogxaxis}
\end{tikzpicture}
\caption{wykres funkcji w skali logarytmicznej}
\label{fig:2dchart}

\end{figure}
\vfill

\end{document}


```

![DANE3](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%203/DANE3.csv)

![lab3_a](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%203/lab3_a.pdf)
![lab3_b](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%203/lab3_b.pdf)
![TI___lab3](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%203/TI___lab3.pdf)



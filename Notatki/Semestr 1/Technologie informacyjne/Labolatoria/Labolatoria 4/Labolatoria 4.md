![TI___lab4](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%204/TI___lab4.pdf)
![lab4_a](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%204/lab4_a.pdf)
![lab4b](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%204/lab4b.pdf)
```tex
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
    https://www.overleaf.com/read/bgdfmvszyxxz% link do edytowalnej wersji projektu
}{\today}{%
    4% numer raportu
}
\pagestyle{empty}
\begin{figure}[h]
\centering
    \begin{tikzpicture}[
        baseshape/.style={minimum width=3.5cm, minimum height=1cm,
        text centered, font=\normalsize,
        draw=black, drop shadow=black!40, very thick},
        startstop/.style={baseshape, ellipse, fill=yellow!50},
        io/.style={baseshape, trapezium, trapezium stretches=true,
        trapezium left angle=70, trapezium right angle=110, fill=green!20, text width=3cm},
        process/.style={baseshape, rectangle, rounded corners, text width=3cm, fill=red!15},
        decision/.style={baseshape, diamond, minimum width=1cm, fill=blue!30},
        arrow/.style={thick, -latex},
        node distance=1.5cm,
        ]
        \node (step1) [startstop] {Start};
        \node (step2) [io, below of=step1] {Wczytaj \break a, b, c};
        \node (step3) [process, below of=step2] {Oblicz $\Delta = b^2-4ac$};
        \node (step4) [decision, below of=step3, yshift=-0.1cm] {$\Delta < 0$};
        \node (step5) [process, below of=step4, xshift=-4cm] {Wypisz brak rozwi\k{a}zań};
        \node (step6) [decision, below of=step4, xshift=4cm] {$\Delta = 0$};
        \node (step7) [process, below of=step6, xshift=-3cm] {Wypisz \break $x = -\frac{b}{2a}$};
        \node (step8) [process, below of=step6, xshift=3cm] {Wypisz\break $x_1 = \frac{-b-\Delta}{2a}$ \break $x_1 = \frac{-b+\Delta}{2a}$};
        \node (step9) [startstop, below of=step5, yshift=-1.8cm] {Stop};
        \node (step10) [startstop, below of=step7, yshift=-0.3cm] {Stop};
        \node (step11) [startstop, below of=step8, yshift=-0.3cm] {Stop};
        \draw[arrow] (step1) -- (step2);
        \draw[arrow] (step2) -- (step3);
        \draw[arrow] (step3) -- (step4);
        \draw[arrow] (step4) -| node[at start, anchor=south east] {Tak} (step5);
        \draw[arrow] (step5) -- (step9);
        \draw[arrow] (step4) -| node[at start, anchor=south west] {Nie} (step6);
        \draw[arrow] (step6) -| node[at start, anchor=south east] {Tak} (step7);
        \draw[arrow] (step7) -- (step10);
        \draw[arrow] (step6) -| node[at start, anchor=south west] {Nie} (step8);
        \draw[arrow] (step8) -- (step11);
    \end{tikzpicture}
    \caption{Schemat blokowy algorytmu wyznaczania pierwiastków równania kwadratowego \newline ax2 + bx + c = 0.}
    \label{fig:2dchart}
\end{figure}

\end{document}


```
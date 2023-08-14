![lab2_b](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%202/lab2_b.pdf)


![lab_2b](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%202/lab_2b.pdf)


```latex
\input{header}
\begin{document}
\frontpage{%
    Technologie Informacyjne% nazwa kursu
}{%
    Informatyka Techniczna% kierunek
}{%
    Wtorek TNP 7:30% termin
}{-}{-}{%
    Dawid Jabłoński 272970% dane osobowe
}{%
    https://www.overleaf.com/read/kpnczyxmwvgp% link do edytowalnej wersji projektu
}{\today}{%
    3% numer raportu
}
\pagestyle{empty}


\begin{table}[h]
    \centering
    \caption{Lista Obecności}
    \label{tab:tab1}
    \begin{tabularx}{\linewidth}{CCCCCCCCC}
        \toprule
        \multirow{2.5}{*}{L.p.} & \multicolumn{3}{c} {Student} & \multicolumn{5}{c}{Obecności}\\
        \cmidrule(r){2-4} \cmidrule(l){5-9}
         & Imię & Nazwisko & Nr~indeksu & 2.10 & 9.10 & 15.10 & 17.10 & 20.10\\
         \midrule
         1 & Adam & Abacki & 123 432 & – & + & + &  &  \\
         2 & Bartosz & Babacki & 123 532 & + & + & - &  &  \\
         3 & Cezary & Cabacki & 123 632 & – & + & + &  &  \\
         4 & Dawid & Dabacki & 123 732 & – & + & + &  &  \\
         5 & Emil & Ebacki & 123 832 & + & z & - &  &  \\
         6 & Franek & Frabacki & 123 932 & – & + & + &  &  \\
         \bottomrule
    \end{tabularx}
\end{table}

\vfill

\begin{tabularx}{\linewidth}{LCR}
     \dotfill& &\dotfill  \\
     \centering Podpis prowadząceego & & \centering Podpis premiera
\end{tabularx}
\end{document}


```
![lab1_b_zadanie](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%201/lab1_b_zadanie.pdf)

![piemsek](https://tinyurl.com/y3dksfm3)

header.tex
```latex
\documentclass[polish,polish,a4paper]{article}
\usepackage[utf8]{inputenc}
\usepackage{polski}
\usepackage{tikz}
    \usetikzlibrary{
        arrows,
        shadows,
        shapes
    }
\usepackage{pgfplots}
\usepackage[margin = 1.in]{geometry}
\usepackage{subcaption}
\usepackage[export]{adjustbox}
\usepackage{hyperref}
\usepackage{tabularx}
\usepackage{mathtools}
\usepackage{multirow}
\usepackage{array}
\usepackage{hhline}
\usepackage{url}
\pgfplotsset{compat=1.16}
\newcommand{\name}[1]{\sffamily\bfseries\scriptsize #1}

\newcommand{\frontpage}[9]{
%% #1 - nazwa kursu
%% #2 - kierunek 
%% #3 - termin 
%% #4 - temat 
%% #5 - problem
%% #6 - skład grupy
%% #7 - brak
%% #8 - data
%% #9 - nr raportu
\noindent
\begin{tabularx}{\textwidth}{@{}X@{}l@{}}
    \begin{tabular}[t]{||m{0.5\textwidth}|m{0.25\textwidth}||}
        \hhline{|t:==:t|}
        \multicolumn{2}{||c||}{}\\
        \multicolumn{2}{||c||}{{\LARGE #1}}\\
        \multicolumn{2}{||c||}{}\\
        \hhline{||--||}
        \name{Kierunek} & \name{Termin}\\
        \textit{#2} & \textit{#3} \\
        \hhline{||--||}
        %\name{Imię, nazwisko, numer albumu} & \name{Nr laboratorium}\\
        %\textit{#6} & \textit{#5} \\
        \name{Imię, nazwisko, numer albumu} & \name{Data}\\
        \textit{#6} & \textit{#8} \\
        \hhline{||--||}
        %\name{Link do projektu} & \name{Data}\\
        %\url{#7} & \textit{#8} \\
        \multicolumn{2}{||l||}{\name{Link do projektu}} \\
        \multicolumn{2}{||l||}{\url{#7}} \\
        \hhline{|b:==:b|}
    \end{tabular}
    &
    \includegraphics[width=2.25cm,valign=T]{PWr.png}
\end{tabularx}
\vspace{.5cm}

\begin{center}
    \LARGE \textsc{Raport #9}
\end{center}

\noindent\rule[0.5cm]{\textwidth}{1pt}
}
```

main.tex
```latex
\input{header}
\begin{document}
\frontpage{%
    Technologie Informacyjne% nazwa kursu
}{%
    Informatyka Techniczna% kierunek
}{%
    Wtorek TP 11:15% termin
}{-}{-}{%
    % dane osobowe
}{%
    https://www.overleaf.com/5852572962tmdfqcfdryvm% link do edytowalnej wersji projektu
}{\today}{%
1% numer raportu
}
\pagestyle{empty}
\begin{center}
    \Large \textbf{T}echnologie \textbf{I}nformacyjne
\end{center}
\section{Wprowadzenie}
Celem laboratorium jest zapoznanie się z systemem składania tekstu \LaTeX. W trakcie zajęć poznamywiele nowych możliwości.
\vspace{1.5cm}
\begin{equation}
    \Delta = b^2-4ac
\end{equation}

\section{Punkty, podpunkty itp.}
zdanie pomiędzy
\subsection{Takie tam}
\textit{Wyliczenia} stosujemy zawsze tam  gdzie  kolejność  ma  znaczenie,  np.:  lista  kroków,  a \textit{wypunktowanie} wtedy gdy wszystkie podpunkty mają taką samą wagę.

\begin{enumerate}
    \item Wyjdź z domu.
    \item Zrób zakupy:
    \begin{itemize}
        \item mleko,
        \item jajka.
    \end{itemize}
    \item Wróć do domu.
\end{enumerate}

\newpage
\begin{figure}[ht]
    \centering
    \includegraphics[width= 12cm,valign=T]{9c3fcf249124eee74a92bf48d4a2705c.jpg}
    \caption{źródło: \url{https://tinyurl.com/y3dksfm3}}%
    width=12cm
\end{figure}

\section{Zbliżamy się do końca}
Wzór na pole koła $\pi r^2 $ i coś jeszcze $C_{max}$.

\vfill
\centering 
koniec

\end{document}


```

![lab1_b](/Notatki/Semestr%201/Technologie%20informacyjne/Labolatoria/Labolatoria%201/lab1_b.pdf)
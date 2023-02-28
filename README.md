![Repo Size](https://img.shields.io/github/repo-size/Xederro/Studia?style=for-the-badge)
[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/A0A8GJFDV)

Zalecamy zapoznanie się z:
[[LICENSE]]
[[CONTRIBUTING]]
[[CODE_OF_CONDUCT]]

# Studia
## Spis treści
### Semestr 1  
1. [[Algebra liniowa z geometrą analityczną]]  
2. [[Analiza matematyczna 1.2A]]  
3. [[Etyka inżynierka]]  
4. [[Filozofia]]  
5. [[Notatki/Miernictwo w informatyce i telekomunikacji/Wykłady/Wykłady|Miernictwo w informatyce i telekomunikacji - Wykłady]]  
6. [[Podstawy programowania]]  
7. [[Technologie informacyjne]]  
8. [[Własność intelektualna i prawo autorskie]]  

### Semestr 2
1. [[Algebra liniowa 2]]
2. [[Analiza matematyczna 2.3A]]
3. [[Fizyka 1.1A]]
4. [[Matematyka dyskretna]]
5. [[Notatki/Miernictwo w informatyce i telekomunikacji/Labolatoria/Labolatoria|Miernictwo w informatyce i telekomunikacji - Labolatoria]]
6. [[Podstawy automatyki i robotyki]]
7. [[Programowanie obiektowe]]
8. [[Rachunek prawdopodobieństwa]]
9. [[Teoria systemów]]

[[Inne]]

## Przydatne
>[!info]
>![[Sylabus.pdf|Sylabus]]

>[!info]
>[[Sylabus.pdf|Sylabus]]
>[[symbols.pdf|Symbole]]


Tworzenie folderów (batch):
```run-bash
chcp 65001

for /l %%x in (1, 1, 11) do (
   mkdir "Wykłady/Wykład %%x"
   echo !>>"Wykłady/Wykład %%x/Wykład %%x.md"
)

for /l %%x in (1, 1, 11) do (
   mkdir "Labolatoria/Labolatoria %%x"
   echo !>>"Labolatoria/Labolatoria %%x/Labolatoria %%x.md"
)

#for /l %%x in (1, 1, 11) do (
#   mkdir "Ćwiczenia/Ćwiczenia %%x"
#   echo !>>"Ćwiczenia/Ćwiczenia %%x/Ćwiczenia %%x.md"
#)
```

![Repo Size](https://img.shields.io/github/repo-size/Xederro/Studia?style=for-the-badge)
[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/A0A8GJFDV)

#### Pobieranie

```bash
  git clone https://github.com/xederro/Studia.git --depth 1 && cp ./Studia/hooks/** ./Studia/.git/hooks/
```

Dodatkowo na linuxie należy nadać hookowi prawa do egzekucji

```bash
  chmod a+x ./.git/hooks/pre-commit
```

Zalecamy zapoznanie się z:
[LICENSE](/LICENSE.md)
[CONTRIBUTING](/CONTRIBUTING.md)
[CODE_OF_CONDUCT](/CODE_OF_CONDUCT.md)

# Studia

## Spis treści

### [Semestr 1](/Notatki/Semestr%201/Semestr%201.md)

### [Semestr 2](/Notatki/Semestr%202/Semestr%202.md)

### [Semestr 3](/Notatki/Semestr%203/Semestr%203.md)

### [Semestr 4](/Notatki/Semestr%204/Semestr%204.md)

### [Semestr 5](/Notatki/Semestr%205/Semestr%205.md)

### [Inne](/Notatki/Inne/Inne.md)

## Średnia

```dataviewjs
for (let group of dv.pages().where(p => p["typ"] == "GK").where(p => p["semestr"] != 5).groupBy(p => p.semestr)) {
 let sum = 0;
 group.rows.forEach(x=>sum+=Number(x.ects)*Number(x.ocena))
 dv.header(3, "Semestr " + group.key + ": " + (sum/30).toFixed(3));
}
```

```dataviewjs
let sum = 0;
let semestrCount = 1;
dv.pages()
 .where(p => p["typ"] == "GK")
 .where(p => p["semestr"] !== 5)
 .forEach(x=>{
  sum+=x.ects*x.ocena
  if (x.semestr > semestrCount) semestrCount = x.semestr
 })
dv.header(3, "Studia: " + (sum/(30*semestrCount)).toFixed(3));
```

## Przydatne

>[!Utils]
>[bin](/bin/bin.md)
>[hooks](/hooks/hooks.md)

>[!info]
>![Sylabus](Sylabus.pdf)

>[!info]
>[Sylabus](Sylabus.pdf)
>[Symbole](symbols.pdf)

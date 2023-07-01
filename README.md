![Repo Size](https://img.shields.io/github/repo-size/Xederro/Studia?style=for-the-badge)
[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/A0A8GJFDV)

Zalecamy zapoznanie się z:
[[LICENSE]]
[[CONTRIBUTING]]
[[CODE_OF_CONDUCT]]

# Studia
## Spis treści
### [[Notatki/Semestr 1/Semestr 1|Semestr 1]]
### [[Notatki/Semestr 2/Semestr 2|Semestr 2]]

### [[Notatki/Inne/Inne|Inne]]

## Średnia
```dataviewjs
for (let group of dv.pages().where(p => p["typ"] == "GK").groupBy(p => p.semestr)) {
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
	.forEach(x=>{
		sum+=x.ects*x.ocena
		if (x.semestr > semestrCount) semestrCount = x.semestr
	})
dv.header(3, "Studia: " + (sum/(30*semestrCount)).toFixed(3));
```

## Przydatne
>[!info]
>![[Sylabus.pdf|Sylabus]]

>[!info]
>[[Sylabus.pdf|Sylabus]]
>[[symbols.pdf|Symbole]]
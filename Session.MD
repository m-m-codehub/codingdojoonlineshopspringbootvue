# 🧠 Session Einstieg in Vue mit Onlineshop-Bsp

## 🎯 Ziel der Session
- Verständnis zu Vue & Quasar festigen
- die wichtigsten Konzepte in eigenen Worten verstehen können
- direkt praktisch Vue-Komponenten anwenden (z. B. Kundenformular)
- begreifen, **warum** Komponenten, `ref()` und `v-model` so nützlich sind

---

## 🗂️ Aufbau (ca. 60–75 Min)

### 1. Einstieg mit Vue Tutorial (10 - 15 Min)

**Diskussionsfragen:**
- Was habt ihr aus der Vue-Übung mitgenommen?
- Was war leicht zu verstehen – was hat euch verwirrt?
- Welche Vue-Konzepte habt ihr schon genutzt?
- [mit Vue Tutorial](https://vuejs.org/tutorial/#step-1):
    - was ist der Unterschied zwischen ref() & reactive() ?
    - was macht v-model ? 
---


### 2. Quasar + Vue Projekt von Scratch (5–10 Min)
**Ziel:** Setup & Struktur verstehen

siehe Confluence-Tutorial

🗂️ Projektstruktur zeigen:
- `pages/`, `components/`, `App.vue`, `quasar.config.js`
- Wie man Seiten/Komponenten erstellt und einbindet

---

### 3. Einstieg in Onlineshop-Bsp: Erweiterung um Formular für neuen Kunden (40 Min)

#### ✅ Backend erweitern: was brauchen wir?
- POST Methode in Controller, speichern im Service
```java
@PostMapping
    public Kunde create(@RequestBody Kunde kunde) {
        return service.save(kunde);
    }

    public Kunde save(Kunde kunde) {
            return repository.save(kunde);
        }
```

- Achtung: wer soll die Kunden ID generieren? --> DB!
```java
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kundennummer;
```
Generation Strategies: Table, Sequence, UUID, ...

---

### 4. Komponente NeuerKundeForm analysieren (20–30 Min)

- **Analysiere den Code der Komponente `NeuerKundeForm.vue`, die dazu dient, einen neuen Kunden anzulegen**
- du findest diese im **branch session/vueeinstieg im Projekt Onlineshop** 

**Themen:**
- `ref()` für das Modell
- `v-model` an Inputs
- `@submit.prevent`
- `fetch()` mit POST
- `$q.notify()`
- `emit('neuHinzugefügt')` → Kommunikation mit Elternkomponente


**Reflexionsfragen:**
- Warum brauchen wir `ref`?
- Warum ist das Formular ausgelagert?
- Wie kommt der neue Kunde in die Übersicht?

---

### 5. Abschluss / Feedback (5 Min)

**Fragen:**
- Was hast du heute neu verstanden?
- Was traust du dir jetzt im Vue-Projekt zu?
- Was war (noch) schwer nachvollziehbar?

---

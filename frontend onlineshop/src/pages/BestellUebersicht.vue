<template>
    <q-page padding>
      <h2>Bestellübersicht</h2>
  
      <q-card v-for="bestellung in bestellungen" :key="bestellung.id" class="q-mb-lg shadow-2">
        <q-card-section>
          <div class="text-h6 q-mb-xs">🧾 Bestellung #{{ bestellung.id }}</div>
          <div class="text-subtitle2">
            👤 {{ bestellung.kunde }}<br />
            📅 {{ formatDatum(bestellung.bestelldatum) }}
          </div>
        </q-card-section>
  
        <q-separator />
  
        <q-card-section>
          <q-markup-table flat bordered dense>
            <thead>
              <tr>
                <th>Artikel</th>
                <th style="width: 100px; text-align: right">Menge</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(pos, index) in bestellung.positionen" :key="index">
                <td>{{ pos.artikel }}</td>
                <td class="text-right">
                  <q-badge color="primary" align="top">× {{ pos.menge }}</q-badge>
                </td>
              </tr>
            </tbody>
          </q-markup-table>
        </q-card-section>
      </q-card>
    </q-page>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  
  const bestellungen = ref([]);
  
  const loadBestellungen = async () => {
    try {
      const res = await fetch('http://localhost:8080/bestellungen');
      bestellungen.value = await res.json();
    } catch (err) {
      console.error('Fehler beim Laden der Bestellungen:', err);
    }
  };
  
  const formatDatum = (isoString) => {
    if (!isoString) return '-';
    const date = new Date(isoString);
    return date.toLocaleDateString('de-DE', {
      day: '2-digit', month: '2-digit', year: 'numeric'
    });
  };
  
  onMounted(loadBestellungen);
  </script>
  
  <style scoped>
  .q-card {
    max-width: 700px;
    margin: auto;
  }
  </style>
  
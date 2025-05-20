<template>
    <q-page padding>
      <h2>Artikelübersicht</h2>
  
      <q-table
        :rows="artikel"
        :columns="columns"
        row-key="artikelnummer"
        flat
        bordered
      />
    </q-page>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  
  const artikel = ref([]);
  
  const columns = [
    { name: 'artikelnr', label: 'Artikel-Nr.', field: 'artikelnummer', align: 'left' },
    { name: 'bezeichnung', label: 'Bezeichnung', field: 'bezeichnung', align: 'left' },
    { name: 'preis', label: 'Preis', field: 'preis', align: 'right', format: val => `${val.toFixed(2)} €` },
    { name: 'artikelgruppe', label: 'Artikelgruppe', field: 'artikelgruppe', align: 'left' }
  ];
  
  const loadArtikel = async () => {
    try {
      const res = await fetch('http://localhost:8080/artikel');
      artikel.value = await res.json();
    } catch (err) {
      console.error('Fehler beim Laden der Artikel:', err);
    }
  };
  
  onMounted(loadArtikel);
  </script>
  
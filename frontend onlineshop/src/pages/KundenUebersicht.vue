<template>
  <q-page padding>
    <h2>Kundenübersicht</h2>

    <q-table
      :rows="kunden"
      :columns="columns"
      row-key="kundennummer"
      flat
      bordered
    >
      <template v-slot:body-cell-aktionen="props">
        <q-td align="center">
          <q-btn
            size="sm"
            icon="edit"
            color="primary"
            flat
            @click="editKunde(props.row)"
          />
        </q-td>
      </template>
    </q-table>

    <NeuerKundeForm @NeuHinzugefuegt="loadKunden" />

    <q-dialog v-model="dialogVisible">
      <q-card>
        <q-card-section>
          <div class="text-h6">Kundendaten bearbeiten</div>
        </q-card-section>

        <q-card-section>
          <q-input v-model="selectedKunde.nachname" label="Nachname" />
          <q-input v-model="selectedKunde.vorname" label="Vorname" />
          <q-input v-model="selectedKunde.strasse" label="Straße" />
          <q-input v-model="selectedKunde.plz" label="PLZ" />
          <q-input v-model="selectedKunde.ort" label="Ort" />
        </q-card-section>

        <q-card-actions align="right">
          <q-btn flat label="Abbrechen" v-close-popup />
          <q-btn flat label="Speichern" color="primary" @click="saveKunde" />
        </q-card-actions>
      </q-card>
    </q-dialog>
  </q-page>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useQuasar } from 'quasar';
import NeuerKundeForm from 'src/components/NeuerKundeForm.vue';


const $q = useQuasar();
const kunden = ref([]);
const dialogVisible = ref(false);
const selectedKunde = ref(null);

const columns = [
  { name: 'kundennummer', label: 'Kundennr.', field: 'kundennummer', align: 'left' },
  { name: 'nachname', label: 'Nachname', field: 'nachname', align: 'left' },
  { name: 'vorname', label: 'Vorname', field: 'vorname', align: 'left' },
  { name: 'strasse', label: 'Straße', field: 'strasse', align: 'left' },
  { name: 'plz', label: 'PLZ', field: 'plz', align: 'left' },
  { name: 'ort', label: 'Ort', field: 'ort', align: 'left' },
  { name: 'aktionen', label: 'Aktionen', field: 'aktionen', align: 'center' }
];

const loadKunden = () => {
  fetch('http://localhost:8080/kunden')
    .then(res => res.json())
    .then(data => kunden.value = data);
};

const editKunde = (kunde) => {
  selectedKunde.value = { ...kunde };
  dialogVisible.value = true;
};

const saveKunde = () => {
  fetch(`http://localhost:8080/kunden/${selectedKunde.value.kundennummer}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(selectedKunde.value)
  })
    .then(() => {
      dialogVisible.value = false;
      loadKunden();
      $q.notify({ type: 'positive', message: 'Kunde gespeichert' });
    });
};

onMounted(loadKunden);
</script>

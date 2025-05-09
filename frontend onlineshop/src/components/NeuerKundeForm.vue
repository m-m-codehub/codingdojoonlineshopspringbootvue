<template>
  <!-- siehe Step 6: Conditional Rendering -->
  <q-banner v-if="erfolg" class="bg-green-2 text-green-10 q-mb-md">
    ✅ Kunde wurde erfolgreich gespeichert!
  </q-banner>

  <q-expansion-item
    expand-separator
    label="➕ Neuen Kunden hinzufügen"
    icon="person_add"
    class="q-mt-lg"
  >
    <!-- siehe Step 5: Form Bindings -->
    <q-form @submit.prevent="submitKunde" class="q-gutter-md">
      <!-- siehe Step 5: v-model -->
      <q-input v-model.trim="kunde.vorname" label="Vorname" outlined required />

      <!-- siehe Step 5: v-model -->
      <q-input v-model.trim="kunde.nachname" label="Nachname" outlined required />

      <!-- siehe Step 5: v-model -->
      <q-input v-model="kunde.strasse" label="Straße" outlined />

      <!-- siehe Step 6: v-model.number -->
      <q-input v-model.number="kunde.plz" label="PLZ" type="number" outlined />

      <!-- siehe Step 5: v-model -->
      <q-input v-model="kunde.ort" label="Ort" outlined />

      <!-- siehe Step 6: Conditional Rendering (disable Button) -->
      <q-btn
        type="submit"
        label="Speichern"
        color="primary"
        :disable="!kunde.vorname || !kunde.nachname"
      />
    </q-form>
  </q-expansion-item>
</template>

<script setup>
import { ref } from 'vue';
import { useQuasar } from 'quasar';

const $q = useQuasar();

// siehe Step 2: ref()
const kunde = ref({
  vorname: '',
  nachname: '',
  strasse: '',
  plz: '',
  ort: ''
});

// siehe Step 6: Conditional Rendering (für Feedbackanzeige)
const erfolg = ref(false);

// siehe Step 13: Emits
const emit = defineEmits(['neuHinzugefügt']);

// siehe Step 4: Event Listeners (`@submit.prevent`)
const submitKunde = () => {
  fetch('http://localhost:8080/kunden', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(kunde.value)
  })
    .then(res => {
      if (!res.ok) throw new Error('Fehler beim Anlegen');
      return res.json();
    })
    .then(() => {
      erfolg.value = true;
      $q.notify({ type: 'positive', message: 'Kunde hinzugefügt' });
      emit('neuHinzugefuegt');

      // Reset der Felder
      Object.assign(kunde.value, {
        vorname: '',
        nachname: '',
        strasse: '',
        plz: '',
        ort: ''
      });
    })
    .catch(err => {
      $q.notify({ type: 'negative', message: err.message });
    });
};
</script>

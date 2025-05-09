<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn flat dense round icon="menu" @click="toggleLeftDrawer" />
        <q-toolbar-title>Onlineshop</q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" show-if-above bordered>
      <q-list>
        <q-item-label header>Navigation</q-item-label>

        <q-item clickable to="/" @click="toggleLeftDrawer">
          <q-item-section avatar><q-icon name="home" /></q-item-section>
          <q-item-section>Home</q-item-section>
        </q-item>

        <q-item clickable to="/kunden" @click="toggleLeftDrawer">
          <q-item-section avatar><q-icon name="people" /></q-item-section>
          <q-item-section>Kunden</q-item-section>
        </q-item>

        <q-item clickable to="/artikel" @click="toggleLeftDrawer">
          <q-item-section avatar><q-icon name="inventory" /></q-item-section>
          <q-item-section>Artikel</q-item-section>
        </q-item>


        <q-item clickable to="/bestellungen" @click="toggleLeftDrawer">
          <q-item-section avatar><q-icon name="local_shipping" /></q-item-section>
          <q-item-section>Bestellungen</q-item-section>
        </q-item>

      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script setup>
import { ref } from 'vue'
const leftDrawerOpen = ref(false)
const toggleLeftDrawer = () => {
  leftDrawerOpen.value = !leftDrawerOpen.value
}
</script>

const routes = [
  {
    path: "/",
    component: () => import("layouts/MainLayout.vue"),
    children: [
      { path: "/", component: () => import("pages/IndexPage.vue") },
      {
        path: "/kunden",
        component: () => import("pages/KundenUebersicht.vue"),
      },
      {
        path: "/artikel",
        component: () => import("pages/ArtikelUebersicht.vue"),
      },
      {
        path: "/bestellungen",
        component: () => import("pages/BestellUebersicht.vue"),
      },
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: "/:catchAll(.*)*",
    component: () => import("pages/ErrorNotFound.vue"),
  },
];

export default routes;

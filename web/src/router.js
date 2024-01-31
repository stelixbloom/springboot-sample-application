import { createRouter, createWebHistory } from 'vue-router';
import AppMenu from "./components/AppMenu.vue";
import AppList from "./components/AppList.vue";
import AppPerson from "./components/AppPerson.vue";
import AppRegister from "./components/AppRegister.vue";
import AppUpdate from "./components/AppUpdate.vue";
import AppDelete from "./components/AppDelete.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/menu",
            name: "menu",
            component: AppMenu
        },
        {
            path: "/list",
            name: "list",
            component: AppList
        },
        {
            path: "/person/:personId",
            name: "person",
            component: AppPerson
        },
        {
            path: "/register",
            name: "register",
            component: AppRegister
        },
        {
            path: "/update/:personId",
            name: "update",
            component: AppUpdate
        },
        {
            path: "/delete/:personId",
            name: "delete",
            component: AppDelete
        },
    ]
});

export default router;
import { createRouter , createWebHistory } from 'vue-router'
import MainLayOut from "../components/MainLayOut.vue";

const routes = [
    { path: '/', name: 'Main', component: MainLayOut },
];
const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
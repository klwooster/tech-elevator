import Vue from 'vue'
import Router from 'vue-router'
import auth from './auth'
import Dashboard from './views/Home.vue'
import Login from './views/Login.vue'
import Register from './views/Register.vue'
import ApplicantList from './views/ApplicantList.vue'
import ApplicantInfo from './views/ApplicantInfo.vue'
import CampRegistration from './views/CampRegistration.vue'
import Home from './views/CampHome.vue'
import ApplicationHistory from './views/ApplicationHistory.vue'
import CampDetails from './views/CampDetails.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    linkActiveClass: "selected",
    routes: [{
            path: '/dashboard',
            name: 'dashboard',
            component: Dashboard,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/login",
            name: "login",
            component: Login,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/register",
            name: "register",
            component: Register,
            meta: {
                requiresAuth: false
            },
        },
        {
            path: "/applicant-list",
            name: "applicantlist",
            component: ApplicantList,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/applicant-info/:applicantId",
            name: "applicantinfo",
            component: ApplicantInfo,
            params: true,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/camp-registration",
            name: "campregistration",
            component: CampRegistration,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/",
            name: "camphome",
            component: Home,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/application-history/:id",
            name: "applicationhistory",
            params: true,
            component: ApplicationHistory,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/camp-details/:campdetailsdata",
            name: "campdetails",
            params: true,
            component: CampDetails,
            meta: {
                requiresAuth: false
            }
        }
    ]
})

router.beforeEach((to, from, next) => {
    // Determine if the route requires Authentication
    const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
    const user = auth.getUser();

    // If it does and they are not logged in, send the user to "/login"
    if (requiresAuth && !user) {
        next("/login");
    } else {
        // Else let them go to their next destination
        next();
    }
});

export default router;
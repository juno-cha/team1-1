
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);



import BikeConditionView from "./components/BikeConditionView"
import BikeConditionViewDetail from "./components/BikeConditionViewDetail"
import DashboardView from "./components/DashboardView"
import DashboardViewDetail from "./components/DashboardViewDetail"
import PaymentHistoryManager from "./components/listers/PaymentHistoryCards"
import PaymentHistoryDetail from "./components/listers/PaymentHistoryDetail"

import RentManager from "./components/listers/RentCards"
import RentDetail from "./components/listers/RentDetail"

import ManagementManager from "./components/listers/ManagementCards"
import ManagementDetail from "./components/listers/ManagementDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [

            {
                path: '/bikeConditions',
                name: 'BikeConditionView',
                component: BikeConditionView
            },
            {
                path: '/bikeConditions/:id',
                name: 'BikeConditionViewDetail',
                component: BikeConditionViewDetail
            },
            {
                path: '/dashboards',
                name: 'DashboardView',
                component: DashboardView
            },
            {
                path: '/dashboards/:id',
                name: 'DashboardViewDetail',
                component: DashboardViewDetail
            },
            {
                path: '/paymentHistories',
                name: 'PaymentHistoryManager',
                component: PaymentHistoryManager
            },
            {
                path: '/paymentHistories/:id',
                name: 'PaymentHistoryDetail',
                component: PaymentHistoryDetail
            },

            {
                path: '/rents',
                name: 'RentManager',
                component: RentManager
            },
            {
                path: '/rents/:id',
                name: 'RentDetail',
                component: RentDetail
            },

            {
                path: '/managements',
                name: 'ManagementManager',
                component: ManagementManager
            },
            {
                path: '/managements/:id',
                name: 'ManagementDetail',
                component: ManagementDetail
            },



    ]
})

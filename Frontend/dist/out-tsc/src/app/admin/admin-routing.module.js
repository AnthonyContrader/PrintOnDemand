import { __decorate } from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { ClientComponent } from './client/client.component';
import { ItemComponent } from './item/item.component';
import { OrdersComponent } from './orders/orders.component';
/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri
 * (qui sotto sono indentati).
 *
 * @author Vittorio Valent
 *
 * @see AdminLayoutComponent
 *
 * @see layout
 */
var routes = [
    { path: 'admin-dashboard', component: AdminLayoutComponent, children: [
            { path: '', component: AdminDashboardComponent },
            { path: 'users', component: UsersComponent },
            { path: 'work-in-progress', component: WorkInProgressComponent },
            { path: 'client', component: ClientComponent },
            { path: 'item', component: ItemComponent },
            { path: 'orders', component: OrdersComponent }
        ] }
];
var AdminRoutingModule = /** @class */ (function () {
    function AdminRoutingModule() {
    }
    AdminRoutingModule = __decorate([
        NgModule({
            imports: [RouterModule.forChild(routes)],
            exports: [RouterModule]
        })
    ], AdminRoutingModule);
    return AdminRoutingModule;
}());
export { AdminRoutingModule };
//# sourceMappingURL=admin-routing.module.js.map
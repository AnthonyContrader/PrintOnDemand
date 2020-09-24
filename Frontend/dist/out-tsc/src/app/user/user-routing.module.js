import { __decorate } from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UsersComponent } from './users/users.component';
import { ClientComponent } from './client/client.component';
import { ItemComponent } from './item/item.component';
import { OrdersComponent } from './orders/orders.component';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
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
    { path: 'user-dashboard', component: UserLayoutComponent, children: [
            { path: '', component: UserDashboardComponent },
            { path: 'users', component: UsersComponent },
            //{ path: 'work-in-progress', component: WorkInProgressComponent},
            { path: 'client', component: ClientComponent },
            { path: 'item', component: ItemComponent },
            { path: 'orders', component: OrdersComponent }
        ] }
];
var UserRoutingModule = /** @class */ (function () {
    function UserRoutingModule() {
    }
    UserRoutingModule = __decorate([
        NgModule({
            imports: [RouterModule.forChild(routes)],
            exports: [RouterModule]
        })
    ], UserRoutingModule);
    return UserRoutingModule;
}());
export { UserRoutingModule };
//# sourceMappingURL=user-routing.module.js.map
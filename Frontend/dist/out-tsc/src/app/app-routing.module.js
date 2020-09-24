import { __decorate } from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
/**
 * Questo è un modulo di routing. Essendo il modulo principale deve UNICAMENTE
 * eseguire il redirect sul persorso /login (modulo di login) e NON DEVE contenere
 * altri percorsi: questi vanno specificati nei vari sotto-moduli di routing.
 *
 * @see LoginRoutingModule
 *
 * @author Vittorio Valent
 */
var routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        NgModule({
            imports: [RouterModule.forRoot(routes)],
            exports: [RouterModule]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());
export { AppRoutingModule };
//# sourceMappingURL=app-routing.module.js.map
import { __decorate, __metadata } from "tslib";
import { Component } from '@angular/core';
/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
var AdminDashboardComponent = /** @class */ (function () {
    function AdminDashboardComponent() {
    }
    AdminDashboardComponent.prototype.ngOnInit = function () {
        this.user = JSON.parse(localStorage.getItem('currentUser'));
    };
    AdminDashboardComponent = __decorate([
        Component({
            selector: 'app-admin-dashboard',
            templateUrl: './admin-dashboard.component.html',
            styleUrls: ['./admin-dashboard.component.css']
        }),
        __metadata("design:paramtypes", [])
    ], AdminDashboardComponent);
    return AdminDashboardComponent;
}());
export { AdminDashboardComponent };
//# sourceMappingURL=admin-dashboard.component.js.map
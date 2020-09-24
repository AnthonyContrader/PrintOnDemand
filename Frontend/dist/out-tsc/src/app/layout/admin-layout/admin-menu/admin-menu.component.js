import { __decorate, __metadata } from "tslib";
import { Component } from '@angular/core';
import { Router } from '@angular/router';
var AdminMenuComponent = /** @class */ (function () {
    function AdminMenuComponent(router) {
        this.router = router;
        this.isUserCollapsed = false;
        this.isClientCollapsed = false;
        this.isAccountCollapsed = false;
        this.isItemCollapsed = false;
        this.isOrdersCollapsed = false;
    }
    AdminMenuComponent.prototype.ngOnInit = function () {
    };
    AdminMenuComponent.prototype.logout = function () {
        localStorage.clear();
        this.router.navigateByUrl('');
    };
    AdminMenuComponent.prototype.userscollapse = function () {
        if (this.isUserCollapsed === false) {
            this.isUserCollapsed = true;
        }
        else {
            this.isUserCollapsed = false;
        }
    };
    AdminMenuComponent.prototype.clientcollapse = function () {
        if (this.isClientCollapsed === false) {
            this.isClientCollapsed = true;
        }
        else {
            this.isClientCollapsed = false;
        }
    };
    AdminMenuComponent.prototype.itemcollapse = function () {
        if (this.isItemCollapsed === false) {
            this.isItemCollapsed = true;
        }
        else {
            this.isItemCollapsed = false;
        }
    };
    AdminMenuComponent.prototype.orderscollapse = function () {
        if (this.isOrdersCollapsed === false) {
            this.isOrdersCollapsed = true;
        }
        else {
            this.isOrdersCollapsed = false;
        }
    };
    AdminMenuComponent = __decorate([
        Component({
            selector: 'app-admin-menu',
            templateUrl: './admin-menu.component.html',
            styleUrls: ['./admin-menu.component.css']
        }),
        __metadata("design:paramtypes", [Router])
    ], AdminMenuComponent);
    return AdminMenuComponent;
}());
export { AdminMenuComponent };
//# sourceMappingURL=admin-menu.component.js.map
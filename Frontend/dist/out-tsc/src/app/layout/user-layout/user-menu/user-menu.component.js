import { __decorate, __metadata } from "tslib";
import { Component } from '@angular/core';
import { Router } from '@angular/router';
var UserMenuComponent = /** @class */ (function () {
    function UserMenuComponent(router) {
        this.router = router;
        this.isUserCollapsed = false;
        this.isClientCollapsed = false;
        this.isAccountCollapsed = false;
        this.isItemCollapsed = false;
        this.isOrdersCollapsed = false;
    }
    UserMenuComponent.prototype.ngOnInit = function () {
    };
    UserMenuComponent.prototype.logout = function () {
        localStorage.clear();
        this.router.navigateByUrl('');
    };
    UserMenuComponent.prototype.userscollapse = function () {
        if (this.isUserCollapsed === false) {
            this.isUserCollapsed = true;
        }
        else {
            this.isUserCollapsed = false;
        }
    };
    UserMenuComponent.prototype.clientcollapse = function () {
        if (this.isClientCollapsed === false) {
            this.isClientCollapsed = true;
        }
        else {
            this.isClientCollapsed = false;
        }
    };
    UserMenuComponent.prototype.itemcollapse = function () {
        if (this.isItemCollapsed === false) {
            this.isItemCollapsed = true;
        }
        else {
            this.isItemCollapsed = false;
        }
    };
    UserMenuComponent.prototype.orderscollapse = function () {
        if (this.isOrdersCollapsed === false) {
            this.isOrdersCollapsed = true;
        }
        else {
            this.isOrdersCollapsed = false;
        }
    };
    UserMenuComponent = __decorate([
        Component({
            selector: 'app-user-menu',
            templateUrl: './user-menu.component.html',
            styleUrls: ['./user-menu.component.css']
        }),
        __metadata("design:paramtypes", [Router])
    ], UserMenuComponent);
    return UserMenuComponent;
}());
export { UserMenuComponent };
//# sourceMappingURL=user-menu.component.js.map
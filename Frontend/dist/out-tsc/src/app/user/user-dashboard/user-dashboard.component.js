import { __decorate, __metadata } from "tslib";
import { Component } from '@angular/core';
var UserDashboardComponent = /** @class */ (function () {
    function UserDashboardComponent() {
    }
    UserDashboardComponent.prototype.ngOnInit = function () {
        this.user = JSON.parse(localStorage.getItem('currentUser'));
    };
    UserDashboardComponent = __decorate([
        Component({
            selector: 'app-user-dashboard',
            templateUrl: './user-dashboard.component.html',
            styleUrls: ['./user-dashboard.component.css']
        }),
        __metadata("design:paramtypes", [])
    ], UserDashboardComponent);
    return UserDashboardComponent;
}());
export { UserDashboardComponent };
//# sourceMappingURL=user-dashboard.component.js.map
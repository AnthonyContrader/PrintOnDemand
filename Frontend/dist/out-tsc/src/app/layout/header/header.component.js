import { __decorate, __metadata } from "tslib";
import { Component } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
var HeaderComponent = /** @class */ (function () {
    function HeaderComponent() {
        this.user = new UserDTO;
    }
    HeaderComponent.prototype.ngOnInit = function () {
        this.user = JSON.parse(localStorage.getItem('currentUser'));
    };
    HeaderComponent = __decorate([
        Component({
            selector: 'app-header',
            templateUrl: './header.component.html',
            styleUrls: ['./header.component.css']
        }),
        __metadata("design:paramtypes", [])
    ], HeaderComponent);
    return HeaderComponent;
}());
export { HeaderComponent };
//# sourceMappingURL=header.component.js.map
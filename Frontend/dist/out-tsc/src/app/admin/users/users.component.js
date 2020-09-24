import { __decorate, __metadata } from "tslib";
import { Component } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
var UsersComponent = /** @class */ (function () {
    function UsersComponent(service) {
        this.service = service;
        this.usertoinsert = new UserDTO();
    }
    UsersComponent.prototype.ngOnInit = function () {
        this.getUsers();
    };
    UsersComponent.prototype.getUsers = function () {
        var _this = this;
        this.service.getAll().subscribe(function (users) { return _this.users = users; });
    };
    UsersComponent.prototype.delete = function (user) {
        var _this = this;
        this.service.delete(user.id).subscribe(function () { return _this.getUsers(); });
    };
    UsersComponent.prototype.update = function (user) {
        var _this = this;
        this.service.update(user).subscribe(function () { return _this.getUsers(); });
    };
    UsersComponent.prototype.insert = function (user) {
        var _this = this;
        this.service.insert(user).subscribe(function () { return _this.getUsers(); });
    };
    UsersComponent.prototype.clear = function () {
        this.usertoinsert = new UserDTO();
    };
    UsersComponent = __decorate([
        Component({
            selector: 'app-users',
            templateUrl: './users.component.html',
            styleUrls: ['./users.component.css']
        }),
        __metadata("design:paramtypes", [UserService])
    ], UsersComponent);
    return UsersComponent;
}());
export { UsersComponent };
//# sourceMappingURL=users.component.js.map
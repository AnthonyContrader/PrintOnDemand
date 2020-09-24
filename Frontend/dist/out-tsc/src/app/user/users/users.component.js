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
        this.users = new UserDTO();
        this.getUsers();
        this.user = JSON.parse(localStorage.getItem('currentUser'));
    };
    UsersComponent.prototype.getUsers = function () {
        var _this = this;
        this.service.getAll().subscribe(function (users) {
            for (var _i = 0, users_1 = users; _i < users_1.length; _i++) {
                var us = users_1[_i];
                if (us.id == _this.user.id)
                    _this.users = us;
            }
        });
    };
    /*delete(user: UserDTO) {
      this.service.delete(user.id).subscribe(() => this.getUsers());
    }*/
    UsersComponent.prototype.update = function (user) {
        var _this = this;
        this.service.update(user).subscribe(function () { return _this.getUsers(); });
    };
    /*insert(user: UserDTO) {
      this.service.insert(user).subscribe(() => this.getUsers());
    }*/
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
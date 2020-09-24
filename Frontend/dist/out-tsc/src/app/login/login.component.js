import { __decorate, __metadata } from "tslib";
import { Component } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
//import { userInfo } from 'os';
var LoginComponent = /** @class */ (function () {
    //userlogged:UserDTO;
    function LoginComponent(service, router) {
        this.service = service;
        this.router = router;
    }
    LoginComponent.prototype.ngOnInit = function () {
        this.isinsert = false;
    };
    LoginComponent.prototype.login = function (f) {
        var _this = this;
        this.userDTO = new UserDTO();
        this.loginDTO = new LoginDTO(f.value.username, f.value.password);
        this.service.login(this.loginDTO).subscribe(function (user) {
            localStorage.setItem("currentUser", JSON.stringify(user));
            switch (user.usertype) {
                case "ADMIN": {
                    _this.router.navigate(['/admin-dashboard']);
                    break;
                }
                case "USER": {
                    _this.router.navigate(['/user-dashboard']);
                    break;
                }
                default:
                    alert("Username o password errati");
                //this.router.navigate(['/login']);
            }
        });
    };
    LoginComponent.prototype.signup = function (f) {
        var _this = this;
        this.userDTO = new UserDTO();
        this.userDTO.username = f.value.username;
        this.userDTO.password = f.value.password;
        this.userDTO.usertype = "USER";
        this.service.insert(this.userDTO).subscribe(function () { return _this.isinsert = true; });
    };
    LoginComponent = __decorate([
        Component({
            selector: 'app-login',
            templateUrl: './login.component.html',
            styleUrls: ['./login.component.css']
        }),
        __metadata("design:paramtypes", [UserService, Router])
    ], LoginComponent);
    return LoginComponent;
}());
export { LoginComponent };
//# sourceMappingURL=login.component.js.map
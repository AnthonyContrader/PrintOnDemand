import { __decorate, __extends, __metadata } from "tslib";
import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
/**
 * I service sono decorati da @Injectable.
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 *
 * @author Vittorio Valent
 *
 * @see AbstractService
 */
var UserService = /** @class */ (function (_super) {
    __extends(UserService, _super);
    function UserService(http) {
        var _this = _super.call(this, http) || this;
        _this.type = 'utenti';
        _this.port = '5001';
        _this.nome = '';
        return _this;
    }
    UserService.prototype.test = function () {
        var utenti;
        return this.http.get('https://localhost:5001/api/utenti', utenti);
    };
    UserService.prototype.auth = function () {
        var user = JSON.parse(localStorage.getItem('currentUser'));
        if (user) {
            return 'Bearer ' + user.authorities;
        }
        else {
            return '';
        }
    };
    UserService.prototype.login = function (login) {
        return this.http.post('https://localhost:5001/api/login', login);
    };
    UserService.prototype.userLogged = function (username) {
        console.log('qua: ', this.auth());
        console.log(this.auth());
        return this.http.get('http://localhost:8080/api/users/' + username, {
            headers: {
                Authorization: this.auth()
            }
        });
    };
    UserService.prototype.insert = function (dto) {
        return this.http.post('https://localhost:' + this.port + '/api/utenti', dto);
    };
    UserService = __decorate([
        Injectable({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [HttpClient])
    ], UserService);
    return UserService;
}(AbstractService));
export { UserService };
//# sourceMappingURL=user.service.js.map
import { __decorate, __extends, __metadata } from "tslib";
import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
var ClientService = /** @class */ (function (_super) {
    __extends(ClientService, _super);
    function ClientService(http) {
        var _this = _super.call(this, http) || this;
        _this.type = 'clienti';
        _this.port = '5001';
        _this.nome = '';
        return _this;
    }
    //da impostare
    ClientService.prototype.getAllByUtentiId = function (id) {
        return this.http.get('https://localhost:' + this.port + '/api/' + this.type + '/utenti/' + id, {
            headers: {
                Authorization: this.auth()
            }
        });
    };
    ClientService = __decorate([
        Injectable({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [HttpClient])
    ], ClientService);
    return ClientService;
}(AbstractService));
export { ClientService };
//# sourceMappingURL=client.service.js.map
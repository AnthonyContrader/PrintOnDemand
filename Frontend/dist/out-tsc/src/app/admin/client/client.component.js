import { __decorate, __metadata } from "tslib";
import { Component } from '@angular/core';
//import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { ClientService } from 'src/service/client.service';
import { ClientDTO } from 'src/dto/clientdto';
var ClientComponent = /** @class */ (function () {
    function ClientComponent(service) {
        this.service = service;
        this.isselected = false;
        this.clienttoinsert = new ClientDTO();
    }
    ClientComponent.prototype.ngOnInit = function () {
        this.clear();
        this.getClients();
    };
    ClientComponent.prototype.getClients = function () {
        var _this = this;
        this.service.getAll().subscribe(function (clients) { return _this.clients = clients; });
    };
    ClientComponent.prototype.delete = function (client) {
        var _this = this;
        this.service.delete(client.id).subscribe(function () { return _this.getClients(); });
    };
    ClientComponent.prototype.update = function (client) {
        var _this = this;
        this.service.update(client).subscribe(function () { return _this.getClients(); });
    };
    ClientComponent.prototype.insert = function (client) {
        var _this = this;
        client.iduser = Number(client.iduser);
        this.service.insert(client).subscribe(function () { return _this.getClients(); });
    };
    ClientComponent.prototype.clear = function () {
        this.clienttoinsert = new ClientDTO();
    };
    ClientComponent.prototype.close = function () {
        this.service = null;
    };
    ClientComponent.prototype.select = function (reviews) {
        this.selected = reviews;
        this.isselected = true;
        return this.selected;
    };
    ClientComponent.prototype.closeread = function () {
        this.isselected = false;
    };
    ClientComponent = __decorate([
        Component({
            selector: 'app-client',
            templateUrl: './client.component.html',
            styleUrls: ['./client.component.css']
        }),
        __metadata("design:paramtypes", [ClientService])
    ], ClientComponent);
    return ClientComponent;
}());
export { ClientComponent };
//# sourceMappingURL=client.component.js.map
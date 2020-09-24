import { __decorate, __extends, __metadata } from "tslib";
import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
//import { Observable } from 'rxjs';
var ItemService = /** @class */ (function (_super) {
    __extends(ItemService, _super);
    function ItemService(http) {
        var _this = _super.call(this, http) || this;
        _this.type = 'articoli';
        _this.port = '5001';
        _this.nome = '';
        return _this;
    }
    ItemService.prototype.upload = function (fd) {
        return this.http.post('https://localhost:5001/api/articoli/upload', fd);
    };
    ItemService.prototype.getImage = function (imageUrl) {
        return this.http.get('https://localhost:' + this.port + '/api/' + this.type + "/" + imageUrl, { responseType: 'blob' });
    };
    ItemService = __decorate([
        Injectable({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [HttpClient])
    ], ItemService);
    return ItemService;
}(AbstractService));
export { ItemService };
//# sourceMappingURL=articoli.service.js.map
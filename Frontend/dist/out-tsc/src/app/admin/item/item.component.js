import { __decorate, __metadata } from "tslib";
import { Component } from '@angular/core';
import { ItemService } from 'src/service/articoli.service';
import { ItemDTO } from 'src/dto/articolidto';
var ItemComponent = /** @class */ (function () {
    function ItemComponent(service) {
        this.service = service;
        this.isselected = false;
        this.itemtoinsert = new ItemDTO();
        this.searchVal = '';
        this.filteredItems = [];
    }
    ItemComponent.prototype.ngOnInit = function () {
        this.clear();
        this.getItems();
    };
    ItemComponent.prototype.getItems = function () {
        var _this = this;
        this.service.getAll().subscribe(function (items) { _this.items = items; _this.result = items; });
    };
    ItemComponent.prototype.delete = function (item) {
        var _this = this;
        this.service.delete(item.id).subscribe(function () { return _this.getItems(); });
    };
    ItemComponent.prototype.update = function (item) {
        var _this = this;
        this.service.update(item).subscribe(function () { return _this.getItems(); });
    };
    ItemComponent.prototype.insert = function (item) {
        var _this = this;
        this.service.insert(item).subscribe(function () { return _this.getItems(); });
    };
    ItemComponent.prototype.clear = function () {
        this.itemtoinsert = new ItemDTO();
    };
    ItemComponent.prototype.close = function () {
        this.service = null;
    };
    ItemComponent.prototype.select = function (reviews) {
        this.selected = reviews;
        this.isselected = true;
        return this.selected;
    };
    ItemComponent.prototype.closeread = function () {
        this.isselected = false;
    };
    ItemComponent.prototype.cutstring = function (str) {
        if ((str !== null) && (str.length > 35))
            return str.substring(34);
        else
            return str;
    };
    ItemComponent.prototype.checkSearchVal = function () {
        this.filteredItems = [];
        if (this.searchVal && this.searchVal !== '') {
            for (var _i = 0, _a = this.items; _i < _a.length; _i++) {
                var selecteditems = _a[_i];
                if (selecteditems.tipo.toLowerCase().startsWith(this.searchVal.toLowerCase())) {
                    this.filteredItems.push(selecteditems);
                }
                this.result = this.filteredItems.slice();
            }
        }
        else {
            this.result = this.items;
        }
    };
    ItemComponent = __decorate([
        Component({
            selector: 'app-item',
            templateUrl: './item.component.html',
            styleUrls: ['./item.component.css']
        }),
        __metadata("design:paramtypes", [ItemService])
    ], ItemComponent);
    return ItemComponent;
}());
export { ItemComponent };
//# sourceMappingURL=item.component.js.map
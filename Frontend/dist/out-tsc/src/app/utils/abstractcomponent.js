/**
 * Questa classe deinisce tutti i metodi di CRUD da usare nelle varie componenti (se lo richiedono).
 * Si osservi come, invece degli oggetti specifici, si fa riferimento a dto e dtolist.
 *
 * @author Vittorio Valent
 *
 * @param DTO
 *
 */
var AbstractCrudComponent = /** @class */ (function () {
    function AbstractCrudComponent(service) {
        this.service = service;
    }
    AbstractCrudComponent.prototype.getAll = function () {
        var _this = this;
        this.service.getAll().subscribe(function (dtolist) { return _this.dtolist = dtolist; });
    };
    AbstractCrudComponent.prototype.delete = function (id) {
        var _this = this;
        this.service.delete(id).subscribe(function () { return _this.getAll(); });
    };
    AbstractCrudComponent.prototype.update = function (user) {
        var _this = this;
        this.service.update(user).subscribe(function () { return _this.getAll(); });
    };
    AbstractCrudComponent.prototype.insert = function (dto) {
        var _this = this;
        this.service.insert(dto).subscribe(function () { return _this.getAll(); });
    };
    AbstractCrudComponent.prototype.select = function (dto) {
        this.selected = dto;
    };
    return AbstractCrudComponent;
}());
export { AbstractCrudComponent };
//# sourceMappingURL=abstractcomponent.js.map
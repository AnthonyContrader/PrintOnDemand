var AbstractUService = /** @class */ (function () {
    function AbstractUService(http) {
        this.http = http;
    }
    AbstractUService.prototype.auth = function () {
        var user = JSON.parse(localStorage.getItem('currentUser'));
        if (user) {
            console.log('Bearer ' + user.authorities);
            return 'Bearer ' + user.authorities;
        }
        else {
            return '';
        }
    };
    AbstractUService.prototype.getAllBy = function (id) {
        return this.http.get('http://localhost:' + this.port + '/' + this.type + id, {
            headers: {
                Authorization: this.auth()
            }
        });
    };
    AbstractUService.prototype.getAll = function () {
        return this.http.get('http://localhost:' + this.port + '/' + 'api' + '/' + this.type, {
            headers: {
                Authorization: this.auth()
            }
        });
    };
    AbstractUService.prototype.read = function (id) {
        return this.http.get('http://localhost:' + this.port + '/' + 'api' + '/' + this.type + id, {
            headers: {
                Authorization: this.auth()
            }
        });
    };
    AbstractUService.prototype.delete = function (id) {
        return this.http.delete('http://localhost:' + this.port + '/' + 'api' + '/' + this.type + '/' + id, {
            headers: {
                Authorization: this.auth()
            }
        });
    };
    AbstractUService.prototype.deleteU = function (login) {
        return this.http.delete('http://localhost:' + this.port + '/' + 'api' + '/' + this.type + '/' + login, {
            headers: {
                Authorization: this.auth()
            }
        });
    };
    AbstractUService.prototype.insert = function (dto) {
        return this.http.post('http://localhost:' + this.port + '/' + 'api' + '/' + this.type, dto, {
            headers: {
                Authorization: this.auth()
            }
        });
    };
    AbstractUService.prototype.update = function (dto) {
        return this.http.put('http://localhost:' + this.port + '/' + 'api' + '/' + this.type, dto, {
            headers: {
                Authorization: this.auth()
            }
        });
    };
    return AbstractUService;
}());
export { AbstractUService };
//# sourceMappingURL=abstractuservice.js.map
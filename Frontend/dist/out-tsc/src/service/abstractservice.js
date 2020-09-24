var AbstractService = /** @class */ (function () {
    function AbstractService(http) {
        this.http = http;
        this.port = '5001';
    }
    AbstractService.prototype.auth = function () {
        var user = JSON.parse(localStorage.getItem('currentUser'));
        if (user) {
            console.log('Bearer ' + user.authorities);
            return 'Bearer ' + user.authorities;
        }
        else {
            return '';
        }
    };
    AbstractService.prototype.getAllBy = function (id) {
        return this.http.get('https://localhost:' + this.port + '/api/' + this.type + id, {
            headers: {
                Authorization: this.auth()
            }
        });
    };
    AbstractService.prototype.getAll = function () {
        return this.http.get('https://localhost:' + this.port + '/api/' + this.type);
    };
    //la read non è prevista...la facciamo in un secondo momento forse
    AbstractService.prototype.read = function (id) {
        return this.http.get('https://localhost:' + this.port + '/' + this.nome + 'api/' + this.type + '/' + id, {
            headers: {
                Authorization: this.auth()
            }
        });
    };
    AbstractService.prototype.delete = function (id) {
        return this.http.delete('https://localhost:' + this.port + '/' + 'api' + '/' + this.type + '/' + id, {
            headers: {
                Authorization: this.auth()
            }
        });
    };
    /*
      deleteU(login: string): Observable<DTO> {
        return this.http.delete<DTO>('https://localhost:' + this.port + '/' + this.nome  + 'api' + '/' + this.type + '/' + login , {
          headers: {
            Authorization : this.auth()
          }
        });
      }
      */
    AbstractService.prototype.insert = function (dto) {
        return this.http.post('https://localhost:' + this.port + '/api/' + this.type + '/add', dto);
    };
    AbstractService.prototype.update = function (dto) {
        return this.http.put('https://localhost:' + this.port + '/' + 'api' + '/' + this.type + '/edit', dto /*, {
          headers: {
            Authorization : this.auth()
          }
        }*/);
    };
    return AbstractService;
}());
export { AbstractService };
//# sourceMappingURL=abstractservice.js.map
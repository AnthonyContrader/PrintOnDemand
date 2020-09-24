import { __decorate } from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './login.component';
/**
 * Routing del LoginModule. gestisce il routing per le pagine di login
 * (ed eventualmente di registrazione). Come ogni modulo di routing, viene
 * importato nel suo modulo.
 *
 * @see LoginModule
 *
 * @author Vittorio Valent
 */
var routes = [
    { path: 'login', component: LoginComponent }
];
var LoginRoutingModule = /** @class */ (function () {
    function LoginRoutingModule() {
    }
    LoginRoutingModule = __decorate([
        NgModule({
            imports: [RouterModule.forRoot(routes)],
            exports: [RouterModule]
        })
    ], LoginRoutingModule);
    return LoginRoutingModule;
}());
export { LoginRoutingModule };
//# sourceMappingURL=login-routing.module.js.map
import { __decorate } from "tslib";
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login.component';
import { LoginRoutingModule } from './login-routing.module';
import { FormsModule } from '@angular/forms';
/**
 * Questo modulo serve unicamente Login e Registrazione (non implementata)
 * Importa il suo modulo di routing
 *
 * @author Vittorio Valent
 */
var LoginModule = /** @class */ (function () {
    function LoginModule() {
    }
    LoginModule = __decorate([
        NgModule({
            declarations: [LoginComponent],
            imports: [
                CommonModule,
                LoginRoutingModule,
                FormsModule
            ]
        })
    ], LoginModule);
    return LoginModule;
}());
export { LoginModule };
//# sourceMappingURL=login.module.js.map
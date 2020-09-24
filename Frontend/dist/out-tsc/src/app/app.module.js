import { __decorate } from "tslib";
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModule } from './login/login.module';
import { HttpClientModule } from '@angular/common/http';
import { LayoutModule } from './layout/layout.module';
import { AdminModule } from './admin/admin.module';
import { UserService } from 'src/service/user.service';
import { ClientService } from 'src/service/client.service';
import { ItemService } from 'src/service/articoli.service';
import { UserModule } from './user/user.module';
/**
 * Modulo principale dell'applicazione. Qui vengono importati i moduli secondari. L'UNICA component
 * da dichiare qui è l'AppComponent, tutte le altre devono essere dichiarate nel loro modulo e questo importato
 * qui.
 *
 * @author Vittorio Valent
*/
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        NgModule({
            declarations: [
                AppComponent
            ],
            imports: [
                BrowserModule,
                AppRoutingModule,
                LoginModule,
                HttpClientModule,
                LayoutModule,
                AdminModule,
                UserModule
            ],
            providers: [
                UserService,
                ClientService,
                ItemService
            ],
            bootstrap: [AppComponent]
        })
    ], AppModule);
    return AppModule;
}());
export { AppModule };
//# sourceMappingURL=app.module.js.map